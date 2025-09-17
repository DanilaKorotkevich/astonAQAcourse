package org.aston.Lesson_6.Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    /**Вариант с испоьзованием Map, получается что тут никак не реализовать ситуацию с однофамильцами*/
    Map<String, String> phoneDirMap = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        phoneDirMap.put(surname, phoneNumber);
    }

    public void get(String name) {
        System.out.println(name + ":\n" + phoneDirMap.get(name) + "\n");
    }

    @Override
    public String toString() {
        return "phoneDirMap: " + phoneDirMap;
    }

    /**Вариант через List, в этом случае нет связи ключ-значение, но реализован случай с однофамильцами*/
    private List<String> surname = new ArrayList<>();
    private List<String> phoneNumber = new ArrayList<>();

    public void addInList(String name, String number) {
        surname.add(name);
        phoneNumber.add(number);
    }

    public void getFromList(String name) {
        System.out.println(name + ":");
        for (int i = 0; i < surname.size(); i++) {
            if (name == surname.get(i)) {
                System.out.println(phoneNumber.get(i));
            }
        }
    }
}
