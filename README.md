This is a simple calculator program in Java that allows users to add positive integers together. The program includes 
methods to add numbers, reset the calculator, and check if a number is positive. The main method handles user input, 
allowing users to enter numbers, get the result, or reset the calculator.

```java
public class Calculator {
    // Private variables to store the result of the summed up integers
    private int result = 0;

    // Adds integer to the calculator
    public void add(int number) {
        this.result += number;
    }
    // resets the calculator
    public void reset() {
        this.result = 0;
    }
    // checks if the integer is positive, if not throws exception
    public void checkPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
    }

    // main method to ask user for input and print the result. Stops when user gives a stop command (=) and resets when user gives reset command (C)
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Welcome to the calculator! Enter positive integers to add them up.");
        System.out.println("Enter '=' to get the result and stop, or 'C' to reset the calculator.");

        while (true) {
            System.out.print("Enter a positive integer (or '=' to stop, 'C' to reset): ");
            String input = scanner.nextLine();

            if (input.equals("=")) {
                System.out.println("Result: " + calculator.result);
                break;
            } else if (input.equalsIgnoreCase("C")) {
                calculator.reset();
                System.out.println("Calculator reset. Current result: " + calculator.result);
            } else {
                try {
                    int number = Integer.parseInt(input);
                    calculator.checkPositive(number);
                    calculator.add(number);
                    System.out.println("Current result: " + calculator.result);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter a valid positive integer, '=' to stop, or 'C' to reset.");
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        scanner.close();
    }
}

```
Class Calculator:
- Private variable `result`: Stores the cumulative sum of the integers added.
- Method `add(int number)`: Adds a positive integer to the current result.
- Method `reset()`: Resets the result to zero.
- Method `checkPositive(int number)`: Checks if the provided integer is positive; throws an exception if not.
- Main method: Handles user input, allowing users to add numbers, get the result, or reset the calculator.