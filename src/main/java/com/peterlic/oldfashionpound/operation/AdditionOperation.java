package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import org.springframework.stereotype.Component;

/**
 * Class that contains logic for addition operation.
 *
 * @author Ana Peterlić
 */
@Component
public class AdditionOperation extends AbstractOperation<PriceModel, PriceModel> {

    @Override
    public String process(PriceModel firstNumber, PriceModel secondNumber) {
        int penceFirstNumber = convertToPence(firstNumber);
        int penceSecondNumber = convertToPence(secondNumber);
        int sumPence = penceFirstNumber + penceSecondNumber;
        return createResult(sumPence);
    }
}
