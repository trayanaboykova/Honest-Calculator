import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();

        // Regex for a valid IP address (0–255 in each group)
        String ipRegex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

        if (ip.matches(ipRegex)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
