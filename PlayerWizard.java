import java.util.*;
public class PlayerWizard extends Wizard {

	Scanner input;
	private int choice;

	private int turnsPoisoned; //The amount of turns the player has been poisoned for. Will decrease after each time poison hits at start of turn.
	private int stacksOfVenomousShards; //The amount of times player has been hit by venemous shards.


	public PlayerWizard(String n, int h, int m) { //Only ever uses overloaded constructor
		super(n,h,m);
		input = new Scanner(System.in);
		turnsPoisoned = 0;
		stacksOfVenomousShards = 0;
	}

	//Modifiers
	public void inflictPoison() {
		turnsPoisoned = 2; //set the poison equal to two.
		System.out.println(this.getName() + " has been ailed with poison. This will last for two turns.");
	}

	public void increaseShardStack() {
		stacksOfVenomousShards += 1;
		System.out.println(this.getName() + " has gained another stack of venomous shards. Damage taken increased by an additional 1.5%");
	}

	@Override  //purely because we need to check for the Venomous Shard stacks and act accordingly. The superclass cannot access these attributes.
	public void dealDamage(int n) {
		//fill in
	}



	public void turn(EnemyWizard w) {
		//check if they are poisoned. If so, deal the poison damage and then remove a stack of the turnsPoisoned.
		if(turnsPoisoned > 0) { //if player is still poisoned...
			this.dealDamage(5); //deals 5 damage from poison.
			this.turnsPoisoned -= 1;
			System.out.println(this.getName() + " takes 5 damage from poison! Poisoned for " + this.turnsPoisoned + " more turns!");
		}

		System.out.println("Please choose an option:\n1 - Attack\n2 - choice2\n3 - choice3");
		choice = input.nextInt();

		if(choice == 1) { //If they want to attack...
			attack(w);
		}

		else if(choice ==2) {
			//do whatever choice 2 is
		}

		else if(choice == 3) {
			//do whatever choice 3 is
		}

	}

	public void attack(EnemyWizard w) { //uses scanner to read input. Ex. if input == 1: do reverseBoost, if input == 2: do fireSword, if input == 3: do bigBang
		System.out.println("Attack Options:\n\t1 - Reverse Boost (10 mana)\n\t2 - Fire Sword (6 mana)\n\t3 - Big Bang (14 mana)");
		choice = input.nextInt();

		if(choice == 1) {
			reverseBoost(w);
		}

		else if(choice == 2) {
			fireSword(w);
		}

		else if(choice == 3) {
			bigBang(w);
		}
	}

	//FINISHED
	public void reverseBoost(EnemyWizard w) { //skips target's turn | Increases your health by 10% every 3rd attack
		if(this.getMana() >= 10) {
			this.useMana(10);
			w.skip(); //skips the enemy's turn.
			if(w.getReverseBoostCount() / 3 == 0) { //if the amount of times hit is divisible by 3...
				this.addHealth((int)(this.getHealth() * .10));
			}
		}
		else {
			System.out.println("Failed to use reverse boost due to lack of mana.");
		}
	}

	//FINISHED
	public void fireSword(EnemyWizard w) { //Increases firesword damage to target by 20% per time hit
		if(this.getMana() >= 6) {
			this.useMana(6);
			final int damage = 8;
			double damagePercentage = 1 + (.20 * w.getFireSwordStacks());
			int finalDamage = (int)(damage * damagePercentage);
			w.dealDamage(finalDamage);
			w.addFireSwordStack(); //doing it at the end so that it doesnt start with the 20% buff
			System.out.println("Firesword stacks on " + w.getName() + " has been increased to " + w.getFireSwordStacks());
		}

		else {
			System.out.println("Tried to use Fire Sword but failed due to lack of mana.");
		}
	}

	//FINISHED
	public void bigBang(EnemyWizard w) { //deals 20% damage of target's current health | deals 35% every 3 runs

		if(this.getMana() >= 14) {
		    this.useMana(14);
			int portionOfHealth = (int)(w.getHealth() * .20); //returns 20% of wizards current health
			if(w.getBigBangCount()/3 == 0) {
				portionOfHealth = (int)(w.getHealth() * .35);
				w.dealDamage(portionOfHealth);
			}

			else {
				w.dealDamage(portionOfHealth); //deal that portion of damage to the enemy wizard
			}
		}
		else {
			System.out.println("Tried to use Big Bang but failed due to lack of mana.");
		}

	}


}
