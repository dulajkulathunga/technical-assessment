package com.technical.assessment.utilities.constants;

public enum ExceptionConstants {

    DEFAULT_ERROR_MESSAGE("Something went wrong !"),
    INVALID_ARGUMENT("invalid argument");
    private String string;

    private ExceptionConstants(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

}
