import java.util.Scanner; 

/**
* Creates the game
* @author Dafna
*/
public class GuessGame {

  // create a Scanner for user input
  Scanner input = new Scanner(System.in);

  // The players of the game
  Player player1;
  Player player2;
  // Create the counter that will count the total times of guessing ( how many times was the number guessed)
  int counter;


  /**
  * Thr start game method starts the actual game
  * @param counter the counter of the round
  * @param Player 1 the first player
  * @param Player2 the second player
  * @param guessPlayer1 the guess of the first player
  * @param guessPlayer2 the guess of th second player
  * @param player1GuessedRight whether player 1 gueesed right or not
  * @param player2GuessedRight whether player 2 gueesed right or not
  */
  // The game starts
  public void startGame(){
    // counter's set to 0.
    counter = 0;

    // Create the new players
    player1 = new Player();
    player2 = new Player();
    
    // initialize the guessing value of each player and set it to 0
    int guessPlayer1 = 0;
    int guessPlayer2 = 0;

    // set both players to be wrong at the start of the game
    boolean player1GuessedRight = false;
    boolean player2GuessedRight = false;

    // generate a random number and set it to be the targetNumber.
    double randomNumber = (Math.random()*100);
    int targetNumber = (int) randomNumber;

    System.out.println("Before we start the game, lets discuss the rules! you can choose any number between 0 and 100! Just type it and press enter on your keyboard!");
    
      // while the game is on and no winner is found
      while(true){
        // add 1 to the counter to keep track of the number of tries
        counter++;

        // prints out the random number that is the target number
        System.out.println("Lets start guessing the numbers!");

        // "Send" the players to the Player class so they can guess anumber
        player1.guess();
        player2.guess();

        // use an if statement to determine whether the guessed value matches the target value
        // if so, change the boolean player1GuessedRight into true
        if(guessPlayer1 == targetNumber){

          player1GuessedRight = true;

        }else if(guessPlayer2 == targetNumber){
          // if player2GuessedRight, change the boolean player2GuessedRight into true
          player2GuessedRight  = true;
        } 
        // if there is a match, determine the winner and the number of guesses
        if (player1GuessedRight){

          System.out.println("We have a winner!!!");
          System.out.println("The winner is Player 1!");
          System.out.println("The number of totall guesses is " + counter);
          break;
        }else if(player2GuessedRight){

          System.out.println("We have a winner!!!");
          System.out.println("The winner is Player 2!");
          System.out.println("The number of totall guesses is " + counter);
          break;

        }else{
          // if no winner is found (no matching guess) this will be printed on the screen
          System.out.println("No winner is found! Try again until you win!");
          
          // the user will have an option bt getting a hint or not 
          System.out.println("looks like you are a litte off with your guesses... would you like a hint? (1 for yes / 2 for no)");

          // stores the users answer as an integer
          int answer = input.nextInt();
          
          // if the answer is yes, a hint will be given
          if(answer == 1){
            System.out.println("Dont worry, we got you covered!");

            // determine the range, could be any possible number. i decided to go in jums of 10
            int counterForHint = 100 - 10 * counter;

            // determine the range of the random value picked in the guess game by the computer
            if (targetNumber > counterForHint){
              //print this to the screen if the value is greater than the round number
              System.out.println("You are looking for a number greater than " + counterForHint);

            }else if(targetNumber < counterForHint){
              // print this to the screen if the value is smaller than the counter
              System.out.println("You are looking for a number smaller than " + counterForHint);

            }else{
              // if the value is not greater than counterForHint, or smaller than counterForHint, it has to be counterForHint.
              System.out.println("You are lucky! The number you look for is " + counterForHint);

            }

          }else{
            // if user chose to not get help, print this on the screen
            System.out.println("Okay then! keep on tying on your own!");
          }
        }  
      } 
  }
}