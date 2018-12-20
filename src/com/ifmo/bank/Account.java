package com.ifmo.bank;

import org.jetbrains.annotations.NotNull;

public interface Account {
    @NotNull
    Client getClient();
    void deposit(float amount) throws Errors.OperationException;
    void withdraw(float amount) throws Errors.OperationException;

    void transfer(@NotNull AbstractAccount destination, float amount) throws Errors.OperationException;
}
