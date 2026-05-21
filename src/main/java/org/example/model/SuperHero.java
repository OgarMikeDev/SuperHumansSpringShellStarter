package org.example.model;

public class SuperHero extends SuperHuman {
    private long count_save_human;

    public long getCount_save_human() {
        return count_save_human;
    }

    public void setCount_save_human(long count_save_human) {
        this.count_save_human = count_save_human;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                super.toString() +
                "count_save_human=" + count_save_human +
                '}';
    }
}
