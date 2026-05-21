package org.example.dto;

public abstract class SuperHumanDto {
    private String name;
    private String description_super_power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription_super_power() {
        return description_super_power;
    }

    public void setDescription_super_power(String description_super_power) {
        this.description_super_power = description_super_power;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", description_super_power='" + description_super_power + '\'' +
                '}';
    }
}
