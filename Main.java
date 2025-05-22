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
    
    public static void main(String[] args) {
      
      for(int i = 0; i <= 6; i++)
        {
          printHangman(i);
        }

      
    }
}

