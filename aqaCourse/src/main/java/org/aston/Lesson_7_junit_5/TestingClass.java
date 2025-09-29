package org.aston.Lesson_7_junit_5;

public class TestingClass {

    public long calcFactorial(long n) {
        if (n < 0) throw new IllegalArgumentException("Число не может быть отрицательным!");
        return (n <= 1) ? 1 : n * calcFactorial(n - 1);
    }

    public double calcSquare(double a, double h) {
        if (a > 0 && h > 0) {
            return (a * h) / 2;
        } else {
            throw new IllegalArgumentException("Невалидные значения!");
        }
    }

    public int calculation(int a, int b, String operation) {
        if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
            switch (operation) {
                case "+": return a + b;
                case "-": return a - b;
                case "*": return a * b;
                case "/": if (b == 0) {
                    throw new IllegalArgumentException("Деление на ноль невозможно!");
                } else if (a % b != 0) {
                    throw new IllegalArgumentException("Деление c остатком невозможно!");
                } else {
                    return a / b;
                }
            }
        } else {
            throw new IllegalArgumentException("Неверный ввод оператора!");
        }
        return 0;
    }

    public int equalityNums(int a, int b) {
        if (a == b) {
            return 0;
        }
        if (a < b) {
            return -1;
        }
        return 1;
    }
}
