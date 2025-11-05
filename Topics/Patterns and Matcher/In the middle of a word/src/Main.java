import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        // (?i) — case insensitive
        // \b\w+ — match each word (letters only)
        Pattern wordPattern = Pattern.compile("(?i)\\b[a-zA-Z]+\\b");
        Matcher matcher = wordPattern.matcher(line);

        String lowerPart = part.toLowerCase();
        boolean found = false;

        while (matcher.find()) {
            String word = matcher.group().toLowerCase();

            // word must contain the part but NOT at start or end
            if (word.contains(lowerPart)
                    && !word.startsWith(lowerPart)
                    && !word.endsWith(lowerPart)) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "YES" : "NO");
    }
}
