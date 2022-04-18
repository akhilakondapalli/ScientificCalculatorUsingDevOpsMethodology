import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import calculator.Calculator;
public class CalculatorTest {
    private static final double DELTA = 1e-15;
    Calculator calculator = new Calculator();

    @Test
    public void squareRootTruePositive() {
        assertEquals("True positive test for Square root of given input", 5.0, calculator.squareRoot(25), DELTA);
        assertEquals("True positive test for Square root of given input", 3.0, calculator.squareRoot(9), DELTA);
        assertEquals("True positive test for Square root of given input", 0.0, calculator.squareRoot(0), DELTA);
    }

    @Test
    public void squareRootFalsePositive() {
        assertNotEquals("False positive test for Square root of given input", 4.0, calculator.squareRoot(0), DELTA);
        assertNotEquals("False positive test for Square root of given input", 3.0, calculator.squareRoot(-100), DELTA);
        assertNotEquals("False positive test for Square root of given input", 8.0, calculator.squareRoot(144), DELTA);
        assertNotEquals("False positive test for Square root of given input", 13.0, calculator.squareRoot(1000), DELTA);
    }

    @Test
    public void factorialTruePositive() {
        assertEquals("True positive test for Factorial of given input", 1.0, calculator.factorial(0), DELTA);
        assertEquals("True positive test for Factorial of given input", Double.NaN, calculator.factorial(-5), DELTA);
        assertEquals("True positive test for Factorial of given input", 3628800.0, calculator.factorial(10), DELTA);
        assertEquals("True positive test for Factorial of given input", 120.0, calculator.factorial(5), DELTA);
    }

    @Test
    public void factorialFalsePositive() {
        assertNotEquals("False positive test for Factorial of given input", 3.0, calculator.factorial(0), DELTA);
        assertNotEquals("False positive test for Factorial of given input", 6.0, calculator.factorial(-5), DELTA);
        assertNotEquals("False positive test for Factorial of given input", 9.0, calculator.factorial(3), DELTA);
    }
    @Test
    public void logarithmTruePositive() {
        assertEquals("True positive test for logarithm of given input", 2.484906649788, calculator.logarithm(12), DELTA);
        assertEquals("True positive test for logarithm of given input", Double.NaN, calculator.logarithm(-5), DELTA);
        assertEquals("True positive test for logarithm of given input", Double.NaN, calculator.logarithm(0), DELTA);
        assertEquals("True positive test for logarithm of given input", 4.605170185988092, calculator.logarithm(100), DELTA);
    }

    @Test
    public void logarithmFalsePositive() {
        assertNotEquals("False positive test for logarithm of given input", 0.0, calculator.logarithm(0), DELTA);
        assertNotEquals("False positive test for logarithm of given input", 6.0, calculator.logarithm(-5), DELTA);
        assertNotEquals("False positive test for logarithm of given input", 9.0, calculator.logarithm(3), DELTA);
    }
}


