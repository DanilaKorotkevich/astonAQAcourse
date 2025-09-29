package org.aston.Lesson_4.Task2;

public class Triangle implements GeometricFigure {
    private double a;
    private double b;
    private double c;
    private String name;
    private String backgroundColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String backgroundColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.name = "треугольник";
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calcPerimeter() {
        return a + b + c;
    }

    @Override
    public double calcArea() {
        double p = calcPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String getFigureName() {
        return name;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
