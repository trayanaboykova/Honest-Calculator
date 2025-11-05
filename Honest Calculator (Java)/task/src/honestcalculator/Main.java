package honestcalculator;

import java.util.Scanner;

public class Main {
    // Message variables
    public static String msg_0 = "Enter an equation";
    public static String msg_1 = "Do you even know what numbers are? Stay focused!";
    public static String msg_2 = "Yes ... an interesting math operation. You've slept through all classes, haven't you?";
    public static String msg_4 = "Do you want to store the result? (y / n):";
    public static String msg_5 = "Do you want to continue calculations? (y / n):";
    // ADDED: msg_7 to handle division by zero error, based on test expectation.
    public static String msg_7 = "Yeah... division by zero. Smart move...";

    // Global memory variable
    public static double memory = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main calculation loop (START to END)
        while (true) {
            System.out.println(msg_0); // print msg_0
            String calc = scanner.nextLine(); // read calc

            // Split input into 3 parts: x, oper, y
            String[] parts = calc.split(" ");
            if (parts.length != 3) {
                continue;
            }

            String xStr = parts[0];
            String oper = parts[1];
            String yStr = parts[2];

            double x = 0;
            double y = 0;

            // --- X Value and M Check ---
            if (xStr.equals("M")) {
                x = memory;
            } else {
                try {
                    x = Double.parseDouble(xStr);
                } catch (NumberFormatException e) {
                    System.out.println(msg_1); // print msg_1
                    continue;
                }
            }

            // --- Y Value and M Check ---
            if (yStr.equals("M")) {
                y = memory;
            } else {
                try {
                    y = Double.parseDouble(yStr);
                } catch (NumberFormatException e) {
                    System.out.println(msg_1);
                    continue;
                }
            }

            // --- Operator Check ---
            if (!(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/"))) {
                System.out.println(msg_2); // print msg_2
                continue;
            }

            // --- Calculation ---
            double result = 0;

            if (oper.equals("+")) {
                result = x + y;
            } else if (oper.equals("-")) {
                result = x - y;
            } else if (oper.equals("*")) {
                result = x * y;
            } else if (oper.equals("/")) {
                // Check: oper == "/" AND y != 0
                if (y == 0) {
                    // FIX: Print the required error message (msg_7) before restarting.
                    System.out.println(msg_7);
                    continue; // Loop back to print msg_0
                }
                result = x / y;
            }

            System.out.println(result); // print result

            // --- Store result loop (print msg_4) ---
            while (true) {
                System.out.println(msg_4);
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("y")) {
                    memory = result; // memory = result
                    break;
                } else if (answer.equalsIgnoreCase("n")) {
                    break;
                }
            }

            // --- Continue calculation loop (print msg_5) ---
            while (true) {
                System.out.println(msg_5);
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("y")) {
                    break; // Loop back to START (print msg_0)
                } else if (answer.equalsIgnoreCase("n")) {
                    return; // END
                }
            }
        }
    }
}