package com.example.domain.model;

public class Username {
    private final String value;

    public Username(String value) {
        if (value == null || value.isEmpty() || !value.matches("^[a-zA-Z0-9_]+$")) {
            throw new IllegalArgumentException("Invalid username");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
