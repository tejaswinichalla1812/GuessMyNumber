package edu.nwmissouri.guessmynumber;

import javax.swing.*;

/**
 * “Guess a Number” game that allows user to guess a random number. Uses Swing
 * to make a nice graphical user interface.
 *
 * Original Source: https://hackr.io/blog/java-projects
 *
 * Read about jOptionPane:
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
 * .showInputDialog() .showMessageDialog()
 *
 * @author Tejaswini Challa
 */
public class GuessingGameChalla {

    public static void main(String[] args) {
        // TODO: change computerNumber to secretNumber Hint: Right-click / Refactor / Rename
        int secretNum = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + secretNum);
        int count = 1;

        while (userAnswer != secretNum) {
            // TODO: create 3 local variables for the arguments so we know what they mean
            // showInputDialog - the first argument is always null (no parent)
            
            String message = "Enter a guess between 1 and 100";// what type?
            String title = "Guessing Game"; // what type?
            int messageType = JOptionPane.INFORMATION_MESSAGE;
           
            String response = JOptionPane.showInputDialog(null,
                    "Enter a guess between 1 and 100", "Guessing Game", 3);
            userAnswer = Integer.parseInt(response);

            JOptionPane.showMessageDialog(null, "" + calculate(userAnswer, secretNum, count));
            count++;
        }
    }

    // TODO: Refactor / Rename determineGuess to calculateMessage
    public static String calculate(int userAnswer, int computerNumber, int count) {
        // TODO: Instead of "Try Number" which sounds like we should try that as a guess...
        // Say "You've used " + count + guesses.
        // If count is one, use "guess", else use "guesses" HINT: Ternary operator
        
        String s =(count == 1) ? "guess." : "guesses.";
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count + s;
        } else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nTry Number: " + count + s;
        } else {
            return "Your guess is incorrect\nTry Number: " + count;
        }
    }
}
