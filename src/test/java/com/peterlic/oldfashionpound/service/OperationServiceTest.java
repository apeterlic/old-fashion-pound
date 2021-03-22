package com.peterlic.oldfashionpound.service;

import com.peterlic.oldfashionpound.exception.BadRequestException;
import com.peterlic.oldfashionpound.exception.NotAllowedException;
import com.peterlic.oldfashionpound.operation.DivisionOperation;
import com.peterlic.oldfashionpound.operation.MultiplicationOperation;
import com.peterlic.oldfashionpound.operation.SubtractionOperation;
import com.peterlic.oldfashionpound.operation.AdditionOperation;
import com.peterlic.oldfashionpound.util.ValidatorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class OperationServiceTest {

    private static final Logger log = LoggerFactory.getLogger(OperationServiceTest.class);
    private OperationService operationService;

    @BeforeEach
    public void setup() {
        operationService = new OperationService(new AdditionOperation(), new SubtractionOperation(), new MultiplicationOperation(), new DivisionOperation());
    }

    @DisplayName("DIVIDE - BAD_REQUEST")
    @Test
    void testDivide_BadRequest() {
        log.info(">> testDivide_BadRequest()");

        BadRequestException exception = assertThrows(BadRequestException.class, () ->
                operationService.divide("5p 17s 8d", null));

        assertAll(
                () -> assertNotNull(exception, "Response is null"),
                () -> assertEquals(ValidatorUtil.ERROR_BOTH_NUMBERS_MUST_BE_PRESENT, exception.getMessage(), "Message is not correct")
        );

        log.info("<< testDivide_BadRequest()");
    }

    @DisplayName("DIVIDE - NOT_ALLOWED")
    @Test
    void testDivide_NotAllowed() {
        log.info(">> testDivide_NotAllowed()");
        String firstNumber = "5p 17s 8d";
        Integer secondNumber = 0;

        NotAllowedException exception = assertThrows(NotAllowedException.class, () ->
                operationService.divide(firstNumber, secondNumber));

        assertAll(
                () -> assertNotNull(exception, "Response is null"),
                () -> assertEquals(ValidatorUtil.ERROR_DIVISION_WITH_0_NOT_ALLOWED, exception.getMessage(), "Message is not correct")
        );

        log.info("<< testDivide_NotAllowed()");
    }

    @DisplayName("MULTIPLY - BAD_REQUEST")
    @Test
    void testMultiply_BadRequest() {
        log.info(">> testMultiply_BadRequest()");

        BadRequestException exception = assertThrows(BadRequestException.class, () ->
                operationService.add(null, null));

        assertAll(
                () -> assertNotNull(exception, "Response is null"),
                () -> assertEquals(ValidatorUtil.ERROR_BOTH_NUMBERS_MUST_BE_PRESENT, exception.getMessage(), "Message is not correct")
        );

        log.info("<< testMultiply_BadRequest()");
    }

    @DisplayName("SUBSTRATE - BAD_REQUEST")
    @Test
    void testSubstrate_BadRequest() {
        log.info(">> testSubstrate_BadRequest()");

        BadRequestException exception = assertThrows(BadRequestException.class, () ->
                operationService.substrate(null, null));

        assertAll(
                () -> assertNotNull(exception, "Response is null"),
                () -> assertEquals(ValidatorUtil.ERROR_BOTH_NUMBERS_MUST_BE_PRESENT, exception.getMessage(), "Message is not correct")
        );

        log.info("<< testSubstrate_BadRequest()");
    }

    @DisplayName("SUM - BAD_REQUEST")
    @Test
    void testSum_BadRequest() {
        BadRequestException exception = assertThrows(BadRequestException.class, () ->
                operationService.add(null, null));

        assertAll(
                () -> assertNotNull(exception, "Response is null"),
                () -> assertEquals(ValidatorUtil.ERROR_BOTH_NUMBERS_MUST_BE_PRESENT, exception.getMessage(), "Message is not correct")
        );
    }
}
