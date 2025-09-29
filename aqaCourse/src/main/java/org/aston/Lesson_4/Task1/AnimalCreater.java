package org.aston.Lesson_4.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalCreater {
    private List<Cat> catList = new ArrayList<>();
    private List<Dog> dogList = new ArrayList<>();

    public int getCatsCount() {
        return catList.size();
    }

    public int getDogsCount() {
        return dogList.size();
    }

    public void addCat(int amount) {
        for (int i = 0; i < amount; i++) {
            catList.add(new Cat(randName()));
        }
    }

    public void addDog(int amount) {
        for (int i = 0; i < amount; i++) {
            dogList.add(new Dog(randName()));
        }
    }

    private String randName() {
        char[] vowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        char[] consonants = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м',
                'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};

        Random random = new Random();
        StringBuilder name = new StringBuilder();

        boolean startWithVowel = random.nextBoolean();

        for (int i = 0; i < 5; i++) {
            if ((i % 2 == 0 && startWithVowel) || (i % 2 != 0 && !startWithVowel)) {
                name.append(vowels[random.nextInt(vowels.length)]);
            } else {
                name.append(consonants[random.nextInt(consonants.length)]);
            }
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    public List<Cat> getCatList() {
        return catList;
    }

    public List<Dog> getDogList() {
        return dogList;
    }
}