package org.aston.Lesson_4.Task1;

public class Main {

    public static void main(String[] args) {
        AnimalCreater animalCreater = new AnimalCreater();
        Bowl foodBowl = new Bowl();

        /**Задание 1*/
        /** 1 часть задания*/
        animalCreater.addCat(3);
        animalCreater.getCatList().get(0).run(150);
        animalCreater.getCatList().get(1).swim(10);
        System.out.println("Количество котов: " + animalCreater.getCatsCount() + "\n");

        animalCreater.addDog(3);
        animalCreater.getDogList().get(0).run(450);
        animalCreater.getDogList().get(1).run(501);
        animalCreater.getDogList().get(2).swim(10);
        System.out.println("Количество собак: " + animalCreater.getDogsCount() + "\n");

        System.out.println("Количество животных: " + Animal.getAnimalCount() + "\n");

        /**2 часть задания*/
        foodBowl.fillBowl(50);
        System.out.println("Добавлено еды: " + foodBowl.foodAmount);
        for (int i = 0; i < animalCreater.getCatList().size(); i++) {
            System.out.print(i + 1 + ". ");
            animalCreater.getCatList().get(i).eat(foodBowl);
        }
        System.out.println("\nКоличество еды в миске: " + foodBowl.foodAmount);
    }
}
