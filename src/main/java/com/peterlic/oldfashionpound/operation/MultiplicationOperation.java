package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Class that contains logic for multiplication operation.
 *
 * @author Ana Peterlić
 */
@Component
public class MultiplicationOperation extends AbstractOperation<PriceModel, Integer> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String process(PriceModel firstFactor, Integer secondFactor) {
        log.info(">> process() > firstFactor: {}, secondFactor: {}", firstFactor, secondFactor);
        int firstFactorInPence = convertToPence(firstFactor);
        int productInPence = firstFactorInPence * secondFactor;
        String result = createResult(productInPence);
        log.info("<< process() < result: {}", result);
        return result;
    }

}
