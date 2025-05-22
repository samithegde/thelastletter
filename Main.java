import java.io.*;
import java.util.*;

public class Main {
    public static void printHangman(int wrongGuesses){
        if (wrongGuesses == 0){
            System.out.println("   _____");
            System.out.println("  |/    |");
            System.out.println("  |    ");
            System.out.println("  |    ");
            System.out.println("  |    ");
            System.out.println("  |    ");
            System.out.println("  |");
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
        }
        else if (wrongGuesses == 1){
            System.out.println("   _____");
            System.out.println("  |/    |");
            System.out.println("  |    (¨)");
            System.out.println("  |    ");
            System.out.println("  |    ");
            System.out.println("  |    ");
            System.out.println("  |");
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
        }
        else if (wrongGuesses == 2){
            System.out.println("   _____");
            System.out.println("  |/    |");
            System.out.println("  |    (¨)");
            System.out.println("  |     |");
            System.out.println("  |     |");
            System.out.println("  |    ");
            System.out.println("  |");
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
        }
        else if (wrongGuesses == 3){
            System.out.println("   _____");
            System.out.println("  |/    |");
            System.out.println("  |    (¨)");
            System.out.println("  |    /|");
            System.out.println("  |     |");
            System.out.println("  |    ");
            System.out.println("  |");
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
        }
        else if (wrongGuesses == 4){
            System.out.println("   _____");
            System.out.println("  |/    |");
            System.out.println("  |    (¨)");
            System.out.println("  |    /|\\");
            System.out.println("  |     |");
            System.out.println("  |    ");
            System.out.println("  |");
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
        }
        else if (wrongGuesses == 5){
            System.out.println("   _____");
            System.out.println("  |/    |");
            System.out.println("  |    (¨)");
            System.out.println("  |    /|\\");
            System.out.println("  |     |");
            System.out.println("  |    / ");
            System.out.println("  |");
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
        }
        else {
            System.out.println("   _____");
            System.out.println("  |/    |");
            System.out.println("  |    (_)");
            System.out.println("  |    /|\\");
            System.out.println("  |     |");
            System.out.println("  |    / \\");
            System.out.println("  |");
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
        }
    }

    public static boolean hasPlayerWon(char[] wordStatus){
        for (int i = 0; i < wordStatus.length; i++){
            if (wordStatus[i] == '_'){
                return false;
            }
        }
        return true;
    }

    public static int[] playHangman(String[] wordSelection){
        Scanner input = new Scanner(System.in);
        
        int wordIndex = (int)(Math.random() * wordSelection.length);
        String correctWord = wordSelection[wordIndex];
        int[] toReturn = new int[2];
        int wrongGuesses = 0;
        char[] wrongLetters = new char[26];
        char[] wordStatus = new char[correctWord.length()];
        char letterGuess;
        boolean userWon = false;

        for (int i = 0; i < wordStatus.length; i++){
            wordStatus[i] = '_';
        }

        while (!userWon && wrongGuesses < 6){
            printHangman(wrongGuesses);
            System.out.println();
            for (int i = 0; i < wordStatus.length; i++){
                System.out.print(wordStatus[i]);
            }
            for (int i = 0; i < wrongGuesses; i++){
                System.out.print(wrongLetters[i] + " ");
            }

            System.out.print("Your Guess: ");
            String userGuess = input.nextLine().trim().toLowerCase();

            if (userGuess.length() == 1){
                letterGuess = userGuess.charAt(0);
                for (int i = 0; i < correctWord.length(); i++){
                    if (correctWord.charAt(i) == letterGuess){
                        wordStatus[i] = letterGuess;
                    }
                }
            }
            else {
                if (correctWord.equals(userGuess)){
                    userWon = true;
                }
                else { 
                    wrongGuesses++;
                }
            }
        }




    
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
      for(int i = 0; i <= 6; i++)
        {
          printHangman(i);
        }

      
    }
}

