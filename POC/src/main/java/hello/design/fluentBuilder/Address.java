package com.company.design.fluentBuilder;

public class Address {

    String street;

    private Address(Builder builder) {
        this.street = builder.street;
    }

    public static Builder newAddress() {
        return new Builder();
    }


    public static final class Builder {
        private String street;

        private Builder() {
        }

        public Address build() {
            return new Address(this);
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                '}';
    }
}
