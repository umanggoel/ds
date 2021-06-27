package com.company.SQL.constraints;

import com.company.SQL.domain.Row;

public interface Constraints {

    String type();
    boolean validate(String columndata);
}
