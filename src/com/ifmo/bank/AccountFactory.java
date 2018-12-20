package com.ifmo.bank;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class AccountFactory {
    @NotNull
    private final PercentageCalculator percentageCalculator;
    private final float fixedPercentage;
    private final float commission;

    public AccountFactory(@NotNull PercentageCalculator percentageCalculator, float fixedPercentage, float commission) {
        this.percentageCalculator = percentageCalculator;
        this.fixedPercentage = fixedPercentage;
        this.commission = commission;
    }

    @NotNull
    public Account create(@NotNull Client client, float amount) {
        return checkForDoubtful(new SimpleAccount(client, amount, fixedPercentage));
    }

    @NotNull
    public Account createByLimit(@NotNull Client client, float amount, float limit) {
        return checkForDoubtful(new CreditAccount(client, amount, limit, commission));
    }

    @NotNull
    public Account createByLimitDate(@NotNull Client client, float amount, @NotNull Date date) {
        Date current = new Date();
        if (date.before(current)) {
            throw new IllegalArgumentException("Limit date should not be before current time");
        }
        return checkForDoubtful(new DepositAccount(client, amount, date, percentageCalculator.getPercentage(amount)));
    }

    @NotNull
    private Account checkForDoubtful(@NotNull Account account) {
        if (account.getClient().isDoubtful()) {
            return new DoubtfulAccount(account);
        }
        return account;
    }
}
