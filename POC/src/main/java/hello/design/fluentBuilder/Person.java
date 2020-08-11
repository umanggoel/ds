package com.company.design.fluentBuilder;

public class Person {

    private String name;
    private String position;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.position = builder.position;
    }

    public static PersonBuilder newPerson() {
        return new PersonBuilder();
    }

    public static EmploymentBuilder employmentBuilder() {
        return new EmploymentBuilder();
    }

    public static class PersonBuilder <T extends PersonBuilder<T>>{
        private String name;
        String position;

        private PersonBuilder() {
        }

        public Person build() {
            return new Person(this);
        }

        public PersonBuilder name(String name) {
            this.name = name;
            return self();
        }

        protected T self(){
            return (T)this;
        }
    }

    public static class EmploymentBuilder extends PersonBuilder<EmploymentBuilder> {

        public EmploymentBuilder() {
        }

        public Person build() {
            return new Person(this);
        }

        public EmploymentBuilder positon(String position) {
            this.position = position;
            return this;
        }

        @Override
        protected EmploymentBuilder self() {
            return this;
        }
    }
}
