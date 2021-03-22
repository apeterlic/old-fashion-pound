package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import org.springframework.stereotype.Component;

/**
 * Class that contains logic for subtraction operation.
 *
 * @author Ana Peterlić
 */
@Component
public class SubtractionOperation extends AbstractOperation<PriceModel, PriceModel> {

    @Override
    public String process(PriceModel firstNumber, PriceModel secondNumber) {
        int penceFirstNumber = convertToPence(firstNumber);
        int penceSecondNumber = convertToPence(secondNumber);
        int differenceInPence = penceFirstNumber - penceSecondNumber;
        return createResult(differenceInPence);
    }
}
