import java.util.*;

public class Main{
	
	private int failsafe;

	String name;
	Scanner input = new Scanner(System.in); //scanner reads your output
	System.out.println("Hey, wizard! Choose a name and begin combat! : ");
  name = input.nextLine(); //ex. "Lola"
	
  failsafe = 0;
  
  Wizard Player = new Wizard(name,100,40); //obj type, name, new keyword, obj type
	Wizard Enemy = new Wizard(); //default constructor. Name will always be "Logrith".
  
  while(Player.getHealth() > 0 && Enemy.getHealth() > 0 && failsafe <= 10){
  
  	failsafe++;
  }
  
}
