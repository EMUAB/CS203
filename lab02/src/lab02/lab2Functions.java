package lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class lab2Functions {
	public static void main(String args[]) {
		// Runs all the methods
		fileAnalyze();
		sec2Days(Integer.valueOf(args[0]));
		consonantCount(args[1]);
	}

	public static void fileAnalyze() {
		// Finds the inputFile at src\lab02\assets and adds each number to an ArrayList
		String fileIn = "src\\lab02\\assets\\inputFile.txt";
		File inputFile = new File(fileIn);
		ArrayList<Integer> fileNumbers = new ArrayList<Integer>();

		try {
			Scanner readInput = new Scanner(inputFile);
			while (readInput.hasNextLine()) {
				String stringNums = readInput.nextLine();
				int numbers = Integer.parseInt(stringNums);
				fileNumbers.add(numbers);
			}
			readInput.close();
		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
			e.printStackTrace();
		}

		// Finds the lowest number
		int lowestEntry = fileNumbers.get(0);
		for (int k = 1; k < fileNumbers.size(); k++) {
			if (fileNumbers.get(k) <= lowestEntry) {
				lowestEntry = fileNumbers.get(k);
			}
		}

		// Finds the highest number
		int highestEntry = fileNumbers.get(0);
		for (int j = 1; j < fileNumbers.size(); j++) {
			if (fileNumbers.get(j) >= highestEntry) {
				highestEntry = fileNumbers.get(j);
			}
		}

		// Finds the average of all the numbers
		int totalEntry = 0;
		int avgEntry = 0;
		for (int j = 0; j < fileNumbers.size(); j++) {
			totalEntry = totalEntry + fileNumbers.get(j);
		}
		avgEntry = totalEntry / fileNumbers.size();

		// Writes all the numbers and the avg, highest, and lowest to new outputFile
		String fileOut = "outputFile.txt";
		File outputFile = new File(fileOut);
		try {
			if (outputFile.createNewFile()) {
				FileWriter writer = new FileWriter(fileOut);
				for (int i = 0; i < fileNumbers.size(); i++) {
					writer.write(fileNumbers.get(i) + "\n");
				}
				writer.write("****************\n");
				writer.write("There are " + fileNumbers.size() + " numbers in this file\n");
				writer.write("The minimum number is " + lowestEntry + "\n");
				writer.write("The maximum number is " + highestEntry + "\n");
				writer.write("The average is " + avgEntry);
				writer.close();
			} else {
				System.out.println("The file already exists");
				return;
			}
			
		// Catches any errors thrown when dealing with reading, creating, or writing to a file
		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was an error");
			e.printStackTrace();
		}
	}

	public static void sec2Days(int secondsIn) {
		double days = secondsIn / 86400;
		double hours = (secondsIn - ((int) days * 86400)) / 3600;
		double minutes = (secondsIn - (((int) hours * 3600) + (int) days * 86400)) / 60;
		double seconds = (secondsIn - (((int) hours * 3600) + ((int) days * 86400) + ((int) minutes * 60)));
		System.out.printf("%d : %02d : %02d : %02d\n", (int) days, (int) hours, (int) minutes, (int) seconds);
		return;
	}

	public static void consonantCount(String wordsIn) {
		int totalConsonants = 0;
		String wordsLower = wordsIn.toLowerCase();

		// Checks if each character is not a letter then if it is a vowel, if both fail then it is added to the count 
		for (int i = 0; i < wordsLower.length(); i++) {
			char cLetter = wordsLower.charAt(i);
			if (Character.isLowerCase(cLetter)) {
				if (cLetter == 97 || cLetter == 101 || cLetter == 105 || cLetter == 111 || cLetter == 117 || cLetter == 121) {
					continue;
				} else {
					totalConsonants++;
				}
			}
		}
		System.out.println(totalConsonants);
	}
}
