import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        int userGuess;
        int attempts = 0;
        boolean isNumberGuessed = false;

        Scanner scanner = new Scanner(System.in);

        while (!isNumberGuessed) {
            System.out.print("Enter your guess (1-100): ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                isNumberGuessed = true;
                System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                System.out.println("It took you " + attempts + " attempts.");
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        }

        scanner.close();
    }
}
