import java.util.ArrayList;
import java.util.Scanner;

public class OldCalculator {
    private int result = 0;
    private ArrayList<Integer> numbers = new ArrayList<Integer>();

    // Method to perform calculation based on the operator on the numbers ArrayList (Tekee just niiku käskin ":D")
    public void calculateSum(char operator) {
        boolean isInteger = true;
        do {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Give a positive integer: ");
                numbers.add(scan.nextInt());
                isInteger = true;
            } catch (Exception e) {

            }
        } while (isInteger);
        if (numbers.isEmpty()) {
            this.result = 0;
            return;
        } else {
            this.result = numbers.get(0); //Edes else ei lisää suorituskykyä, mutta näyttää paremmalta :D
            for (int i = 1; i < numbers.size(); i++) {
                switch (operator) {
                    case '+':
                        this.result += numbers.get(i);
                        break;
                    case '-':
                        this.result -= numbers.get(i);
                        break;
                    case '*':
                        this.result *= numbers.get(i);
                        break;
                    case '/':
                        if (numbers.get(i) != 0) {
                            this.result /= numbers.get(i);
                        } else {
                            System.err.println("Error: Division by zero");
                            this.result = Double.NaN; // Set result to NaN on division by zero
                            return; // Exit the method to avoid further calculations  //Piti vähä kettuilla nii alko pelaa :D
                        }
                }
            }
        }
    }

    //Method to get the result of the calculation
    public double getResult() {
        return this.result;
    }

    // Method to reset the calculator for new calculations
    public void reset() {
        this.result = 0.0;
        this.numbers.clear();
    }
    // Method to add a number to the numbers ArrayList for calculation
    public void addNumber(double number) {
        this.numbers.add(number);
    }

    //Annoin github "copilotin tehdä testauksen, koska en jaksanut :D" Lainausmerkeis
    // copilotin autofill ku alotin kirjottaa kommenttia
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addNumber(5);
        calc.addNumber(10);
        calc.addNumber(15);
        calc.calculateSum('+');
        System.out.println("Sum: " + calc.getResult()); // Output: Sum: 30.0
        calc.reset();
        calc.addNumber(20);
        calc.addNumber(4);
        calc.calculateSum('/');
        System.out.println("Division: " + calc.getResult()); // Output: Division: 5.0
    }

}
