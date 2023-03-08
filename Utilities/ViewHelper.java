package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewHelper {
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printHeader(String title) {
        printSeparator(25);
        System.out.println(title);
        printSeparator(25);
    }

    public static void printLogo() {
        //Resource: https://stackoverflow.com/questions/15695984/java-print-contents-of-text-file-to-screen
        try {
            BufferedReader br = new BufferedReader(new FileReader("Utilities/SnSLogo.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMainMenu() {
        System.out.println("Please select an option to continue.");
        System.out.println("1. Reroll Character.");
        System.out.println("2. Enter Arena.");
        System.out.println("3. Quit");
    }
}
