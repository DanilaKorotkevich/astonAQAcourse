package org.aston.Lesson_4.Task1;

public class Bowl {
    private boolean isEmpty = true;
    public int foodAmount;

    public boolean isFill() {
        return isEmpty = false;
    }

    public boolean isEmpty() {
        return isEmpty = true;
    }

    public void fillBowl(int foodAmount) {
        this.foodAmount += foodAmount;
    }

    public void emptyBowl(int foodAmount) {
        this.foodAmount -= foodAmount;
    }
}
