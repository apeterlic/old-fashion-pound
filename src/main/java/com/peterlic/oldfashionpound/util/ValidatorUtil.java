package com.peterlic.oldfashionpound.util;

import com.peterlic.oldfashionpound.exception.BadRequestException;
import com.peterlic.oldfashionpound.exception.NotAllowedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidatorUtil {

    public static final String ERROR_BOTH_NUMBERS_MUST_BE_PRESENT = "Both numbers must be present";
    public static final String ERROR_DIVISION_WITH_0_NOT_ALLOWED = "Division with 0 not allowed";
    private static final String PARAMETER_MUST_NOT_BE_NULL = "Parameter must not be null [parameter=%s]";

    private static final Logger log = LoggerFactory.getLogger(ValidatorUtil.class);

    private ValidatorUtil() {
    }

    public static void validateRequest(boolean anyBlank) {
        if (anyBlank) {
            log.info("-- validateRequest() - Parameter is blank");
            throw new BadRequestException(ERROR_BOTH_NUMBERS_MUST_BE_PRESENT);
        }
    }

    public static void validateDivisor(Integer divisor) {
        if (divisor == 0) {
            log.info("-- validateDivisor() - Divisor is 0");
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
