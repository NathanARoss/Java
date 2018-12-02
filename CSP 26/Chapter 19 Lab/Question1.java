/**
 * Reads input one line at a time from words.txt and displays the unique words it contains
 *
 * Written by Nathan Ross
 */

import java.io.*;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Question1 {
    private final static String filename = "words.txt";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));

            int lineNumber = 0;
            String line;
            while ((line = reader.readLine()) != null)  {
                String[] tokens = line.split(" ");

                Set<String> distinctWords = new TreeSet<>();
                Collections.addAll(distinctWords, tokens);

                System.out.printf("line %d contains unique words: %s%n", lineNumber, distinctWords);

                ++lineNumber;
            }
        }

        catch(FileNotFoundException e) {
            String workingDirectory = new File("").getAbsolutePath();
            System.out.printf("FileNotFoundException: %s\\%s not found", workingDirectory, filename);
        }

        catch (IOException e) {
            //I cannot handle any file errors except missing file errors
            e.printStackTrace();
        }
    }
}
