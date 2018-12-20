package com.ifmo.bank;

import org.jetbrains.annotations.NotNull;

public class CreditAccount extends AbstractAccount {
    private final float credit;
    private final float commission;

    public CreditAccount(@NotNull Client client, float amount, float credit, float commission) {
        super(client, amount);
        this.credit = credit;
        this.commission = commission;
    }

    @Override
    public void deposit(float amount) {
        this.amount += amount - calculateCommission(amount);
    }

    @Override
    public void withdraw(float amount) throws Errors.WithdrawException {
        float newAmount = this.amount - amount - calculateCommission(amount);
        if (newAmount < -credit) {
            throw new Errors.WithdrawException("Credit is too little");
        }
        this.amount = newAmount;
    }

    private float calculateCommission(float operationAmount) {
        if (amount < 0) {
            return operationAmount * commission / 100f;
        }
        return 0;
    }
}
