package com.peterlic.oldfashionpound.util;

public class Check {

    private Check() {
    }

    /**
     * Is null boolean.
     *
     * @param <T>       the type parameter
     * @param parameter the parameter
     * @return the boolean
     */
    public static <T> boolean isNull(T parameter) {
        return (parameter == null);
    }

}