package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
}
