import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSum {
    public static void main(String[] args) {
        try {
            // Init objects needed for file i/o
            PrintWriter fileOut = new PrintWriter("output.txt");
            File fileIn = new File("tester.txt");
            Scanner scan = new Scanner(fileIn);

            // Get each line, split it by the commas and add the remaining ints together
            int lineTotal = 0;
            String[] lineArray;
            do {
                lineArray = scan.next().split(",");
                for (String i : lineArray) {
                    lineTotal += Integer.valueOf(i);
                }
                fileOut.println(lineTotal);
                lineTotal = 0;
            } while (scan.hasNext());

            scan.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
