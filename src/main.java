import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class main {

    private static ArrayList<Character> gameList;
    private static ArrayList<Character> guessList;

    public static void init(String filename) {
        try {
            int index = 0;
            Scanner scan = new Scanner(new File(filename));
            ArrayList<String> arrayList = new ArrayList<>();
            while(scan.hasNextLine()) {
                arrayList.add(index, scan.nextLine());
                index++;
            }
            int random = (int) (Math.random() * arrayList.size());
            gameList = new ArrayList<>();

            for(int i = 0; i < arrayList.get(random).length(); i++) {
                gameList.add(i, arrayList.get(random).charAt(i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void gameLoop() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to play hangman? (y/n)");
        String userInputInital = scan.next().toLowerCase();

        while(true){
            if(userInputInital.equals("y")) {
                init("words");
                int counter = 0;
                int numberOfTries = gameList.size() * 3;
                guessList = new ArrayList<>();
                for (int i = 0; i < gameList.size(); i++) {
                    guessList.add(i, '_');
                }
                while(counter != gameList.size()*3) {
                    System.out.println(guessList + "\nOk now take your guesses to the characters! You have " + numberOfTries + " tries!");
                    char c = scan.next().charAt(0);
                    for(int i = 0; i < gameList.size(); i++) {
                        if(guessList.get(i).equals(c)){
                            System.out.println("already guessed! " + guessList.get(i) + "!");
                        }
                        else if(gameList.get(i).equals(c)) {
                            guessList.set(i, gameList.get(i));
                        }
                    }
                    if(gameList.equals(guessList)) {
                        System.out.println("You won");
                        System.exit(1);
                    }
                    counter++;
                    numberOfTries--;
                }
            }
            if(userInputInital.equals("n")) {
                System.exit(1);
            }
        }
    }


    public static void main(String[] args) {
        gameLoop();
    }
}

