package com.ifmo.bank;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractAccount implements Account {
    @NotNull
    private final Client client;
    protected float amount;

    public AbstractAccount(@NotNull Client client, float amount) {
        this.client = client;
        this.amount = amount;
    }

    @Override
    public @NotNull Client getClient() {
        return client;
    }

    public void transfer(@NotNull AbstractAccount destination, float amount) throws Errors.OperationException {
        if (client.equals(destination.client)) {
            transferWithoutCheck(destination, amount);
        } else {
            throw new IllegalArgumentException("Destination account should be belong to the same client");
        }
    }

    protected void transferWithoutCheck(@NotNull AbstractAccount destination, float amount) throws Errors.OperationException {
        withdraw(amount);
        destination.deposit(amount);
    }
}
