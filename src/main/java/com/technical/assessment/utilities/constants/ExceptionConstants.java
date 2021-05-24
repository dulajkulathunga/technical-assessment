package com.technical.assessment.utilities.constants;

public enum ExceptionConstants {

    DEFAULT_ERROR_MESSAGE("Something went wrong !"),
    METHOD_NOT_IMPLEMENT("method not yet implement"),
    INVALID_INPUT_NOT_ALLOWED("Invalid inputs are not allowed"),
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
