package org.aston.Lesson_3;

public class Product {
    private String name;
    private String date;
    private String creater;
    private String country;
    private int price;
    private boolean status;

    public Product(String name, String date, String creater, String country, int price, boolean status) {
        this.name = name;
        this.date = date;
        this.creater = creater;
        this.country = country;
        this.price = price;
        this.status = status;
    }

    public String print() {
        return "Название: " + name + "\nДата производства: " + date+ "\nПроизводитель: " + creater + "\nСтрана производства: " + country + "\nЦена: " + price + "\nСтатус бронирование: " + status + "\n";
    }
}
