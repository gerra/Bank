package com.ifmo.bank;

public final class Errors {
    private Errors() {
        // no instance
    }

    public static class OperationException extends Exception {
        public OperationException(String message) {
            super(message);
        }
    }

    public static class WithdrawException extends OperationException {
        public WithdrawException(String message) {
            super(message);
        }
    }
}
