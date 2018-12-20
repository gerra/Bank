package com.ifmo.bank;

public class PercentageCalculatorImpl implements PercentageCalculator {
    private static final float MIN_PERCENTAGE = 1f;
    private static final float MIN_AMOUNT_FOR_3_5_PERCENTAGE = 10_000;
    private static final float MIN_AMOUNT_FOR_5_PERCENTAGE = 50_000;
    private static final float MIN_AMOUNT_FOR_7_5_PERCENTAGE = 100_000;
    private static final float MIN_AMOUNT_FOR_10_PERCENTAGE = 500_000;

    @Override
    public float getPercentage(float amount) {
        if (amount >= MIN_AMOUNT_FOR_10_PERCENTAGE) {
            return 10f;
        } else if (amount >= MIN_AMOUNT_FOR_7_5_PERCENTAGE) {
            return 7.5f;
        } else if (amount >= MIN_AMOUNT_FOR_5_PERCENTAGE) {
            return 5f;
        } else if (amount >= MIN_AMOUNT_FOR_3_5_PERCENTAGE) {
            return 3.5f;
        } else {
            return MIN_PERCENTAGE;
        }
    }
}
