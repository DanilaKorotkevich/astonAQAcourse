package org.aston.Lesson_4.Task2;

public class Rectangle implements GeometricFigure {
    private double length;
    private double width;
    private String name;
    private String backgroundColor;
    private String borderColor;

    public Rectangle(double length, double width, String backgroundColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.name = "Прямоугольник";
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double calcArea() {
        return length * width;
    }

    @Override
    public String getFigureName() {
        return name;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}
