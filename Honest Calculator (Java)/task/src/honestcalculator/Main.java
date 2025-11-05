package honestcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String msg_0 = "Enter an equation";
        String msg_1 = "Do you even know what numbers are? Stay focused!";
        String msg_2 = "Yes ... an interesting math operation. You've slept through all classes, haven't you?";
        String msg_3 = "Yeah... division by zero. Smart move...";

        while (true) {
            System.out.println(msg_0);
            String calc = scanner.nextLine();

            // Split input into 3 parts: x, oper, y
            String[] parts = calc.split("\\s+");
            if (parts.length != 3) {
                // Incorrect format, just ask again
                continue;
            }

            String xStr = parts[0];
            String oper = parts[1];
            String yStr = parts[2];

            float x;
            float y;

            // Try to parse numbers
            try {
                x = Float.parseFloat(xStr);
                y = Float.parseFloat(yStr);
            } catch (NumberFormatException e) {
                System.out.println(msg_1);
                continue;
            }

            // Check operator validity
            if (!(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/"))) {
                System.out.println(msg_2);
                continue;
            }

            float result;

            // Do the calculation
            switch (oper) {
                case "+":
                    result = x + y;
                    break;
                case "-":
                    result = x - y;
                    break;
                case "*":
                    result = x * y;
                    break;
                case "/":
                    if (y == 0) {
                        System.out.println(msg_3);
                        continue;   // ask for a new equation
                    }
                    result = x / y;
                    break;
                default:
                    // Should never get here because of the check above
                    continue;
            }

            // Print result and finish (END in the flowchart)
            System.out.println(result);
            break;
        }
    }
}
