package com.peterlic.oldfashionpound.operation;

import com.peterlic.oldfashionpound.model.PriceModel;
import com.peterlic.oldfashionpound.model.PriceType;
import com.peterlic.oldfashionpound.util.ConstantUtil;

/**
 * Class that represents abstract operation.
 *
 * @param <T> - first number used in operation
 * @param <D> - second number used in operation
 * @author Ana Peterlić
 */
public abstract class AbstractOperation<T, D> {

    /**
     * Abstract method used for executing specific operation.
     */
    protected abstract String process(T firstNumber, D secondNumber);

    /**
     * Converts given price in pence.
     *
     * @param number price
     * @return price converted in pence
     */
    protected int convertToPence(PriceModel number) {
        return (number.getPounds() * ConstantUtil.PENCE_IN_POUND) + (number.getShillings() * ConstantUtil.PENCE_IN_SHILLING) + number.getPence();
    }

    /**
     * Returns price created from pence.
     *
     * @param resultInPence
     * @return
     */
    public String createResult(int resultInPence) {
        int pounds = resultInPence / ConstantUtil.PENCE_IN_POUND;
        int shillings = (resultInPence - (pounds * ConstantUtil.PENCE_IN_POUND)) / ConstantUtil.PENCE_IN_SHILLING;
        int pence = (resultInPence - (pounds * ConstantUtil.PENCE_IN_POUND)) - (shillings * ConstantUtil.PENCE_IN_SHILLING);
        return createStringFromResult(pounds, shillings, pence);
    }

    /**
     * Returns string created from price.
     *
     * @param pounds    pounds value
     * @param shillings shillings value
     * @param pence     pence value
     * @return
     */
    private String createStringFromResult(int pounds, int shillings, int pence) {
        StringBuilder sb = new StringBuilder();
        appendData(sb, pounds, PriceType.POUND);
        appendData(sb, shillings, PriceType.SHILLING);
        appendData(sb, pence, PriceType.PENCE);
        return sb.toString();
    }

    void appendData(StringBuilder sb, int number, PriceType priceType) {
        sb.append(number)
                .append(priceType.getValue());

        if (!PriceType.PENCE.equals(priceType)) {
            sb.append(" ");
        }
    }
}
