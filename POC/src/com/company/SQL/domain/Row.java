package com.company.SQL.domain;

import java.util.HashMap;
import java.util.Map;

public class Row {
    public Map<String, String> rowdata = new HashMap<>();

    public void addentry(String name, String value) {
        if(rowdata.get(name) != null) return;
        rowdata.put(name, value);
    }

    @Override
    public String toString() {

        StringBuilder b = new StringBuilder();
        for(Map.Entry e: rowdata.entrySet()) {
            b.append("     ");
            b.append(e.getKey());
            b.append(":");
            b.append(e.getValue());
        }
        return "Row{"
                 + b.toString() +
                '}';
    }
}
