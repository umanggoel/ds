package com.company.SQL.domain;

import com.company.SQL.constraints.Constraints;
import com.company.SQL.constraints.TypeValidatorresolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Table {

    Map<String, ColumnMetadata > columns;
    List<Row> rows;
    TypeValidatorresolver typeValidatorresolver;

    public Table() {
        columns = new HashMap<>();
        rows = new ArrayList<>();
        typeValidatorresolver = new TypeValidatorresolver();
    }

    boolean insertRow(Row row) {
        for(Entry e : row.rowdata.entrySet()) {
            ColumnMetadata metadata = columns.get(e.getKey());
            for(Constraints con : metadata.constraintsList) {
                if(!con.validate((String)e.getValue())) return false;
            }
            if(!typeValidatorresolver.resolve(metadata.type).validate((String)e.getValue())) return false;

        }

        this.rows.add(row);
        return true;
    }

    List<Row> filteredRows(Map<String, String> filters) {

        List<Row> result = new ArrayList<>();
        for(Row r: rows) {
            boolean ismatch = true;
            for(Entry e: filters.entrySet()) {
                String columnData = r.rowdata.get(e.getKey());
                if(r.rowdata.get(e.getKey()) == null || !columnData.equals(e.getValue())) {
                    ismatch = false;
                    break;
                }
            }

            if(ismatch) result.add(r);
        }

        return result;
    }

}
