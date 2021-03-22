package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Class that contains logic for subtraction operation.
 *
 * @author Ana Peterlić
 */
@Component
public class SubtractionOperation extends AbstractOperation<PriceModel, PriceModel> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String process(PriceModel firstNumber, PriceModel secondNumber) {
        log.info(">> process() > firstNumber: {}, secondNumber: {}", firstNumber, secondNumber);
        int penceFirstNumber = convertToPence(firstNumber);
        int penceSecondNumber = convertToPence(secondNumber);
        int differenceInPence = penceFirstNumber - penceSecondNumber;
        String result = createResult(differenceInPence);
        log.info("<< process() < result: {}", result);
        return result;
    }
}
