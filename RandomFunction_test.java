import java.util.Random;
import java.util.HashMap;

public class RollDiceTest {
    public static void main(String[] args) {
        Random random = new Random();
        HashMap<Integer, Integer> results = new HashMap<>();
        
        // Initialize the result map for dice numbers (1 to 6)
        for (int i = 1; i <= 6; i++) {
            results.put(i, 0);
        }

        // Roll the dice 1000 times
        for (int i = 0; i < 1000; i++) {
            int result = rollDice(random);
            results.put(result, results.get(result) + 1);
        }

        // Display the results
        for (int i = 1; i <= 6; i++) {
            System.out.println("Number " + i + " rolled " + results.get(i) + " times.");
        }
    }

    // Method to simulate rolling a die (1 to 6)
    public static int rollDice(Random random) {
        return random.nextInt(6) + 1;
    }
}
