import java.util.Random;
import javax.swing.JOptionPane;
public class Guess{
public static void main(String[] args) {
        // Define the range of numbers and the number of attempts allowed
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 100;
        final int MAX_ATTEMPTS = 10;
// Generate a random number within the range
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;

        // Initialize the score and the number of attempts
        int score = 0;
        int attempts = 0;

        // Start the game loop
        while (attempts < MAX_ATTEMPTS) {
            // Prompt the user to enter their guess
            String guessString = JOptionPane.showInputDialog(
                "Guess the number between " + MIN_NUMBER + " and " + MAX_NUMBER
                + "\nAttempts left: " + (MAX_ATTEMPTS - attempts)
                + "\nScore: " + score
            );

            // Parse the guess as an integer
            int guess;
            try {
                guess = Integer.parseInt(guessString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                continue;
            }

            // Check if the guess is within the range
            if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between "
                    + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                continue;
            }

            // Increment the number of attempts
            attempts++;

            // Check if the guess matches the random number
            if (guess == randomNumber) {
                score += (MAX_ATTEMPTS - attempts + 1) * 10; // Give more points for fewer attempts
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in "
                    + attempts + " attempts.\nYour score is " + score + ".");
                break;
            }

            // Give a hint whether the guess is higher or lower than the random number
            String hint = (guess < randomNumber) ? "higher" : "lower";
            JOptionPane.showMessageDialog(null, "Wrong answer. The number is " + hint + ".");
        }

        // If the user runs out of attempts, reveal the random number
        if (attempts == MAX_ATTEMPTS) {
            JOptionPane.showMessageDialog(null, "Game over. The number was " + randomNumber
                + ".\nYour score is " + score + ".");
        }
    }

}