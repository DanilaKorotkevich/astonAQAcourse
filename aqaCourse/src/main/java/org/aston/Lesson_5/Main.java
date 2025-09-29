package org.aston.Lesson_5;

public class Main {

    public static void main(String[] args) {
        String[][] array = {{"1", "21", "31", "17"},
                            {"4", "1", "10", "6"},
                            {"7", "2", "9", "45"},
                            {"9", "1", "8", "4"}};

        try {
            System.out.println("Сумма элементов массива: " + sumArrayElems(array));
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        /**Код для генерации и поимки ArrayIndexOutOfBoundsException.
         * в цикле перебора элементов массива указал неверную длину массива (arr.length + 1).*/
        int[] arr = {1, 2, 3, 4, 5, 6};

        try {
            for (int i = 0; i < arr.length + 1; i++) {
                System.out.print(arr[i] + " ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    public static int sumArrayElems(String[][] array) throws MyArraySizeException, MyArrayDataException{
        int[][] numsArr = new int[4][4];
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4) {
                throw new MyArraySizeException("Неверный размер массива! Формат входного массива 4x4.");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    numsArr[i][j] = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не удалось преобразовать данные массива в ячейке: " + i + "x" + j + ".");
                }
                sum += numsArr[i][j];
            }
        }

        return sum;
    }
}
