package oop;

import java.util.Scanner;
import java.util.Random;

class NumberGuessGame {
    private int number;
    private int attempts;

    public NumberGuessGame() {
        Random random = new Random();
        number = random.nextInt(100);
    }

    public void play() {
        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int userInput = getUserInput();
            attempts++;

            if (isCorrectNumber(userInput)) {
                System.out.println("Congratulations! Your guess is correct. The number was " + number);
                System.out.println("You attempted " + attempts + " times.");
                break;
            }
        }
    }

    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess: ");
        int userInput = scanner.nextInt();
        return userInput;
    }

    private boolean isCorrectNumber(int userInput) {
        if (userInput == number) {
            return true;
        } else if (userInput > number) {
            System.out.println("Very High");
        } else {
            System.out.println("Very Low");
        }
        return false;
    }
}

public class ExerciseGuess {
    public static void main(String[] args) {
        NumberGuessGame game = new NumberGuessGame();
        game.play();
    }
}
