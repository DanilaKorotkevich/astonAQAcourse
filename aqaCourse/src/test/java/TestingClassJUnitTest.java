import org.aston.Lesson_7_junit_5.TestingClass;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestingClassJUnitTest {
    private TestingClass testingClass;

    @BeforeEach
    public void setUp() {
        testingClass = new TestingClass();
    }

    @Test
    @DisplayName("Тест calcFactorial")
    public void testFactorial() {
        //тест валидных значений
        assertEquals(1L, testingClass.calcFactorial(0));
        assertEquals(1L, testingClass.calcFactorial(1));
        assertEquals(120L, testingClass.calcFactorial(5));
        assertEquals(3628800L, testingClass.calcFactorial(10));
        assertEquals(2432902008176640000L, testingClass.calcFactorial(20));

        //тест невалидных значений
        assertThrows(IllegalArgumentException.class, () -> {
            testingClass.calcFactorial(-1);
        });
    }

    @Test
    @DisplayName("Тест calcSquare")
    public void testCalcSquare() {
        //тест валидных значений
        assertEquals(13.75, testingClass.calcSquare(5.5, 5));
        assertEquals(25, testingClass.calcSquare(5, 10));
        assertEquals(60, testingClass.calcSquare(15, 8));

        //тест невалидных значений
        assertThrows(IllegalArgumentException.class, () -> {
            testingClass.calcSquare(10, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            testingClass.calcSquare(-1, 5);
        });
    }

    @Test
    @DisplayName("Тест calculation")
    public void testCalculation() {
        //тест валидных значений
        assertEquals(25, testingClass.calculation(10, 15, "+"));
        assertEquals(0, testingClass.calculation(-5, 5, "+"));

        assertEquals(-5, testingClass.calculation(10, 15, "-"));
        assertEquals(30, testingClass.calculation(56, 26, "-"));
        assertEquals(26, testingClass.calculation(-7, -33, "-"));
        assertEquals(24, testingClass.calculation(7, -17, "-"));

        assertEquals(0, testingClass.calculation(5, 0, "*"));
        assertEquals(40, testingClass.calculation(5, 8, "*"));
        assertEquals(-6, testingClass.calculation(3, -2, "*"));
        assertEquals(6, testingClass.calculation(-3, -2, "*"));

        assertEquals(2, testingClass.calculation(4, 2, "/"));
        assertEquals(-2, testingClass.calculation(-10, 5, "/"));
        assertEquals(-5, testingClass.calculation(50, -10, "/"));
        assertEquals(0, testingClass.calculation(0, 10, "/"));

        //тест невалидных значений
        assertThrows(IllegalArgumentException.class, () -> {
            testingClass.calculation(5, 10, "qwe");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            testingClass.calculation(5, 0, "/");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            testingClass.calculation(5, 10, "/");
        });
    }

    @Test
    @DisplayName("Тест equalsNums")
    public void testEqualityNums() {
        assertEquals(-1, testingClass.equalityNums(5, 6));
        assertEquals(0, testingClass.equalityNums(2, 2));
        assertEquals(1, testingClass.equalityNums(7, 3));
        assertEquals(0, testingClass.equalityNums(0, 0));
        assertEquals(1, testingClass.equalityNums(14, 0));
        assertEquals(-1, testingClass.equalityNums(0, 1));
    }
}
