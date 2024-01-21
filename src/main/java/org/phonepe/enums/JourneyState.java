package org.phonepe.enums;

public enum JourneyState {

    CREATED("CREATED"), ACTIVE("ACTIVE"), EXPIRED("EXPIRED");

    private final String name;

    JourneyState(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }


}

