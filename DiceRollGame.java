import java.util.Random;

public class DiceRollGame {
    public static void main(String[] args) {
        // Create a random number generator
        Random random = new Random();
        int player1Total = 0;
        int player2Total = 0;

        // Continue rolling until one player's total reaches at least 40
        while (player1Total < 40 && player2Total < 40) {
            // Roll the dice for both players
            int player1Roll = rollDice(random);
            int player2Roll = rollDice(random);

            // Update totals
            player1Total += player1Roll;
            player2Total += player2Roll;

            // Print the results of the roll
            System.out.printf("Player 1 rolled: %d, Total: %d%n", player1Roll, player1Total);
            System.out.printf("Player 2 rolled: %d, Total: %d%n", player2Roll, player2Total);
            System.out.println("------------------------------");
        }

        // Determine the winner
        if (player1Total >= 40) {
            System.out.println("Player 1 wins with a total of: " + player1Total);
        } else {
            System.out.println("Player 2 wins with a total of: " + player2Total);
        }
    }

    // Method to simulate rolling a die (1 to 6)
    public static int rollDice(Random random) {
        return random.nextInt(6) + 1; // Generates a random number between 1 and 6
    }
}