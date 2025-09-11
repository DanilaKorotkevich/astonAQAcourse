package org.aston.Lesson_4.Task1;

public class Animal {
    private static int animalCount = 0;
    private String name;
    private boolean isSwimming;
    private boolean isRunning;

    public Animal(String name, boolean isSwimming, boolean isRunning) {
        this.name = name;
        this.isSwimming = isSwimming;
        this.isRunning = isRunning;
        animalCount++;
    }

    public void run(int length) {
        if (isRunning) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println(name + " не умеет бегать!");
        }

    }
    public void swim(int length) {
        if (isSwimming) {
            System.out.println(name + " проплыл " + length + " м.");
        } else {
            System.out.println(name + " не умеет плавать!");
        }
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
