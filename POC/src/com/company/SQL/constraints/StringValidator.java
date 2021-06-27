package com.company.SQL.constraints;

import com.company.SQL.domain.Row;

public class StringValidator implements TypeValidator{
    @Override
    public String type() {
        return "STRING";
    }

    @Override
    public boolean validate(String data) {
        return  data.length() <= 20 ;
    }
}
