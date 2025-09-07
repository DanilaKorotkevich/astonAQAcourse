package org.aston.Lesson_1;

public class Lesson_1 {

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = 25;
        int sum = a + b;

        if (sum >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 101;

        if (value <= 0) {
            System.out.println("красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("желтый");
        } else if (value > 100) {
            System.out.println("зеленый");
        } else {
            System.out.println("Введено некоректное значение!");
        }
    }

    public static void compareNumbers() {
        int a = 28;
        int b = 32;

        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }

    public static boolean isCorrectSum(int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum <= 20) return true;

        return false;
    }

    public static void printNumStatus(int a) {
        if (a >= 0) System.out.println("положительное");
        else System.out.println("отрицательное");
    }

    public static boolean isNumFalse(int a) {
        if (a >= 0) return false;

        return true;
    }

    public static void printText(int a, String s) {
        for (int i = 1; i <= a; i++) {
            System.out.println(i + ". " + s);
        }
    }

    public static boolean isLeapYear(int year) {
        if ((year % 400 == 0) || year % 4 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return false;
        }
    }

    public static void reverseNumsInArr() {
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = 0;
            } else if (nums[i] == 0) {
                nums[i] = 1;
            }
            System.out.print(nums[i] + " ");
        }
    }

    public static void fillArr () {
        int[] nums = new int[100];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;

            System.out.println(nums[i]);
        }
    }

    public static void modArr() {
        int[] nums = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) nums[i] *= 2;

            System.out.println(nums[i]);
        }
    }

    public static void modTwoDimArr() {
        int[][] nums = new int[5][5];

        for (int i = 0; i < nums.length; i++) {
            nums[i][i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i][nums.length - 1 - i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] printArr(int len, int initialValue) {
        int[] nums = new int[len];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = initialValue;
        }

        return nums;
    }
}
