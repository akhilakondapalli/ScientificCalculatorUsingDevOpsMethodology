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
                System.out.println("2.Factorial");
                System.out.println("3.Natural Logarithm");
                System.out.println("5.exit");
                choice = input.nextInt();
            }
            catch(InputMismatchException exception){
                logger.error("[ERROR]:Type mismatch - Integer type expected ; Encountered different type ");
                return;

            }
            switch (choice) {
                case 1:
                    double number1;
                    try {
                        System.out.println("Enter any positive Integer to calculate Square root. \n");
                        number1 = input.nextDouble();
                    }
                    catch(InputMismatchException exception){
                        logger.error("[ERROR] :Type mismatch - Integer type expected ; Encountered different type");
                        return;
                    }
                    System.out.println("The square root of " + number1 + " is " + calculator.squareRoot(number1));
                    break;
                case 2:
                    double number2;
                    try{
                        System.out.println("Enter positive Integer to calculate Factorial. \n");
                        number2 = input.nextDouble();
                    }
                    catch(InputMismatchException exception){
                        logger.error("[ERROR] :Type mismatch - Integer type expected ; Encountered different type");
                        return;
                    }
                    System.out.println("The Factorial of " + number2 + " is " + calculator.factorial(number2));
                    break;
                case 3:
                    double number3;
                    try{
                        System.out.println("Enter positive number to calculate Logarithm. \n");
                        number3 = input.nextDouble();
                    }
                    catch(InputMismatchException exception){
                        logger.error("[ERROR] :Type mismatch - Number type expected ; Encountered different type");
                        return;
                    }
                    System.out.println("Logarithm of " + number3 + " is " + calculator.logarithm(number3));
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
            logger.info("SquareRoot - input : "+number + " output : Error! Square root can't be calculated for negative integers !!!");
            return Double.NaN;
        }
        result = Math.sqrt(number);
        logger.info("SquareRoot - input : "+ number + " output : " + result);
        return result;
    }

    public double factorial(double number){
        double result=1;
        double input_val=number;
        if(number<0){
            logger.info("Factorial - input : "+number + " output : Error! Factorial can't be calculated for negative integers !!!");
            return Double.NaN;
        }
        while(number != 0){
            result = result * number;
            number--;
        }
        logger.info("Factorial - input : "+ input_val + " output : " + result);
        return result;
    }
    public double logarithm(double number){
        double result;

        if(number>0){
            result=Math.log(number);
            logger.info("Logarithm - input : "+ number + " output : " + result);
            return result;
        }
        logger.info("Logarithm - input : "+number + " output : Error! Logarithm can't be calculated for  zero and negative numbers !!!");
        return Double.NaN;

    }



}