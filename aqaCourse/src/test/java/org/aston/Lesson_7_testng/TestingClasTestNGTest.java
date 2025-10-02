package org.aston.Lesson_7_testng;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestingClasTestNGTest {

    private TestingClass testingClass;
    @BeforeMethod
    public void setUp() {
        testingClass = new TestingClass();
    }
    @Test
    @DisplayName("Тест calcFactorial")
    public void testCalcFactorial() {
        assertEquals(testingClass.calcFactorial(0), 1L);
        assertEquals(testingClass.calcFactorial(1), 1L);
    }

    @Test
    public void testCalcFactorialOfPositiveNumber() {
        assertEquals(testingClass.calcFactorial(5), 120L);
        assertEquals(testingClass.calcFactorial(10), 3628800L);
        assertEquals(testingClass.calcFactorial(20), 2432902008176640000L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalcFactorialOfNegativeNumber() {
        testingClass.calcFactorial(-1);
    }

    @Test
    @DisplayName("Тест calcSquare")
    public void testCalcSquare() {
        assertEquals(testingClass.calcSquare(2, 1), 1);
    }

    @Test
    public void testCalcSquareOfPositiveNumbers() {
        assertEquals(testingClass.calcSquare(5, 2), 5);
        assertEquals(testingClass.calcSquare(7, 4), 14);
        assertEquals(testingClass.calcSquare(5, 6), 15);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalcSquareOfNegativeNumbers() {
        testingClass.calcSquare(5, 5);
        testingClass.calcSquare(1, 1);
    }

    @Test
    @DisplayName("Тест calculation")
    public void testCalculatoin() {
        assertEquals(testingClass.calculation(0, 0, "+"), 0);
        assertEquals(testingClass.calculation(0, 0, "-"), 0);
        assertEquals(testingClass.calculation(0, 0, "*"), 0);
        assertEquals(testingClass.calculation(0, 1, "/"), 0);
    }

    @Test
    public void testCalculationOfPositiveNumbers() {
        assertEquals(testingClass.calculation(2, 2, "+"), 4);
        assertEquals(testingClass.calculation(8, 3, "-"), 5);
        assertEquals(testingClass.calculation(5, 9, "*"), 45);
        assertEquals(testingClass.calculation(8, 4, "/"), 2);
    }

    @Test
    public void testCalculationOfNegativeNumbers() {
        assertEquals(testingClass.calculation(2, 4, "%"), 0);
        assertEquals(testingClass.calculation(2, 0, "/"), 0);
        assertEquals(testingClass.calculation(8, 3, "/"), 0);
    }

    @Test
    @DisplayName("Тест equalsNums")
    public void testEqualsNums() {
        assertEquals(testingClass.equalsNums(0, 0), 0);
        assertEquals(testingClass.equalsNums(1, 0), 1);
        assertEquals(testingClass.equalsNums(0, 1), -1);
    }

    @Test
    public void testEqualsNumsOfPositiveNumbers() {
        assertEquals(testingClass.equalsNums(5, 5), 0);
        assertEquals(testingClass.equalsNums(50, 29), 1);
        assertEquals(testingClass.equalsNums(83, 109), -1);
    }
}
