import java.util.*;

public class Main {

	public static void main(String[] args) {
	int failsafe;
	String name;
	Scanner input = new Scanner(System.in); //scanner reads your output
	System.out.println("Hey, wizard! Choose a name and begin combat! : ");
	name = input.nextLine(); //ex. "Lola"

	failsafe = 0;

	PlayerWizard Player = new PlayerWizard(name,100,40);
	EnemyWizard Enemy = new EnemyWizard(); //default constructor. Name will always be "Logrith".

	while(Player.getHealth() > 0 && Enemy.getHealth() > 0 && failsafe <= 10) {
		Player.turn(Enemy); //player's turn. Passing in enemy as the target.
		Enemy.turn(Player); //enemy's turn. Passing in player as the target.
		
		System.out.println("------------------------------------------------");
      	System.out.println(Player);
      	System.out.println("- - - - - - - - - - - - - - - -");
      	System.out.println(Enemy);
      	System.out.println("------------------------------------------------");
      	failsafe++;
      	
      	if(Enemy.getHealth() < 0){
  	        System.out.println("You win!!!\nGood Job, " + Player.getName() + "!!!");
		}
		
		else if(Player.getHealth() < 0){
		    System.out.println("You lose!!!\nBetter luck next time, " + Player.getName() + "...");
		}
	}
}
}
