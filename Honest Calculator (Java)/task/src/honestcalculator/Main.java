package honestcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String msg_0 = "Enter an equation";
        String msg_1 = "Do you even know what numbers are? Stay focused!";
        String msg_2 = "Yes ... an interesting math operation. You've slept through all classes, haven't you?";

        while (true) {
            System.out.println(msg_0);
            String calc = scanner.nextLine();

            // Split input into 3 parts: x, oper, y
            String[] parts = calc.split(" ");
            if (parts.length != 3) {
                continue; // incorrect format, ask again
            }

            String xStr = parts[0];
            String oper = parts[1];
            String yStr = parts[2];

            double x, y;

            // Try to parse numbers
            try {
                x = Double.parseDouble(xStr);
                y = Double.parseDouble(yStr);
            } catch (NumberFormatException e) {
                System.out.println(msg_1);
                continue;
            }

            // Check operator validity
            if (!(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/"))) {
                System.out.println(msg_2);
                continue;
            }

            // If all valid, exit (END in flowchart)
            break;
        }
    }
}
