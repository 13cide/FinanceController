package com.example.financecontroller.DataClasses;

public class Currency {
    private String name;
    private double value;
    private final String symbol;

    public Currency(String name, double value, String symbol) {
        this.name = name;
        this.value = value;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }
}

