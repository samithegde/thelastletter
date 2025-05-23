import java.util.*;

public class Main {
    
    
    /**
     * This method clears the console, making the user experience neater.
     */
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * This method prints the hangman visual based on how many incorrect guesses were already made.
     * @param wrongGuesses The number of wrong guesses made by the user.
     */
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


    /**
     * This method checks if all the letters have been revealed.
     * @param wordStatus Array containing the revealed/unrevealed letters in the word; "_" if unrevealed.
     * @return True if all the letters have been revealed, false otherwise.
     */
    public static boolean hasPlayerWon(char[] wordStatus){
        
        // The player wins if all letters have been revealed (i.e. none of the characters are "_").
        for (int i = 0; i < wordStatus.length; i++){
            if (wordStatus[i] == '_'){
                return false;
            }
        }
        return true;
    }

    /**
     * This method simulates a hangman game.
     * @param wordSelection The array of words to select from, depending on the biome.
     * @param biome The biome chosen by the user.
     * @return Use int array to return two values: Index 0 contains win(0) or loss(1), and Index 1 contains user's score.
     */
    public static int[] playHangman(String[] wordSelection, String biome){
        Scanner input = new Scanner(System.in);
        
        // Get a random number from the array of given words
        int wordIndex = (int)(Math.random() * wordSelection.length); 
        String correctWord = wordSelection[wordIndex];

        int[] toReturn = new int[2]; // Index 0 contains win(0) or loss(1); Index 1 contains user's score (number of wrong guesses)
        char[] wordStatus = new char[correctWord.length()];  // To be printed under the hangman visual
        char[] wrongLetters = new char[26]; // Bank of incorrect letters
        int wrongGuesses = 0;

        // Set all the letters to "_", indicating that the letter has not be revealed
        for (int i = 0; i < wordStatus.length; i++){
            wordStatus[i] = '_';
        }

        // Run while there are still unrevealed letters and the user still has guesses
        while (!hasPlayerWon(wordStatus) && wrongGuesses < 6){
            
            clearScreen();
            System.out.println("Biome: " + biome + "\n");
            printHangman(wrongGuesses);

            // Print out the revealed letters
            System.out.print("Word: ");
            for (int i = 0; i < wordStatus.length; i++){
                System.out.print(wordStatus[i]);
            }
            System.out.println();
            System.out.println();

            // Print out the previously guessed incorrect letters
            System.out.print("Wrong Letters: ");
            for (int i = 0; i < wrongGuesses; i++){
                System.out.print(wrongLetters[i] + " ");
            }
            System.out.println();
    

            System.out.print("Your Guess: ");
            String userGuess = input.nextLine().trim().toLowerCase(); // Remove whitespace and convert to lowercase for consistency


            if (userGuess.length() == 1){
                char letterGuess = userGuess.charAt(0);
                boolean letterFound = false;


                for (int i = 0; i < correctWord.length(); i++){
                    if (correctWord.charAt(i) == letterGuess){
                        wordStatus[i] = letterGuess;
                        letterFound = true;
                    }
                }


                if (!letterFound){
                    boolean alreadyGuessed = false;
                    
                    
                    for (int i = 0; i < wrongGuesses; i++){
                        if (wrongLetters[i] == letterGuess){
                            alreadyGuessed = true;
                        }
                    }
                    

                    if (!alreadyGuessed){
                        wrongGuesses++;
                        wrongLetters[wrongGuesses - 1] = letterGuess;
                    }
                }
            }

            else {
                if (correctWord.equals(userGuess)){
                    toReturn[0] = 0;
                    toReturn[1] = wrongGuesses;

                    clearScreen();
                    printHangman(wrongGuesses);
                    System.out.println("You win! The word was " + correctWord + ".");

                    return toReturn;
                    
                }
                else { 
                    wrongGuesses++;
                }
            }
        }
        
        clearScreen();
        printHangman(wrongGuesses);

        if (wrongGuesses >= 6){
            toReturn[0] = 1;
            System.out.println("You lost! The word was " + correctWord + ". Better luck next time!");
        }

        else {
            System.out.println("You win! The word was " + correctWord + ".");
        }

        toReturn[1] = wrongGuesses;
        
        return toReturn;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] forestWords = new String[] {"trees", "moss", "fern", "bark", "pine", "leaf","vines","roots", "birch", "maple", "spruce", "branch","canopy", "forest", "timber", "wildlife", "squirrel", "mushroom", "sapling", "nature", "acorns", "cedar", "jungle", "bamboo", "fallen", "hollow", "thicket", "woodland", "glade", "shade", "lichen", "stump", "treescape", "bushes", "caterpillar", "nest", "badger", "beetle", "cougar", "trail", "grove", "baobab"};
String[] oceanWords = new String[] {"sea", "marine", "smelt", "coral", "atlantic", "barnacle", "barracuda", "tidal", "shore", "beach", "wave", "aquatic", "seawater", "pacific", "arctic", "antarctic", "sealion", "saltwater", "freshwater", "ocean"};
	String[] desertWords = new String[] {"desert", "cactus", "sandy", "sahara","sandstone", "pyramid", "quartz", "shrubs", "sandstorm", "dunes", "camel", "vultures", "rattlesnake", "dragonfruit"};
	String[] coldWords = new String[] {"penguin", "glacier", "frozen", "tundra", "iceberg", "frost", "permafrost", "chill", "arctic", "frigid", "snow", "blizzard"};


        int highScore = 0;
        int[] gameResult = playHangman(forestWords, "Forest");
        if (gameResult[0] == 0){
            // user won
        }
        else {
            // user lost
        }
        int score = gameResult[1];
        
        if (score > highScore){
            highScore = score;
        }

      
    }
}

