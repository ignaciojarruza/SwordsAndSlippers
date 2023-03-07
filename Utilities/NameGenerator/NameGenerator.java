package Utilities.NameGenerator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class NameGenerator {
    public NameGenerator() {

    }
    private static Random random = new Random();

    public static String generateName() {
        try {
            List<String> prefixLines = Files.readAllLines(Paths.get("prefixes.txt"), Charset.forName("UTF-8"));
            List<String> sufixLines = Files.readAllLines(Paths.get("suffixes.txt"), Charset.forName("UTF-8"));
            String[] prefixes = prefixLines.toArray(new String[prefixLines.size()]);
            String[] suffixes = sufixLines.toArray(new String[sufixLines.size()]);
            String prefix = prefixes[random.nextInt(prefixes.length)];
            String suffix = suffixes[random.nextInt(prefixes.length)];
            return prefix + suffix;
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
