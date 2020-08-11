package com.company.design.fluentBuilder;

public class Employee {

    protected String name;
    protected String id;
    protected Address address;
    protected Company companyInfo;

    protected Employee(){

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public Company getCompanyInfo() {
        return companyInfo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", address=" + address +
                ", companyInfo=" + companyInfo +
                '}';
    }

}
