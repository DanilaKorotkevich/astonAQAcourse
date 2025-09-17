package org.aston.Lesson_6.Task2;

public class Main {

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        /**Map*/
        phoneDirectory.add("Лукьянова", "+375(44)493-87-84");
        phoneDirectory.add("Соколов", "+375(33)755-79-53");
        phoneDirectory.add("Гусева", "+375(29)324-81-70");
        phoneDirectory.add("Кузнецов", "+375(44)358-87-64");
        phoneDirectory.add("Семенова", "+375(29)689-46-41");
        phoneDirectory.add("Голубев", "+375(29)071-92-51");
        phoneDirectory.add("Баранова", "+375(33)755-93-51");
        phoneDirectory.add("Федорова", "+375(44)095-86-09");
        phoneDirectory.add("Клюева", "+375(29)896-53-89");
        phoneDirectory.add("Мартынов", "+375(33)503-85-55");
        phoneDirectory.add("Гусева", "+375(29)568-12-90");
        phoneDirectory.add("Кузнецов", "+375(44)109-71-44");

        phoneDirectory.get("Кузнецов");

        /**List*/
        phoneDirectory.addInList("Лукьянова", "+375(44)493-87-84");
        phoneDirectory.addInList("Соколов", "+375(33)755-79-53");
        phoneDirectory.addInList("Гусева", "+375(29)324-81-70");
        phoneDirectory.addInList("Кузнецов", "+375(44)358-87-64");
        phoneDirectory.addInList("Семенова", "+375(29)689-46-41");
        phoneDirectory.addInList("Голубев", "+375(29)071-92-51");
        phoneDirectory.addInList("Баранова", "+375(33)755-93-51");
        phoneDirectory.addInList("Федорова", "+375(44)095-86-09");
        phoneDirectory.addInList("Клюева", "+375(29)896-53-89");
        phoneDirectory.addInList("Мартынов", "+375(33)503-85-55");
        phoneDirectory.addInList("Гусева", "+375(29)568-12-90");
        phoneDirectory.addInList("Кузнецов", "+375(44)109-71-44");

        phoneDirectory.getFromList("Кузнецов");
    }
}
