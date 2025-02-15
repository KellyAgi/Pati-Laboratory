import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    // Function to return precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix expression to postfix expression
    static String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // Print table header
        System.out.println("\nConversion Steps:");
        System.out.println("+-------+-------------------+-------------------+");
        System.out.println("| Token | Stack             | Output            |");
        System.out.println("+-------+-------------------+-------------------+");

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is an operand, add it to the postfix expression
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            // If the character is '(', push it onto the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is ')', pop from the stack and add to postfix until '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression"; // Invalid expression
                } else {
                    stack.pop();
                }
            }
            // If the character is an operator
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }

            // Display the current state of the stack and postfix expression in table format
            System.out.printf("| %-5c | %-17s | %-17s |\n", c, stack.toString(), postfix.toString());
        }

        // Pop all the remaining operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; // Invalid expression
            }
            postfix.append(stack.pop());
        }

        // Print the final row of the table
        System.out.println("+-------+-------------------+-------------------+");
        System.out.printf("| %-5s | %-17s | %-17s |\n", "End", stack.toString(), postfix.toString());
        System.out.println("+-------+-------------------+-------------------+");

        return postfix.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.print("Enter an infix expression: ");
            String expression = scanner.nextLine();

            String postfix = infixToPostfix(expression);

            System.out.println("\nFinal Postfix Expression: " + postfix);

            System.out.print("\nDo you want to try again? (yes/no): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        scanner.close();
    }
}