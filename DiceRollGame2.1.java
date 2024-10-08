import java.util.Random;
import java.util.Scanner;


public class DiceRollGame2 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int player1Total = 0;
        int player2Total = 0;
        boolean player1LastRollWasDoubleSix = false;
        boolean player2LastRollWasDoubleSix = false;

        // Game loop
        while (true) {
            // Player 1's turn
            System.out.println("Player 1, press enter to roll the dice...");
            scanner.nextLine();
            player1Total = playerTurn(random, "Player 1", player1Total);
            if (player1Total >= 40) {
                if (player1LastRollWasDoubleSix) {
                    System.out.println("Player 1 wins with two 6s in a row!");
                    break;
                }
                player1LastRollWasDoubleSix = false;
            }

            // Player 2's turn
            System.out.println("Player 2, press enter to roll the dice...");
            scanner.nextLine();
            player2Total = playerTurn(random, "Player 2", player2Total);
            if (player2Total >= 40) {
                if (player2LastRollWasDoubleSix) {
                    System.out.println("Player 2 wins with two 6s in a row!");
                    break;
                }
                player2LastRollWasDoubleSix = false;
            }
        }
    }

    // Player's turn logic
    public static int playerTurn(Random random, String playerName, int currentTotal) {
        boolean isExtraTurn = true;

        while (isExtraTurn) {
            int die1 = rollDice(random);
            int die2 = rollDice(random);
            int rollTotal = die1 + die2;

            System.out.printf("%s rolled: %d and %d, Total Roll: %d%n", playerName, die1, die2, rollTotal);

            if (die1 == 1 && die2 == 1) {
                System.out.printf("%s rolled two 1s! They lose all points!%n", playerName);
                return 0; // Lose all points
            } else if (die1 == die2) {
                currentTotal += rollTotal;
                System.out.printf("%s rolled doubles! Total: %d%n", playerName, currentTotal);
                isExtraTurn = true; // Get another turn
            } else {
                currentTotal += rollTotal;
                System.out.printf("%s's Total: %d%n", playerName, currentTotal);
                isExtraTurn = false; // End turn
            }

            if (die1 == die2) {
                if (currentTotal >= 40) {
                    System.out.printf("%s wins with doubles!%n", playerName);
                    System.exit(0); // End the game
                }
            }
        }
        return currentTotal; // Return updated total
    }

    // Method to simulate rolling a die (1 to 6)
    public static int rollDice(Random random) {
        return random.nextInt(6) + 1; // Generates a random number between 1 and 6
    }
}
