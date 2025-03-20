public class EnemyWizard extends Wizard{
	public EnemyWizard(){ //calls the default constructor.
		super();
  }
  
  //Enemy spells below:
  public void potionSplash(Wizard w){ //poisons target for next 2 terms
  
  }
  
  public void venomousShards(Wizard w){ //poisons target by 1.5x each attack | target gains 1.5% vulnerability for every stack of venemous shard on them. (for the rest of the match)
  
  //venemousShardHits = 17;
  w.dealDamage(4)
  
  //PROTOTYPE CODE PLEASE DO NOT LOOK IM EMBARRASSED
  //dealDamage(int d){
  //int extraDamage = 0;
  //	if(venomousShardHits > 0){
  //  	extraDamage = d + (venemousShardHits * 1.5);
  //    health -= d + extraDamage;
  //  }
  //}
  
  }
  
  public void glizzyBomb(Wizard w){ //deals 25% damage to target's current health
  	
  }
}
