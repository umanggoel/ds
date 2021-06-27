package com.company.SQL.constraints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CostraintsResolver {
    Map<String , Constraints> constraintsMap;

    public CostraintsResolver(){
        List<Constraints> constraintsList = new ArrayList<>();
        constraintsList.add(new MandatoryConstraints());
        constraintsMap = new HashMap<>();
        for(Constraints c: constraintsList) {
            constraintsMap.put(c.type(), c);
        }
    }

   public Constraints resolveConstraint(String type) {
        return constraintsMap.get(type);
    }
}
