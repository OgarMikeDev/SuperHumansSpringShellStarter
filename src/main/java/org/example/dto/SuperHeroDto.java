package org.example.dto;

public class SuperHeroDto extends SuperHumanDto {
    private long count_save_human;

    public long getCount_save_human() {
        return count_save_human;
    }

    public void setCount_save_human(long count_save_human) {
        this.count_save_human = count_save_human;
    }

    @Override
    public String toString() {
        return "SuperHeroDto{" +
                super.toString() +
                "count_save_human=" + count_save_human +
                '}';
    }
}
