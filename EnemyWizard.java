public class EnemyWizard extends Wizard {
	
	private int fireswordStacks; //to keep track of times hit by fire sword spell.
	private boolean isSkipped;
	private int reverseBoostCount;
	private int bigBangCount;
	
	public EnemyWizard() { //calls the default constructor.
		super();
		fireswordStacks = 0;
		isSkipped = false;
		reverseBoostCount = 0;
		bigBangCount = 0;
	}
	//Accessors / Modifers
	public void skip(){
	    isSkipped = true;
	    reverseBoostCount += 1;
	}
	
	public int getReverseBoostCount(){
	    return reverseBoostCount;
	}
	
	public void addFireSwordStack(){
	    fireswordStacks++;
	}
	
	public int getFireSwordStacks(){
	    return fireswordStacks;
	}
	
	public void addBigBangCount(){
	    bigBangCount++;
	}
	
	public int getBigBangCount(){
	    return bigBangCount;
	}
	
	

	//Enemy spells below:
	public void potionSplash(PlayerWizard w) { //poisons PLAYER for next 2 terms
		w.dealDamage(3);
		w.inflictPoison(); //inflicts poison on the player.
	}

	public void venomousShards(PlayerWizard w) { //poisons target by 1.5x each attack | target gains 1.5% vulnerability for every stack of venemous shard on them. (for the rest of the match)
		w.dealDamage(8); //calls the dealDamage of the PlayerWizard class.
		w.increaseShardStack();
	}

	public void glizzyBomb(PlayerWizard w) { //deals 25% damage to target's current health
		int portionOfHealth = (int)(w.getHealth()*.25);
		w.dealDamage(portionOfHealth);
	}

	public void turn(PlayerWizard w) { //PLAYER passed in
        if (!isSkipped){
            System.out.println("[[Enemy turn.]]");    
        }
        
        else{
            System.out.println("Enemy turn skipped.");
            isSkipped = false; //take it off since its only one time per turn.
        }
        
	}
	
	

	public void attack(PlayerWizard w) { //Passes in PLAYER
		int number = (int)(Math.random() * 3) + 1; //random num from 1-3

		if(number == 1) {
			potionSplash(w);
		}

		else if(number == 2) {
			venomousShards(w);
		}

		else if(number == 3) {
			glizzyBomb(w);
		}

		else {
			System.out.println("How did we get here.");
		}

	}
}
