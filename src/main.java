import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void playGame(String filename) {
        try {
            int index = 0;
            Scanner scan = new Scanner(new File(filename));
            ArrayList<String> arrayList = new ArrayList<>();
            while(scan.hasNextLine()) {
                arrayList.add(index, scan.nextLine());
                index++;
            }
            int random = (int) (Math.random() * arrayList.size());
            System.out.println(arrayList.get(random));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        playGame("words");
    }
}

