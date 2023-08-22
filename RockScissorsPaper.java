package oop;

import java.util.Scanner;
import java.util.Random;

public class RockScissorsPaper {
    public static void main(String[] args) {
        // Variable declaration
        // 1 = Rock, 2 = Paper, 3 = Scissors
        System.out.println("1 for Rock\n2 for Paper\n3 for Scissors\nEnter your chosen number:");
        
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        sc.close();
        
        Random random = new Random();
        int computerInput = random.nextInt(3) + 1;
        
        // User's choice
        String[] choices = {"Rock", "Paper", "Scissors"};
        if (userInput >= 1 && userInput <= 3) {
            System.out.println("You chose " + choices[userInput - 1]);
        } else {
            System.out.println("Invalid choice");
            return;
        }
        
        // Computer's choice
        System.out.println("Computer chose " + choices[computerInput - 1]);
        
        // Winner declaration
        if (userInput != computerInput) {
            if ((userInput == 1 && computerInput == 3) || (userInput == 2 && computerInput == 1) || (userInput == 3 && computerInput == 2)) {
                System.out.println("Congratulations! You won!");
            } else {
                System.out.println("Computer wins.");
            }
        } else {
            System.out.println("It's a tie!");
        }
    }
}
