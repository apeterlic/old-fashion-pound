package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import org.springframework.stereotype.Component;

/**
 * Class that contains logic for multiplication operation.
 *
 * @author Ana Peterlić
 */
@Component
public class MultiplicationOperation extends AbstractOperation<PriceModel, Integer> {

    @Override
    public String process(PriceModel firstFactor, Integer secondFactor) {
        int firstFactorInPence = convertToPence(firstFactor);
        int productInPence = firstFactorInPence * secondFactor;
        return createResult(productInPence);
    }

}
