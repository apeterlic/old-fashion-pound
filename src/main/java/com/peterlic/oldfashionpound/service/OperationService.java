package com.peterlic.oldfashionpound.service;

import com.peterlic.oldfashionpound.model.PriceModel;
import com.peterlic.oldfashionpound.operation.AdditionOperation;
import com.peterlic.oldfashionpound.operation.DivisionOperation;
import com.peterlic.oldfashionpound.operation.MultiplicationOperation;
import com.peterlic.oldfashionpound.operation.SubtractionOperation;
import com.peterlic.oldfashionpound.util.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Class that represents operation service. Method inside this class should be called in another application.
 *
 * @author Ana Peterlić
 */
@Service
public class OperationService {

    private final AdditionOperation additionOperation;
    private final SubtractionOperation subtractionOperation;
    private final MultiplicationOperation multiplicationOperation;
    private final DivisionOperation divisionOperation;

    public OperationService(AdditionOperation additionOperation, SubtractionOperation subtractionOperation, MultiplicationOperation multiplicationOperation, DivisionOperation divisionOperation) {
        this.additionOperation = ValidatorUtil.notNull(additionOperation, "Sum operation");
        this.subtractionOperation = ValidatorUtil.notNull(subtractionOperation, "Substrate operation");
        this.multiplicationOperation = ValidatorUtil.notNull(multiplicationOperation, "Multiply operation");
        this.divisionOperation = ValidatorUtil.notNull(divisionOperation, "Divide operation");
    }

    /**
     * Method that adds two prices.
     * Example: 5p 17s 8d + 3p 4s 10d= 9p 2s 6d
     *
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    public String add(String firstNumber, String secondNumber) {
        ValidatorUtil.validateRequest(StringUtils.isAnyBlank(firstNumber, secondNumber));
        return additionOperation.process(new PriceModel(firstNumber), new PriceModel(secondNumber));
    }

    /**
     * Method that substrate two prices.
     * Example: 5p 17s 8d - 3p 4s 10d= 2p 12s 10d
     *
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    public String substrate(String firstNumber, String secondNumber) {
        ValidatorUtil.validateRequest(StringUtils.isAnyBlank(firstNumber, secondNumber));
        return subtractionOperation.process(new PriceModel(firstNumber), new PriceModel(secondNumber));
    }

    /**
     * Method that multiply price by an integer value.
     * Example: 5p 17s 8d * 2= 11p 15s 4d
     *
     * @param firstFactor
     * @param secondFactor
     * @return
     */
    public String multiply(String firstFactor, Integer secondFactor) {
        ValidatorUtil.validateRequest(StringUtils.isBlank(firstFactor) || secondFactor == null);
        return multiplicationOperation.process(new PriceModel(firstFactor), secondFactor);
    }

    /**
     * Method that divide price by an integer value.
     * Example: 5p 17s 8d / 3 = 1p 19s 2d (2d)
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public String divide(String dividend, Integer divisor) {
        ValidatorUtil.validateRequest(StringUtils.isBlank(dividend) || divisor == null);
        ValidatorUtil.validateDivisor(divisor);
        return divisionOperation.process(new PriceModel(dividend), divisor);
    }

}
