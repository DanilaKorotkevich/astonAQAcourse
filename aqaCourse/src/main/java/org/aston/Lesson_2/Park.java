package org.aston.Lesson_2;

import java.util.ArrayList;
import java.util.List;

public class Park {

    private String name;
    private List<Attraction> attractions;

    public Park(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
    }

    public class Attraction {
        private String name;
        private String openTime;
        private String closeTime;
        private int price;

        public Attraction(String name, String openTime, String closeTime, int price) {
            this.name = name;
            this.openTime = openTime;
            this.closeTime = closeTime;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getOpenTime() {
            return openTime;
        }

        public String getCloseTime() {
            return closeTime;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Атракцион: " + name + ", время работы: " + openTime + " - " + closeTime + ", стоимость: " + price;
        }
    }

    public void addAttraction(String name, String openTime, String closeTime, int price) {
        Attraction attraction = new Attraction(name, openTime, closeTime, price);
        attractions.add(attraction);
    }
}
