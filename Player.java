// importing a Scanner
import java.util.Scanner; 

/** 
* the player class
* @param number the number guessed by the user
*/
public class Player{

  public void guess(){

    // create a Scanner for user input
    Scanner input = new Scanner(System.in);

    // prints out a question for the user
    System.out.println("What number do you think is correct?");

    // stores the user's input
    int number = input.nextInt();

    // prints the user's input to the screen
    System.out.println("The number guessed is " + number);

  }
}