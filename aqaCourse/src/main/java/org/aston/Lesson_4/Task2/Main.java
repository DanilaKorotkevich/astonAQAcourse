package org.aston.Lesson_4.Task2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<GeometricFigure> figures = new ArrayList<>();
        figures.add(new Circle(5, "красный", "черный"));
        figures.add(new Rectangle(10, 5, "Зеленый", "Желтый"));
        figures.add(new Triangle(2, 3, 5, "синий", "серый"));
        for (GeometricFigure figure : figures) {
            print(figure);
        }
    }

    public static void print(GeometricFigure figure) {
        System.out.println("Фигура: " + figure.getFigureName());
        System.out.println("Периметр: " + String.format("%.2f", figure.calcPerimeter()));
        System.out.println("Площадь: " + String.format("%.2f", figure.calcArea()));
        System.out.println("Цвет фона: " + figure.getBackgroundColor());
        System.out.println("Цвет границы: " + figure.getBorderColor());
        System.out.println("---------------------------");
    }
}
