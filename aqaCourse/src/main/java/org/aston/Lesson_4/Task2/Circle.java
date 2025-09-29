package org.aston.Lesson_4.Task2;

public class Circle implements GeometricFigure {
    private double radius;
    private String name;
    private String backgroundColor;
    private String borderColor;

    public Circle(double radius, String backgroundColor, String borderColor) {
        this.radius = radius;
        this.name = "Круг";
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
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
