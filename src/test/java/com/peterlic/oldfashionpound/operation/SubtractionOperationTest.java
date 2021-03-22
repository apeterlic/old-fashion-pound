package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionOperationTest {

    private static final Logger log = LoggerFactory.getLogger(MultiplicationOperationTest.class);

    private SubtractionOperation subtractionOperation;

    @BeforeEach
    public void setup() {
        subtractionOperation = new SubtractionOperation();
    }

    @DisplayName("SUBSTRATE - OK")
    @Test
    void testSubstrate_Ok() {
        log.info(">> testSubstrate_Ok()");

        String firstNumber = "5p 17s 8d";
        String secondNumber = "3p 4s 10d";

        String response = subtractionOperation.process(new PriceModel(firstNumber), new PriceModel(secondNumber));
        log.info("-- testSubstrate_Ok() - response: {}", response);

        assertAll(
                () -> assertNotNull(response, "Response is null"),
                () -> assertTrue(response.contains("2p"), "Pounds is not 2"),
                () -> assertTrue(response.contains("12s"), "Shillings is not 12"),
                () -> assertTrue(response.contains("10d"), "Pence is not 10")
        );

        log.info("<< testSubstrate_Ok()");
    }

    @DisplayName("SUBSTRATE - OK")
    @Test
    void testSubstrate__WithoutPounds_Ok() {
        log.info(">> testSubstrate__WithoutPounds_Ok()");

        String firstNumber = "17s 8d";
        String secondNumber = "4s 10d";

        String response = subtractionOperation.process(new PriceModel(firstNumber), new PriceModel(secondNumber));
        log.info("-- testSubstrate__WithoutPounds_Ok() - response: {}", response);

        assertAll(
                () -> assertNotNull(response, "Response is null"),
                () -> assertTrue(response.contains("0p"), "Pounds is not 0"),
                () -> assertTrue(response.contains("12s"), "Shillings is not 12"),
                () -> assertTrue(response.contains("10d"), "Pence is not 10")
        );

        log.info("<< testSubstrate__WithoutPounds_Ok()");
    }

}
