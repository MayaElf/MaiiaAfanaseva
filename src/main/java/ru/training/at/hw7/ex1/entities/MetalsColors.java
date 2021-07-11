package ru.training.at.hw7.ex1.entities;

import com.epam.jdi.tools.DataClass;

public class MetalsColors extends DataClass<MetalsColors> {
    public int[] summary;
    public String color;
    public String metals;
    public String[] elements;
    public String[] vegetables;

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }
}
