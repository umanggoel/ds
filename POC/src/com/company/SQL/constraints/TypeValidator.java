package com.company.SQL.constraints;

public interface TypeValidator {
    String type();
    boolean validate(String string);
}
