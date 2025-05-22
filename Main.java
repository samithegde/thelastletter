import java.util.*;

public class Main {
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
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
            clearScreen();
            printHangman(wrongGuesses);

            System.out.print("Word: ");
            for (int i = 0; i < wordStatus.length; i++){
                System.out.print(wordStatus[i]);
            }
            System.out.println();
            System.out.println();

            System.out.print("Wrong Letters: ");
            for (int i = 0; i < wrongGuesses; i++){
                System.out.print(wrongLetters[i] + " ");
            }
            System.out.println();
    
            System.out.print("Your Guess: ");
            String userGuess = input.nextLine().trim().toLowerCase();

            if (userGuess.length() == 1){
                letterGuess = userGuess.charAt(0);
                boolean letterFound = false;
                for (int i = 0; i < correctWord.length(); i++){
                    if (correctWord.charAt(i) == letterGuess){
                        wordStatus[i] = letterGuess;
                        letterFound = true;
                    }
                }
                if (!letterFound){
                    wrongGuesses++;
                    wrongLetters[wrongGuesses - 1] = letterGuess;
                }
            }
            else {
                if (correctWord.equals(userGuess)){
                    userWon = true;
                    toReturn[0] = 0;
                    toReturn[1] = wrongGuesses;
                    return toReturn;
                }
                else { 
                    wrongGuesses++;
                }
            }
            userWon = hasPlayerWon(wordStatus);
        }
        if (wrongGuesses >= 6){
                toReturn[0] = 1;
                toReturn[1] = wrongGuesses;
        }
        return toReturn;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] forestWords = new String[] {"trees", "moss", "fern", "bark", "pine", "leaf","vines","roots", "birch", "maple", "spruce", "branch","canopy", "forest", "timber", "wildlife", "squirrel", "mushroom", "sapling", "nature", "acorns", "cedar", "jungle", "bamboo", "fallen", "hollow", "thicket", "woodland", "glade", "shade", "lichen", "stump", "treescape", "bushes", "caterpillar", "nest", "badger", "beetle", "cougar", "trail", "grove", "baobab"};
String[] oceanWords = new String[] {"sea", "marine", "smelt", "coral", "atlantic", "barnacle", "barracuda", "tidal", "shore", "beach", "wave", "aquatic", "seawater", "pacific", "arctic", "antarctic", "sealion", "saltwater", "freshwater", "ocean"};
	String[] desertWords = new String[] {"desert", "cactus", "sandy", "sahara","sandstone", "pyramid", "quartz", "shrubs", "sandstorm", "dunes", "camel", "vultures", "rattlesnake", "dragonfruit"};
	String[] coldWords = new String[] {"penguin", "glacier", "frozen", "tundra", "iceberg", "frost", "permafrost", "chill", "arctic", "frigid", "snow", "blizzard"};

        int[] gameResult = playHangman(forestWords);
        if (gameResult[0] == 0){
            // user won
        }
        else {
            // user lost
        }
        int score = gameResult[1];

      
    }
}

