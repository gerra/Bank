package com.ifmo.bank;

import org.jetbrains.annotations.NotNull;

public class DoubtfulAccount implements Account {
    @NotNull
    private final Account originalAccount;

    public DoubtfulAccount(@NotNull Account originalAccount) {
        this.originalAccount = originalAccount;
    }

    @Override
    public @NotNull Client getClient() {
        return originalAccount.getClient();
    }

    @Override
    public void deposit(float amount) throws Errors.OperationException {
        requireAccount().deposit(amount);
    }

    @Override
    public void withdraw(float amount) throws Errors.OperationException {
        requireAccount().withdraw(amount);
    }

    @Override
    public void transfer(@NotNull AbstractAccount destination, float amount) throws Errors.OperationException {
        requireAccount().transfer(destination, amount);
    }

    @NotNull
    private Account requireAccount() throws Errors.OperationException {
        if (getClient().isDoubtful()) {
            throw new Errors.OperationException("Account is doubtful");
        }
        return originalAccount;
    }
}
