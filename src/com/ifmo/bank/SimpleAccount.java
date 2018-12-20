package com.ifmo.bank;

import org.jetbrains.annotations.NotNull;

public class SimpleAccount extends AbstractAccount {
    private final float fixedPercentage;

    public SimpleAccount(@NotNull Client client, float amount, float fixedPercentage) {
        super(client, amount);
        this.fixedPercentage = fixedPercentage;
    }

    @Override
    public void deposit(float amount) {
        this.amount += amount;
    }

    @Override
    public void withdraw(float amount) throws Errors.WithdrawException {
        float newAmount = this.amount - amount;
        if (newAmount < 0) {
            throw new Errors.WithdrawException("There is no enough money");
        }
        this.amount = newAmount;
    }
}
