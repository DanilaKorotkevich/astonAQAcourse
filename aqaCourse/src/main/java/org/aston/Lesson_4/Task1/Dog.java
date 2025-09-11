package org.aston.Lesson_4.Task1;

public class Dog extends Animal {
    private int maxRunDistance = 500;
    private int maxSwimDistance = 10;

    public Dog(String name) {
        super(name, true, true);
    }

    @Override
    public void run(int length) {
        if (length <= maxRunDistance) {
            super.run(length);
        } else {
            System.out.println(super.getName() + " не может бежать " + length + " м.");
        }
    }

    @Override
    public void swim(int length) {
        if (length <= maxSwimDistance) {
            super.swim(length);
        } else {
            System.out.println(super.getName() + " не может плыть " + length + " м.");
        }
    }
}
