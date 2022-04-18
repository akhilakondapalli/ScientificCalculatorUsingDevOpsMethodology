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

        System.out.println("Welcome to Scientific Calculator !!!..Please choose any option.\n");

        Calculator calculator = new Calculator();

        do {
            try {

                System.out.println("1.Square root");
                System.out.println("2.Factorial");
                System.out.println("3.Natural Logarithm");
                System.out.println("4.Power Function");
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
                case 4:
                    double number4;
                    double number5;
                    try {
                        System.out.print("\nEnter base number: ");
                        number4 = input.nextDouble();
                        System.out.print("\nEnter exponent number: ");
                        number5 = input.nextDouble();

                        System.out.println(number4 + " raised to the power " + number5 + " is : " + calculator.powerFunction(number4, number5));
                    }
                    catch (InputMismatchException exception) {

                        logger.error("[ERROR] :Type mismatch - Integer type expected ; Encountered different type");

                    }
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
    public double powerFunction(double number1 , double number2){
        double result;
        if(number1 == 0 && number2 == 0)
        {
            logger.info("PowerFunction - input : "+ number1 +"^"+number2 + " output : Error! PowerFunction can't be calculated if both base and exponent is zero !!!");
            return Double.NaN;

        }
        result = Math.pow(number1,number2);
        logger.info("PowerFunction - input : "+ number1 +"^"+number2 + " output : " + result);
        return result;


    }


}