package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class AdditionOperationTest {

    private static final Logger log = LoggerFactory.getLogger(MultiplicationOperationTest.class);

    private AdditionOperation additionOperation;

    @BeforeEach
    public void setup() {
        additionOperation = new AdditionOperation();
    }

    @DisplayName("SUM - OK")
    @Test
    void testSum_Ok() {
        log.info(">> testSum_Ok()");

        String firstNumber = "5p 17s 8d";
        String secondNumber = "3p 4s 10d";

        String response = additionOperation.process(new PriceModel(firstNumber), new PriceModel(secondNumber));
        log.info("-- testSum_Ok() - response: {}", response);

        assertAll(
                () -> assertNotNull(response, "Response is null"),
                () -> assertTrue(response.contains("9p"), "Pounds is not 9"),
                () -> assertTrue(response.contains("2s"), "Shillings is not 2"),
                () -> assertTrue(response.contains("6d"), "Pence is not 6")
        );

        log.info("<< testSum_Ok()");
    }

    @DisplayName("SUM (add pound) - OK")
    @Test
    void testSum_AddPound_Ok() {
        log.info(">> testSum_AddPound_Ok()");

        String firstNumber = "17s 8d";
        String secondNumber = "5s 10d";

        String response = additionOperation.process(new PriceModel(firstNumber), new PriceModel(secondNumber));
        log.info("-- testSum_AddPound_Ok() - response: {}", response);

        assertAll(
                () -> assertNotNull(response, "Response is null"),
                () -> assertTrue(response.contains("1p"), "Pounds is not 1"),
                () -> assertTrue(response.contains("3s"), "Shillings is not 3"),
                () -> assertTrue(response.contains("6d"), "Pence is not 6")
        );

        log.info("<< testSum_AddPound_Ok()");
    }

}
