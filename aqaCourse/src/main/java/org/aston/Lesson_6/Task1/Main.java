package org.aston.Lesson_6.Task1;

import java.util.*;

public class Main {
    private static Collection<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        addStudent(students);
        removeStudent(students);
        switchCourse(students);

        for (Student student : students) {
            System.out.println(student);
        }

        Set<Student> studentsSet = new HashSet<>(students);
        printStudents(studentsSet, 3);

    }

    private static void addStudent(Collection<Student> students) {
        students.add(new Student("Илья", "AC-16", 1, 4));
        students.add(new Student("Алексей", "AC-16", 1, 3));
        students.add(new Student("Екатерина", "AC-16", 1, 5));
        students.add(new Student("Анатолий", "AC-26", 2, 2));
        students.add(new Student("Наталья", "AC-26", 2, 4));
        students.add(new Student("Евгения", "AC-26", 2, 3));
        students.add(new Student("Анастасия", "AC-36", 3, 5));
        students.add(new Student("Иван", "AC-36", 3, 2));
        students.add(new Student("Александр", "AC-36", 3, 3));
    }

    private static void removeStudent(Collection<Student> students) {
        System.out.println();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getGrade() < 3) {
                iterator.remove();
            }
        }
    }

    private static void switchCourse(Collection<Student> students) {
        System.out.println();
        for (Student student : students) {
            if (student.getGrade() >= 3) {
                student.setCourse(1);
            }
        }
    }

    private static void printStudents(Set<Student> students, int course) {
        System.out.println();
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
