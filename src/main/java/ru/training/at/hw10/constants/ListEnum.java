package ru.training.at.hw10.constants;

public enum ListEnum {
    LIST("TODO");

    private String text;

    ListEnum(String name) {
        this.text = name;
    }

    public String getText() {
        return this.text;
    }
}


