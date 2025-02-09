/*
Part I : Array Address Calculations (Individually)
- Dynamically derive formula based from the number of dimensions
- Accept input from the user
- Compute and display the total number of elements
- Compute and display the address from the given problem as provided
*/

import java.util.Scanner;

public class ArrayAddressCalculation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Accept the number of dimensions from the user
        System.out.print("Enter the number of dimensions: ");
        int dimensions = scanner.nextInt();

        // Step 2: Accept the size of each dimension
        int[] sizes = new int[dimensions];
        for (int i = 0; i < dimensions; i++) {
            System.out.print("Enter the size of dimension " + (i + 1) + ": ");
            sizes[i] = scanner.nextInt();
        }

        // Step 3: Compute the total number of elements
        int totalElements = 1;
        for (int size : sizes) {
            totalElements *= size;
        }
        System.out.println("Total number of elements: " + totalElements);

        // Step 4: Accept the indices from the user
        int[] indices = new int[dimensions];
        for (int i = 0; i < dimensions; i++) {
            System.out.print("Enter the index for dimension " + (i + 1) + ": ");
            indices[i] = scanner.nextInt();
        }

        // Step 5: Compute the address
        int address = computeAddress(sizes, indices);
        System.out.println("Computed address: " + address);

        scanner.close();
    }

    // Method to compute the address based on the given indices
    private static int computeAddress(int[] sizes, int[] indices) {
        int address = 0;
        int multiplier = 1;

        for (int i = sizes.length - 1; i >= 0; i--) {
            address += indices[i] * multiplier;
            multiplier *= sizes[i];
        }

        return address;
    }
}

/*
Part II : Record Address Calculations (Individually)
- Dynamically derive formula based from the problem provided
- Accept input from the user
- Compute and display the total number of elements
- Compute and display the address from the given problem as provided


import java.util.Scanner;

public class RecordAddressCalculation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Accept the number of fields in the record
        System.out.print("Enter the number of fields in the record: ");
        int numFields = scanner.nextInt();

        // Step 2: Accept the size of each field
        int[] fieldSizes = new int[numFields];
        for (int i = 0; i < numFields; i++) {
            System.out.print("Enter the size of field " + (i + 1) + " (in bytes): ");
            fieldSizes[i] = scanner.nextInt();
        }

        // Step 3: Compute the total size of the record
        int totalSize = 0;
        for (int size : fieldSizes) {
            totalSize += size;
        }
        System.out.println("Total size of the record: " + totalSize + " bytes");

        // Step 4: Accept the field number for which to compute the address
        System.out.print("Enter the field number to compute the address: ");
        int fieldNumber = scanner.nextInt();

        // Step 5: Compute the address (offset) of the specified field
        int address = computeFieldAddress(fieldSizes, fieldNumber);
        System.out.println("Address (offset) of field " + fieldNumber + ": " + address + " bytes");

        scanner.close();
    }

    // Method to compute the address (offset) of a specific field
    private static int computeFieldAddress(int[] fieldSizes, int fieldNumber) {
        int address = 0;

        // Iterate through the fields up to the specified field number
        for (int i = 0; i < fieldNumber - 1; i++) {
            address += fieldSizes[i];
        }

        return address;
    }
}*/

/* 
Part I : STACKS (Individually)
- Accept input from the user
- Perform PUSH() and POP() operations
- Display the contents of the STACK
- Repeat while not terminated by user

import java.util.Scanner;
import java.util.Stack;

public class StackOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        boolean running = true;

        while (running) {
            // Display menu
            System.out.println("\n--- Stack Operations ---");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. Display Stack");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // PUSH
                    System.out.print("Enter the element to PUSH: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    System.out.println("Element " + element + " pushed to the stack.");
                    break;

                case 2: // POP
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty. Cannot POP.");
                    } else {
                        int poppedElement = stack.pop();
                        System.out.println("Element " + poppedElement + " popped from the stack.");
                    }
                    break;

                case 3: // Display Stack
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack contents: " + stack);
                    }
                    break;

                case 4: // Exit
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
*/

/* 
Part II : QUEUES (Individually)
- Accept input from the user
- Perform ENQUEUE() and DEQUEUE() operations
- Display the contents of the QUEUE
- Repeat while not terminated by user

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        boolean running = true;

        while (running) {
            // Display menu
            System.out.println("\n--- Queue Operations ---");
            System.out.println("1. ENQUEUE");
            System.out.println("2. DEQUEUE");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // ENQUEUE
                    System.out.print("Enter the element to ENQUEUE: ");
                    int element = scanner.nextInt();
                    queue.add(element);
                    System.out.println("Element " + element + " enqueued to the queue.");
                    break;

                case 2: // DEQUEUE
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty. Cannot DEQUEUE.");
                    } else {
                        int dequeuedElement = queue.poll();
                        System.out.println("Element " + dequeuedElement + " dequeued from the queue.");
                    }
                    break;

                case 3: // Display Queue
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue contents: " + queue);
                    }
                    break;

                case 4: // Exit
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
*/

