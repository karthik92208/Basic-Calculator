package Task1;// Simple Calculator using methods, conditional statements and exception handling

import java.util.Scanner;

public class CalculatorApp {
    public static long add(long a, long b){
        return a+b;
    }
    public static long sub(long a, long b){
        return a-b;
    }
    public static long mul(long a, long b){
        return a*b;
    }
    public static long div(long a, long b){
        if(b == 0){
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        else{
            return a/b;
        }
    }
    public static void main(String [] args){
        Scanner s = new Scanner((System.in));

        System.out.println("Instructions to Use\n 1. Addition -> '+'\n 2. Subtraction -> '-'\n 3. Multiplication -> '*'\n 4. Division -> '/'\n 5. Clear the screen -> 'clear' or "+"AC");
        System.out.println("\n....Start Computing....");
        System.out.print("Enter first value: ");
        long value1 = s.nextLong();
        long result = value1;

        while(true){
            System.out.print("Enter operand (+, -, *, /) or type 'exit' to quit : ");
            String operand = s.next();

            //checking if user want to terminate the program
            if(operand.equalsIgnoreCase("exit")){
                System.out.println("Calculator Exited. Thank You");
                break;
            }

            //clear the computed value
            if(operand.equalsIgnoreCase("clear") || operand.equalsIgnoreCase("AC")){
                System.out.println("Calculator reset\nEnter first value: ");
                result = s.nextLong();
                continue;
            }
            System.out.print("Enter next value: ");
            long value2 = s.nextLong();
            char c = operand.charAt(0);

            try {
                //conditional statements
                if (c == '+') {
                    result = add(result, value2);
                } else if (c == '-') {
                    result = sub(result, value2);
                } else if (c == '*') {
                    result = mul(result, value2);
                } else if (c == '/') {
                    result = div(result, value2);
                } else {
                    System.out.println("\"INVALID OPERATION!\" Please enter a valid operand...");
                }

            }
            catch (ArithmeticException e){
                System.out.println("Arithmetic Exception Caught: "+e.getMessage());
                continue;
            }
            System.out.println("Result = " + result + "\n");
        }
    }
}
