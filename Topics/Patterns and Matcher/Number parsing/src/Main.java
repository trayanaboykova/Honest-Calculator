import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // optional sign, integer part (no leading zeros except "0"),
        // optional fractional part with '.' or ',' and no trailing zeros
        String regex = "^[-+]?(0|[1-9][0-9]*)([.,](0|[0-9]*[1-9]))?$";

        String number = scanner.nextLine();
        System.out.println(number.matches(regex) ? "YES" : "NO");
    }
}
