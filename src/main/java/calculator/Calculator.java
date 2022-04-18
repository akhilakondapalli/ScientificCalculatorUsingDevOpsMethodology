package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        int choice;

        System.out.println("Welcome to Scientific Calculator.Calculator.Please choose any option.\n");

        Calculator calculator = new Calculator();

        do {
            try {

                System.out.println("1.Square root");
                System.out.println("5.exit");
                choice = input.nextInt();
            }
            catch(InputMismatchException exception){
                System.out.println("[ERROR]:Type mismatch - Integer type expected ; Encountered different type \n");
                return;

            }

            switch (choice) {
                case 1:
                    double number1;
                    try {
                        System.out.println("Enter any positive number to calculate Square root. \n");
                        number1 = input.nextDouble();
                    }
                    catch(InputMismatchException exception){
                        System.out.println("[ERROR] :Type mismatch - Integer type expected ; Encountered different type\n");
                        return;
                    }
                    System.out.println("The square root of " + number1 + " is " + calculator.squareRoot(number1));
                    break;


                default:
                    System.out.println("Exiting !!!");
                    return;


            }
        }while(true);


    }

    public double squareRoot(double number){
        double result;
        if(number < 0)
        {
            return Double.NaN;
        }
        result = Math.sqrt(number);
        return result;
    }

}