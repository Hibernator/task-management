package com.baeldung.ls.persistence.model;

public enum TaskStatus {
    // @formatter:off
    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    ON_HOLD("On Hold"),
    DONE("Done");
    // @formatter:on

    private final String label;

    TaskStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
