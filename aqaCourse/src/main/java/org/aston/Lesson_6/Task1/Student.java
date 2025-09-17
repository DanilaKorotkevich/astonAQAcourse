package org.aston.Lesson_6.Task1;

public class Student {
    private String name;
    private String group;
    private int course;
    private int grade;

    public Student(String name, String group, int course, int grade) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course += course;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", group: " + group +
                ", course: " + course +
                ", grade: " + grade;
    }
}
