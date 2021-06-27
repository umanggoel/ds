package com.company.SQL.domain;

import com.company.SQL.constraints.Constraints;

import java.util.ArrayList;
import java.util.List;

public class ColumnMetadata {

    public String name;
    public String type;
    public List<Constraints> constraintsList = new ArrayList<>();
}
