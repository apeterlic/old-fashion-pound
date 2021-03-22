package com.peterlic.oldfashionpound.model;

public enum PriceType {
    POUND("p"), SHILLING("s"), PENCE("d");

    private final String value;

    PriceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
