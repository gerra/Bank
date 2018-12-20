package com.ifmo.bank;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class DepositAccount extends AbstractAccount {
    @NotNull
    private final Date date;
    private final float fixedPercentage;

    public DepositAccount(@NotNull Client client, float amount, @NotNull Date date, float fixedPercentage) {
        super(client, amount);
        this.date = date;
        this.fixedPercentage = fixedPercentage;
    }

    @Override
    public void deposit(float amount) {
        this.amount += amount;
    }

    @Override
    public void withdraw(float amount) throws Errors.WithdrawException {
        if (date.after(new Date())) {
            throw new Errors.WithdrawException("Deposit date is in future");
        }
        this.amount -= amount;
    }
}
