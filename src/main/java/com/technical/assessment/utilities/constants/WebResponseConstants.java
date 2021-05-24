package com.technical.assessment.utilities.constants;

public enum WebResponseConstants {
    CART_ADDED("Item added to cart"),
    DELETE_FROM_CART("Item added deleted");

    private String string;

    private WebResponseConstants(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
