import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public interface FileInteraction {

    /**
     * Reads the given save file containing cards and their box subsets
     * and converts it into a deck of 5 boxes
     *
     * @param saveIn File to read
     * @return ArrayList<ArrayList < Flashcard>> deck
     */
    static ArrayList<ArrayList<Flashcard>> parseSave(File saveIn) {
        ArrayList<ArrayList<Flashcard>> deck = Box.setupBoxes(new ArrayList<>(5));
        String front = null, back = null;
        int box = 0;
        try {
            Scanner scan = new Scanner(saveIn);
            while (scan.hasNextLine()) {
                String temp = scan.nextLine();
                String[] tempArray;
                if (Objects.equals(temp, "1")) {
                    box = 0;
                } else if (Objects.equals(temp, "2")) {
                    box = 1;
                } else if (Objects.equals(temp, "3")) {
                    box = 2;
                } else if (Objects.equals(temp, "4")) {
                    box = 3;
                } else if (Objects.equals(temp, "5")) {
                    box = 4;
                } else if (temp.contains("|")) {
                    tempArray = temp.split("\\|");
                    front = tempArray[0];
                    back = tempArray[1];
                    deck.get(box).add(new Flashcard(front, back));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return deck;
    }

    /**
     * Imports a file containing only cards in text format to a deck
     *
     * @param fileIn File to import
     * @return ArrayList<ArrayList < Flashcard>> deck
     */
    static ArrayList<ArrayList<Flashcard>> importFile(File fileIn) {
        ArrayList<ArrayList<Flashcard>> deck = Box.setupBoxes(new ArrayList<>(5));
        String front, back;
        try {
            Scanner scan = new Scanner(fileIn);
            while (scan.hasNextLine()) {
                String temp = scan.nextLine();
                String[] tempArray;
                tempArray = temp.split("\\|");
                front = tempArray[0];
                back = tempArray[1];
                deck.get(0).add(new Flashcard(front, back));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return deck;
    }

    /**
     * Saves a given deck into a text file, separated by box "1 \n front|back"
     *
     * @param deck     2D ArrayList containing 5 boxes
     * @param saveName String value of the desired file name
     */
    static void saveToFile(ArrayList<ArrayList<Flashcard>> deck, String saveName) {
        File saveFile = new File(saveName + ".deck");
        int cBox = 0;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
            for (ArrayList<Flashcard> i : deck) {
                writer.write(++cBox + "\n");
                for (Flashcard j : i) {
                    writer.write(j.getFront() + "|" + j.getBack() + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
