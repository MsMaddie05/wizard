public class Wizard {

	//Variables
	private String name;
	private int health;
	private int mana;
	private boolean hasActed;

	public Wizard() {
		name = "Logrith";
		health = 100;
		mana = 40;
	}

	public Wizard(String n, int h, int m) {
		name = n;
		health = h;
		mana = m; //currency baby
	}

	public final String getName() {
		return name;
	}

	public final int getHealth() {
		return health;
	}

	public final int getMana() {
		return mana;
	}
	
	public final void useMana(int n){
	    this.mana -= n;
	}
	
	public final void addHealth(int n){
	    this.health+=n;
	}

	@Override //tag
	public final String toString() { //System.out.println(Player);
		return this.name + " | HP : " + this.health + " | Mana : " + this.mana; //works
	}

	/*public final void wait(int s) {
		int timer = s * 1000;
		try {
			Thread.sleep(timer); //pauses your code for (timer) amount of milliseconds
		}
		catch(InterruptedException e) {
			throw(e);
		}
	}*/

	public void dealDamage(int n) {
		System.out.println(this.getName() + " takes " + n + " damage!");
		this.health -= n;
	}
}
