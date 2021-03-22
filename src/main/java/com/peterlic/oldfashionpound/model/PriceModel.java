package com.peterlic.oldfashionpound.model;


import org.apache.commons.lang3.StringUtils;

public class PriceModel {

    private int pounds;

    private int shillings;

    private int pence;

    public PriceModel(String number) {
        createObjectFromString(number);
    }

    public int getPounds() {
        return pounds;
    }

    public void setPounds(int pounds) {
        this.pounds = pounds;
    }

    public int getShillings() {
        return shillings;
    }

    public void setShillings(int shillings) {
        this.shillings = shillings;
    }

    public int getPence() {
        return pence;
    }

    public void setPence(int pence) {
        this.pence = pence;
    }

    private void createObjectFromString(String number) {
        createPound(number);
        createShilling(number);
        createPence(number);
    }

    private void createPound(String number) {
        if (StringUtils.contains(number, PriceType.POUND.getValue())) {
            this.setPounds(Integer.parseInt(StringUtils.substringBefore(number, PriceType.POUND.getValue())));
        }
    }

    private void createShilling(String number) {
        if (StringUtils.contains(number, PriceType.SHILLING.getValue())) {
            String shillingValue = StringUtils.contains(number, PriceType.POUND.getValue()) ?
                    StringUtils.substringBetween(number, PriceType.POUND.getValue(), PriceType.SHILLING.getValue()) : StringUtils.substringBefore(number, PriceType.SHILLING.getValue());

            if (StringUtils.isNotBlank(shillingValue)) {
                this.setShillings(Integer.parseInt(shillingValue.trim()));
            }
        }
    }

    private void createPence(String number) {
        if (StringUtils.contains(number, PriceType.PENCE.getValue())) {

            String penceValue;
            if (StringUtils.contains(number, PriceType.SHILLING.getValue())) {
                penceValue = StringUtils.substringBetween(number, PriceType.SHILLING.getValue(), PriceType.PENCE.getValue());
            } else if (StringUtils.contains(number, PriceType.POUND.getValue())) {
                penceValue = StringUtils.substringBetween(number, PriceType.POUND.getValue(), PriceType.PENCE.getValue());
            } else {
                penceValue = StringUtils.substringBefore(number, PriceType.PENCE.getValue());
            }

            if (StringUtils.isNotBlank(penceValue)) {
                this.setPence(Integer.parseInt(penceValue.trim()));
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PriceModel{");
        sb.append("pounds=").append(pounds);
        sb.append(", shillings=").append(shillings);
        sb.append(", pence=").append(pence);
        sb.append('}');
        return sb.toString();
    }
}
