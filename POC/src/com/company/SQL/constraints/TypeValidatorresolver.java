package com.company.SQL.constraints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeValidatorresolver {
    Map<String , TypeValidator> constraintsMap =new HashMap();

    public TypeValidatorresolver(){
        List<TypeValidator> constraintsList = new ArrayList<>();
        constraintsList.add(new IntValidator());
        constraintsList.add(new StringValidator());
        for(TypeValidator c: constraintsList) {
            constraintsMap.put(c.type(), c);
        }
    }

    public TypeValidator resolve(String type) {
        return constraintsMap.get(type);
    }
}
