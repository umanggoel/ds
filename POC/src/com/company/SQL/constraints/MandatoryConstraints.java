package com.company.SQL.constraints;

import com.company.SQL.domain.Row;

public class MandatoryConstraints implements Constraints {

    @Override
    public String type() {
        return "MANDATORY";
    }

    @Override
    public boolean validate(String data) {
        return data != null;
    }
}
