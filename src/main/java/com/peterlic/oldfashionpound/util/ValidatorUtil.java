package com.peterlic.oldfashionpound.util;

import com.peterlic.oldfashionpound.exception.BadRequestException;
import com.peterlic.oldfashionpound.exception.NotAllowedException;

public class ValidatorUtil {

    public static final String ERROR_BOTH_NUMBERS_MUST_BE_PRESENT = "Both numbers must be present";
    public static final String ERROR_DIVISION_WITH_0_NOT_ALLOWED = "Division with 0 not allowed";
    private static final String PARAMETER_MUST_NOT_BE_NULL = "Parameter must not be null [parameter=%s]";

    private ValidatorUtil() {
    }

    public static void validateRequest(boolean anyBlank) {
        if (anyBlank) {
            throw new BadRequestException(ERROR_BOTH_NUMBERS_MUST_BE_PRESENT);
        }
    }

    public static void validateDivisor(Integer divisor) {
        if (divisor == 0) {
            throw new NotAllowedException(ERROR_DIVISION_WITH_0_NOT_ALLOWED);
        }
    }

    /**
     * Checks if the provided object is a <b>null</b> reference.<br>
     *
     * @param parameter
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T notNull(T parameter, String name) {
        if (Check.isNull(parameter)) {
            throwException(String.format(PARAMETER_MUST_NOT_BE_NULL, name));
        }

        return parameter;
    }

    /**
     * Throws a validation exception by the given message.
     *
     * @param message
     */
    private static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
}
