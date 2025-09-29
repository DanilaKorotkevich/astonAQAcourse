package org.aston.Lesson_3;

public class Main {
    public static void main(String[] args) {
        Product[] productSArr = new Product[5];

        productSArr[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productSArr[1] = new Product("Iphone 11", "01.09.2018", "Apple Comp.", "USA", 2800, false);
        productSArr[2] = new Product("Samsung S24", "23.04.2023", "Samsung Corp.", "Korea", 4300, true);
        productSArr[3] = new Product("Iphone 16 Pro Max", "01.09.2025", "Apple Comp.", "USA", 7000, false);
        productSArr[4] = new Product("Samsung S23", "11.12.2022", "Samsung Corp.", "Korea", 1233, false);

        for (Product product : productSArr) {
            System.out.println(product.print());
        }

        Park park = new Park("Park");

        park.addAttraction("White wings", "09:00", "17:00", 12);
        park.addAttraction("Hot persuid", "10:00", "18:00", 15);
        park.addAttraction("Crazy dazy", "12:00", "20:00", 10);
    }
}