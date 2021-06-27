package com.company.SQL.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collection {

    public Map<String, Table> tables = new HashMap<>();

    public boolean createTable(String name, Map<String, ColumnMetadata> columns){
        if(tables.get(name) != null) return false;
        Table t = new Table();
        t.columns = columns;
        tables.put(name, t);
        return true;
    }

    public boolean insertRow(Row row, String name) {
        if(tables.get(name) == null) return false;
        return tables.get(name).insertRow(row);
    }

    public boolean deleteTable(String name) {
        if(tables.get(name) == null) return false;
        tables.remove(name);
        return true;
    }

    public void printRecords(String name) {
        if(tables.get(name) == null) return;
        for(Row r: tables.get(name).rows) {
            System.out.println(r);
        }
    }

    public List<Row> filtering(Map<String, String> filters, String name) {
        if(tables.get(name) == null) return null;
        return tables.get(name).filteredRows(filters);
    }

}
