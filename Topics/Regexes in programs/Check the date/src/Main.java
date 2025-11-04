import java.util.*;

class Date {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();

        // yyyy-mm-dd  OR  dd-mm-yyyy
        // year: 1900–2099, month: 01–12, day: 01–31, separators: - / .
        String dateRegex =
                "^(?:(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[0-2])[-/.](?:0[1-9]|[12]\\d|3[01])"
                        + "|(?:0[1-9]|[12]\\d|3[01])[-/.](?:0[1-9]|1[0-2])[-/.](?:19\\d{2}|20\\d{2}))$";

        System.out.println(date.matches(dateRegex) ? "Yes" : "No");
    }
}
