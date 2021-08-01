package ru.training.at.hw10.constants;

public enum CardEnum {
    CARD("Test");

    private String text;

    CardEnum(String name) {
        this.text = name;
    }

    public String getText() {
        return this.text;
    }
}
