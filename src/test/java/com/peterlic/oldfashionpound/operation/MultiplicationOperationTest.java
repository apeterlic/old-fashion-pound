package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationOperationTest {

    private static final Logger log = LoggerFactory.getLogger(MultiplicationOperationTest.class);

    private MultiplicationOperation multiplicationOperation;

    @BeforeEach
    public void setup() {
        multiplicationOperation = new MultiplicationOperation();
    }

    @DisplayName("MULTIPLY - OK")
    @Test
    void testMultiply_Ok() {
        log.info(">> testMultiply_Ok()");
        String firstNumber = "5p 17s 8d";
        Integer secondNumber = 2;

        String response = multiplicationOperation.process(new PriceModel(firstNumber), secondNumber);
        log.info("-- testMultiply_Ok() - response: {}", response);

        assertAll(
                () -> assertNotNull(response, "Response is null"),
                () -> assertTrue(response.contains("11p"), "Pounds is not 9"),
                () -> assertTrue(response.contains("15s"), "Shillings is not 2"),
                () -> assertTrue(response.contains("4d"), "Pence is not 6")
        );

        log.info("<< testMultiply_Ok()");
    }

    @DisplayName("MULTIPLY (by zero) - OK")
    @Test
    void testMultiply_ByZero_Ok() {
        log.info(">> testMultiply_ByZero_Ok()");
        String firstNumber = "5p 17s 8d";
        Integer secondNumber = 0;

        String response = multiplicationOperation.process(new PriceModel(firstNumber), secondNumber);
        log.info("-- testMultiply_ByZero_Ok() - response: {}", response);

        assertAll(
                () -> assertNotNull(response, "Response is null"),
                () -> assertEquals("0p 0s 0d", response),
                () -> assertTrue(response.contains("0p"), "Pounds is not 0"),
                () -> assertTrue(response.contains("0s"), "Shillings is not 0"),
                () -> assertTrue(response.contains("0d"), "Pence is not 0")
        );

        log.info("<< testMultiply_ByZero_Ok()");
    }

    @DisplayName("MULTIPLY (zero shillings) - OK")
    @Test
    void testMultiply_OneNumberZero_Ok() {
        log.info(">> testMultiply_OneNumberZero_Ok()");
        String firstNumber = "5p 0s 8d";
        Integer secondNumber = 2;

        String response = multiplicationOperation.process(new PriceModel(firstNumber), secondNumber);
        log.info("-- testMultiply_OneNumberZero_Ok() - response: {}", response);

        assertAll(
                () -> assertNotNull(response, "Response is null"),
                () -> assertTrue(response.contains("10p"), "Pounds is not 10"),
                () -> assertTrue(response.contains("1s"), "Shillings is not 1"),
                () -> assertTrue(response.contains("4d"), "Pence is not 4")
        );

        log.info("<< testMultiply_OneNumberZero_Ok()");
    }


}
