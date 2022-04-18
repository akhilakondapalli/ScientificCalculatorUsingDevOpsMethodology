package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
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
                logger.error("[ERROR]:Type mismatch - Integer type expected ; Encountered different type or input choice out of range 1 to 5.");
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
                        logger.error("[ERROR] :Type mismatch - Integer type expected ; Encountered different type");
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
            logger.info("SquareRoot - input : "+number + " output : Error! Square root not defined for negative integers !!!");
            return Double.NaN;
        }
        result = Math.sqrt(number);
        logger.info("SquareRoot - input : "+ number + " output : " + result);
        return result;
    }

}