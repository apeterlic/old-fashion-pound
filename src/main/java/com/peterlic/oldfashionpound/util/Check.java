package com.peterlic.oldfashionpound.util;

import java.util.Collection;

public class Check
{

    private Check()
    {
    }

    /**
     * Is null boolean.
     *
     * @param <T>
     *            the type parameter
     * @param parameter
     *            the parameter
     *
     * @return the boolean
     */
    public static <T> boolean isNull(T parameter)
    {
        return (parameter == null);
    }

    /**
     * Is empty boolean.
     *
     * @param <C>
     *            the type parameter
     * @param collection
     *            the collection
     *
     * @return the boolean
     */
    public static <C extends Collection<?>> boolean isEmpty(C collection)
    {
        return (isNull(collection) || collection.isEmpty());
    }

}