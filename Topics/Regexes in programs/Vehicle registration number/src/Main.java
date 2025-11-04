import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine(); // input registration number

        // Regex: 1 letter from the set, 3 digits, then 2 letters from the set
        String pattern = "^[ABEKMHOPCTYX]\\d{3}[ABEKMHOPCTYX]{2}$";

        System.out.println(regNum.matches(pattern));
    }
}
