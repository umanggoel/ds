package com.company.design.fluentBuilder;

public class EmployeeBuilder {

    protected Employee e = new Employee();

    EmployeeBuilder name(String name) {
        e.name = name;
        return this;
    }

    EmployeeBuilder id(String id) {
        e.id = id;
        return this;
    }

    EmployeeBuilder address(Address address){
        e.address = address;
        return this;
    }

    EmployeeBuilder company(Company company) {
        e.companyInfo = company;
        return this;
    }

    Employee build(){
        return e;
    }
}
