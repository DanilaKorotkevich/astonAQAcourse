package org.aston.Lesson_7_testng;

public class TestingClass {

    public long calcFactorial(long n) {
        if (n < 0) throw new IllegalArgumentException("Число не может быть отрицательным!");
        return (n <= 1) ? 1 : n * calcFactorial(n - 1);
    }

    public int calcSquare(int a, int h) {
        if (a != 0 || h != 0) {
            if ((a * h) % 2 != 0) {
                throw new IllegalArgumentException("Результат не может быть с остатком!");
            } else {
                return (a * h) / 2;
            }
        } else {
            System.err.println("Невалидные значения!");
        }
        return 0;
    }

    public int calculation(int a, int b, String operation) {
        if (operation == "+" | operation == "-" | operation == "*" | operation == "/") {
            switch (operation) {
                case "+": return a + b;
                case "-": return a - b;
                case "*": return a * b;
                case "/": if (b == 0) {
                    System.err.println("деление на ноль невозможно!");
                    return 0;
                } else if (a % b != 0) {
                    System.err.println("Деление c остатком невозможно!");
                    return 0;
                } else {
                    return a / b;
                }
            }
        } else {
            System.err.println("Неверный ввод оператора!");
            return 0;
        }
        return 0;
    }

    public int equalsNums(int a, int b) {
        if (a == b) {
            return 0;
        }
        if (a < b) {
            return -1;
        }
        return 1;
    }
}
