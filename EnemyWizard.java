public class EnemyWizard extends Wizard{
	

	public EnemyWizard(){ //calls the default constructor.
		super();
  }
  
  //Enemy spells below:
  public void potionSplash(Wizard w){ //poisons target for next 2 terms
  	w.dealDamage(3);
    w.inflictPoison(); //inflicts poison on the player.
  }
  
  public void venomousShards(Wizard w){ //poisons target by 1.5x each attack | target gains 1.5% vulnerability for every stack of venemous shard on them. (for the rest of the match)
  	w.dealDamage(8); //calls the dealDamage of the PlayerWizard class.
    w.increaseShardStack();
  }
  
  public void glizzyBomb(Wizard w){ //deals 25% damage to target's current health
  	int portionOfHealth = (int)(w.getHealth()*.25);
    w.dealDamage(portionOfHealth);
  }
  
  public void turn(Wizard w){
  	
  }
  
  public void attack(Wizard w){
  	int number = (int)(Math.random() * 3) + 1; //random num from 1-3
    
    if(number == 1){
    	potionSplash(w);
    }
    
    else if(number == 2){
     venomousShards(w);
    }
    
    else if(number == 3){
    	glizzyBomb(w);
    }
    
    else{
    	System.out.println("How did we get here.");
    }
    
  }
}

