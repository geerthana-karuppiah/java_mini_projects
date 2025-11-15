import java.util.Random;//to get random number in dice
import java.util.Scanner;

public class BoardGame
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int position = 0;       // start
        final int FINISH = 20;  // end point

        System.out.println("Welcome to Simple Snake and Ladder!");
        System.out.println("Reach position " + FINISH + " to win!");
        

        while (position < FINISH) 
        {
            System.out.print("Press ENTER to roll dice...");
            sc.nextLine();

            int dice = random.nextInt(6) + 1; // 1 to 6
            System.out.println("You rolled: " + dice);

            position += dice;
            if (position > FINISH)
            {
                position = FINISH; // stop at finish line
            }

            // Snake
            if (position == 14)
            {
                System.out.println("Snake bite! Go back to 7");
                position = 7;
            }

            // Ladder
            if (position == 5) 
            {
                System.out.println("You found a ladder! Climb to 10");
                position = 10;
            }

            System.out.println("You are now at position: " + position + "\n");
        }

        System.out.println("Congratulations! You won the game!");
       
    }
}

