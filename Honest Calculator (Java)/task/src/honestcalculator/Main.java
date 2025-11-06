package honestcalculator;

import java.util.Scanner;

public class Main {
    // Message variables based on the current context (only msg_0, 1, 2, 4, 5 needed for this flowchart)
    public static String msg_0 = "Enter an equation";
    public static String msg_1 = "Do you even know what numbers are? Stay focused!";
    public static String msg_2 = "Yes ... an interesting math operation. You've slept through all classes, haven't you?";
    public static String msg_4 = "Do you want to store the result? (y / n):";
    public static String msg_5 = "Do you want to continue calculations? (y / n):";

    // NOTE: The previous flow had msg_3 and msg_7, but they are not used in this simplified flowchart.
    // I will remove the unused messages for a cleaner implementation.

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
                continue; // Loop back to print msg_0 if format is wrong
            }

            String xStr = parts[0];
            String oper = parts[1];
            String yStr = parts[2];

            double x = 0;
            double y = 0;

            // --- X Value and M Check ---
            if (xStr.equals("M")) {
                x = memory; // x = memory
            } else {
                try {
                    x = Double.parseDouble(xStr);
                } catch (NumberFormatException e) {
                    System.out.println(msg_1); // print msg_1
                    continue; // Loop back to print msg_0
                }
            }

            // --- Y Value and M Check ---
            if (yStr.equals("M")) {
                y = memory; // y = memory
            } else {
                try {
                    y = Double.parseDouble(yStr);
                } catch (NumberFormatException e) {
                    // Check if x was also not a number (already handled above), but here we check y.
                    // This diamond is specifically for when x and y are NOT M and NOT numbers.
                    // If x was valid, but y is invalid, it prints msg_1 and restarts.
                    System.out.println(msg_1);
                    continue; // Loop back to print msg_0
                }
            }

            // --- Operator Check (Combined with Number Check Failure Path) ---
            if (!(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/"))) {
                System.out.println(msg_2); // print msg_2
                continue; // Loop back to print msg_0
            }

            // --- Calculation ---
            double result = 0;
            boolean validCalculation = true;

            if (oper.equals("+")) {
                result = x + y;
            } else if (oper.equals("-")) {
                result = x - y;
            } else if (oper.equals("*")) {
                result = x * y;
            } else if (oper.equals("/")) {
                // Check: oper == "/" AND y != 0
                if (y == 0) {
                    // The flowchart implies this check fails and flows back to print msg_0
                    // However, in previous stages, this often required a message.
                    // Since the flowchart has no red box before looping back, we assume
                    // the system handles the error and restarts silently, or we must use an
                    // implied error message (like msg_7 from the earlier problem).
                    // Sticking strictly to the flow's visual path (no print box before restart),
                    // we'll just loop back.
                    // Given previous context, it's safer to print the expected error (msg_7)
                    // even if not explicitly shown in this cropped flow.
                    // *Self-Correction: Stick strictly to the provided flow, which just loops back.*
                    continue;
                }
                result = x / y;
            }

            // If we reach this point, the calculation was successful or division by zero occurred and we restarted.

            System.out.println(result); // print result

            // --- Store result loop (print msg_4) ---
            while (true) {
                System.out.println(msg_4);
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("y")) {
                    memory = result; // memory = result
                    break; // Flow continues to print msg_5
                } else if (answer.equalsIgnoreCase("n")) {
                    break; // Flow continues to print msg_5
                }
                // If input is neither 'y' nor 'n', the loop repeats (read answer -> check)
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
                // If input is neither 'y' nor 'n', the loop repeats (read answer -> check)
            }
        }
    }
}