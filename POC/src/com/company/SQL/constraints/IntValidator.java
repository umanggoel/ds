package com.company.SQL.constraints;

import com.company.SQL.domain.Row;

public class IntValidator implements TypeValidator{


    @Override
    public String type() {
        return "INT";
    }

    @Override
    public boolean validate(String row) {
        try {
            int  value =Integer.parseInt(row);
            if(value > 1024 || value < -1024) return false;
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}
