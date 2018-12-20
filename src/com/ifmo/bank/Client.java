package com.ifmo.bank;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Client {
    @NotNull
    public final String firstName;
    @NotNull
    public final String lastName;
    @Nullable
    public final String address;
    @Nullable
    public final String passportNumber;

    private Client(@NotNull String firstName, @NotNull String lastName, @Nullable String address, @Nullable String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.passportNumber = passportNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Client)) {
            return false;
        }

        Client other = (Client) obj;
        return Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(address, other.address)
                && Objects.equals(passportNumber, other.passportNumber);
    }

    public boolean isDoubtful() {
        return address == null || passportNumber == null;
    }

    public static class Builder {
        @NotNull
        private final String firstName;
        @NotNull
        private final String lastName;
        @Nullable
        private String address;
        @Nullable
        private String passportNumber;

        public Builder(@NotNull String firstName, @NotNull String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @NotNull
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        @NotNull
        public Builder setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }

        @NotNull
        public Client create() {
            return new Client(firstName, lastName, address, passportNumber);
        }
    }
}
