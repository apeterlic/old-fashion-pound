package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class DivisionOperationTest {

    private static final Logger log = LoggerFactory.getLogger(DivisionOperationTest.class);

    private DivisionOperation divisionOperation;

    @BeforeEach
    public void setup() {
        divisionOperation = new DivisionOperation();
    }

    @DisplayName("DIVIDE (one reminder) - OK")
    @Test
    void testDivide_Ok() {
        log.info(">> testDivide_OneReminder_Ok()");
        String firstNumber = "5p 17s 8d";
        Integer secondNumber = 3;

        String response = divisionOperation.process(new PriceModel(firstNumber), secondNumber);
        log.info("-- testDivide_OneReminder_Ok() - response: {}", response);

        assertAll(
                () -> assertNotNull(response, "Response is null"),
                () -> assertEquals("1p 19s 2d (2d)", response),
                () -> assertTrue(response.contains("1p"), "Pounds is not 1"),
                () -> assertTrue(response.contains("19s"), "Shillings is not 19"),
                () -> assertTrue(response.contains("2d"), "Pence is not 2"),
                () -> assertTrue(response.contains("(2d)"), "Reminder is not (2d)")
        );

        log.info("<< testDivide_OneReminder_Ok()");
    }

    @DisplayName("DIVIDE (two reminders) - OK")
    @Test
    void testDivide_TwoReminders_Ok() {
        log.info(">> testDivide_TwoReminders_Ok()");
        String firstNumber = "18p 16s 1d";
        Integer secondNumber = 15;

        String response = divisionOperation.process(new PriceModel(firstNumber), secondNumber);
        log.info("-- testDivide_TwoReminders_Ok() - response: {}", response);

        assertAll(
                () -> assertNotNull(response, "Response is null"),
                () -> assertEquals("1p 5s 0d (1s 1d)", response),
                () -> assertTrue(response.contains("1p"), "Pounds is not 1"),
                () -> assertTrue(response.contains("5s"), "Shillings is not 5"),
                () -> assertTrue(response.contains("0d"), "Pence is not 0"),
                () -> assertTrue(response.contains("(1s 1d)"), "Reminder is not (1s 1d)")
        );

        log.info("<< testDivide_TwoReminders_Ok()");
    }

    @DisplayName("DIVIDE (no reminder) - OK")
    @Test
    void testDivide_NoReminder_Ok() {
        log.info(">> testDivide_NoReminder_Ok()");
        String firstNumber = "6p 0s 0d";
        Integer secondNumber = 3;

        String response = divisionOperation.process(new PriceModel(firstNumber), secondNumber);
        log.info("-- testDivide_NoReminder_Ok() - response: {}", response);

        assertAll(
                () -> assertNotNull(response, "Response is null"),
                () -> assertEquals("2p 0s 0d", response),
                () -> assertTrue(response.contains("2p"), "Pounds is not 2"),
                () -> assertTrue(response.contains("0s"), "Shillings is not 0"),
                () -> assertTrue(response.contains("0d"), "Pence is not 0"),
                () -> assertFalse(response.contains("("), "Reminder exists")
        );

        log.info("<< testDivide_NoReminder_Ok()");
    }


}
