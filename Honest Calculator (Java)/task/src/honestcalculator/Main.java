package honestcalculator;

import java.util.Scanner;

public class Main {
    // --- Message Variables (Combined from all stages) ---
    public static String msg_0 = "Enter an equation";
    public static String msg_1 = "Do you even know what numbers are? Stay focused!";
    public static String msg_2 = "Yes ... an interesting math operation. You've slept through all classes, haven't you?";
    public static String msg_3 = "Yeah... division by zero. Smart move...";
    public static String msg_4 = "Do you want to store the result? (y / n):";
    public static String msg_5 = "Do you want to continue calculations? (y / n):";

    // Messages for the check function (Laziness Test)
    public static String msg_6 = " ... lazy";
    public static String msg_7 = " ... very lazy";
    public static String msg_8 = " ... very, very lazy";
    public static String msg_9 = "You are";

    // Global memory variable
    public static double memory = 0;

    // --- I. is_one_digit Function ---
    public static boolean is_one_digit(double v) {
        // Checks if v is an integer between -10 and 10 (exclusive).
        // The check v == (int) v ensures it's an integer value.
        return (v > -10 && v < 10 && v == (int) v);
    }

    // --- II. check Function ---
    // Corresponds to check(v1, v2, v3) in the flowchart (v1=x, v2=y, v3=oper)
    public static void check(double x, double y, String oper) {
        String msg = "";

        // 1. Check: is_one_digit(x) AND is_one_digit(y)
        if (is_one_digit(x) && is_one_digit(y)) {
            msg = msg + msg_6;
        }

        // 2. Check: (x == 1 OR y == 1) AND oper == "*"
        if ((x == 1 || y == 1) && oper.equals("*")) {
            msg = msg + msg_7;
        }

        // 3. Check: (x == 0 OR y == 0) AND (oper == "*" OR oper == "+" OR oper == "-")
        if ((x == 0 || y == 0) && (oper.equals("*") || oper.equals("+") || oper.equals("-"))) {
            msg = msg + msg_8;
        }

        // Final Check: If msg is not empty, print "You are" + msg
        if (!msg.isEmpty()) {
            System.out.println(msg_9 + msg);
        }
    }

    // --- III. Main Function ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main calculation loop (START to END)
        while (true) {
            System.out.println(msg_0);
            String calc = scanner.nextLine();

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

            // --- X Value and M Check (opt. to store var. x) ---
            if (xStr.equals("M")) {
                x = memory;
            } else {
                try {
                    x = Double.parseDouble(xStr);
                } catch (NumberFormatException e) {
                    System.out.println(msg_1);
                    continue;
                }
            }

            // --- Y Value and M Check (opt. to store var. y) ---
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
                System.out.println(msg_2);
                continue;
            }

            // --- check(x, y, oper) Function Call ---
            check(x, y, oper);

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
                    System.out.println(msg_3); // print msg_3 ("Yeah... division by zero...")
                    continue;
                }
                result = x / y;
            }

            System.out.println(result); // print result

            // --- Store result loop (print msg_4) ---
            while (true) {
                System.out.println(msg_4);
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("y")) {
                    memory = result;
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