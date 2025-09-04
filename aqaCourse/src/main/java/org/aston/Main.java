package org.aston;

public class Main {
    public static void main(String[] args) {
        /**task 1**/
        Lesson_1.printThreeWords();

        /**task 2**/
        Lesson_1.checkSumSign();

        /**task 3**/
        Lesson_1.printColor();

        /**task 4**/
        Lesson_1.compareNumbers();

        /**task 5**/
        System.out.println(Lesson_1.isCorrectSum(11, 10));

        /**task 6**/
        Lesson_1.printNumStatus(-25);

        /**task 7**/
        System.out.println(Lesson_1.isNumFalse(12));

        /**task 8**/
        Lesson_1.printText(10, "simple text");

        /**task 9**/
        System.out.println(Lesson_1.isLeapYear(2025));

        /**task 10**/
        Lesson_1.reverseNumsInArr();

        /**task 11**/
        Lesson_1.fillArr();

        /**task 12**/
        Lesson_1.modArr();

        /**task 13**/
        Lesson_1.modTwoDimArr();

        /**task 14**/
        int[] nums = Lesson_1.printArr(5, 7);

        for (int num : nums) {
            System.out.println(num);
        }
    }

}