package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import com.peterlic.oldfashionpound.model.PriceType;
import com.peterlic.oldfashionpound.util.ConstantUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Class that contains logic for division operation.
 *
 * @author Ana Peterlić
 */
@Component
public class DivisionOperation extends AbstractOperation<PriceModel, Integer> {

    @Override
    public String process(PriceModel dividend, Integer divisor) {
        int penceDividend = convertToPence(dividend);

        String result = createResult(penceDividend / divisor);
        String reminder = createReminder(penceDividend, divisor);
        if (StringUtils.isNotBlank(reminder)) {
            result += " (" + reminder + ")";

        }
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

        StringBuilder sb = new StringBuilder();
        if (shillingReminder > 0) {
            super.appendData(sb, shillingReminder, PriceType.SHILLING);
        }
        if (penceReminder > 0) {
            sb.append(penceReminder)
                    .append(PriceType.PENCE.getValue());
        }

        return sb.toString();
    }

}
