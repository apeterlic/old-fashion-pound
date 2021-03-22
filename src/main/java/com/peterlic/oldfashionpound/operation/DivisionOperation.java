package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import com.peterlic.oldfashionpound.model.PriceType;
import com.peterlic.oldfashionpound.util.ConstantUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Class that contains logic for division operation.
 *
 * @author Ana Peterlić
 */
@Component
public class DivisionOperation extends AbstractOperation<PriceModel, Integer> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String process(PriceModel dividend, Integer divisor) {
        log.info(">> process() > dividend: {}, divisor: {}", dividend, divisor);

        int penceDividend = convertToPence(dividend);

        String result = createResult(penceDividend / divisor);
        String reminder = createReminder(penceDividend, divisor);
        if (StringUtils.isNotBlank(reminder)) {
            result += " (" + reminder + ")";

        }
        log.info("<< process() < result: {}", result);
        return result;
    }

    /**
     * Methods that returns reminder (if exist).
     *
     * @param penceDividend dividend represented in pence
     * @param divisor       divisor value
     * @return reminder
     */
    public String createReminder(int penceDividend, int divisor) {
        int reminder = penceDividend % divisor;
        int shillingReminder = reminder / ConstantUtil.PENCE_IN_SHILLING;
        int penceReminder = reminder - (shillingReminder * ConstantUtil.PENCE_IN_SHILLING);

        StringBuilder stringReminder = new StringBuilder();
        if (shillingReminder > 0) {
            super.appendData(stringReminder, shillingReminder, PriceType.SHILLING);
        }
        if (penceReminder > 0) {
            stringReminder.append(penceReminder)
                    .append(PriceType.PENCE.getValue());
        }

        return stringReminder.toString();
    }

}
