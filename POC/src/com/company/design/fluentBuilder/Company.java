package com.company.design.fluentBuilder;

public class Company {
    String name;

    private Company(Builder builder) {
        this.name = builder.name;
    }

    public static Builder newCompany() {
        return new Builder();
    }


    public static final class Builder {
        private String name;

        private Builder() {
        }

        public Company build() {
            return new Company(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
