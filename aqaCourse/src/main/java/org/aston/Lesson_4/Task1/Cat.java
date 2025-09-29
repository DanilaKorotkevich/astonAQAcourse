package org.aston.Lesson_4.Task1;

import java.util.Random;

public class Cat extends Animal {
    private int maxRunDistance = 200;
    private boolean satiety;

    public Cat(String name) {
        super(name, false, true);
        this.satiety = false;
    }

    public void eat(Bowl foodBowl) {
        int foodAmount = randomFoodAmount();
        while(!satiety) {
            if (foodAmount <= foodBowl.foodAmount) {
                satiety = true;
                System.out.println("Кот: " + getName() + " съел: " + foodAmount + ", сытость: " + satiety);
                foodBowl.emptyBowl(foodAmount);
            } else {
                System.out.println("Кот: " + getName() + ", сытость: " + satiety);
                return;
            }
        }
    }

    private int randomFoodAmount() {
        Random random = new Random();
        return random.nextInt(6) + 15;
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
        super.swim(length);
    }
}
