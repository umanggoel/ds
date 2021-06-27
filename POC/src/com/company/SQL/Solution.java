package com.company.SQL;

import com.company.SQL.constraints.CostraintsResolver;
import com.company.SQL.domain.ColumnMetadata;
import com.company.SQL.domain.Row;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        CollectionManager collectionManager = new CollectionManager();
        CostraintsResolver costraintsResolver = new CostraintsResolver();
        Map<String, ColumnMetadata> columnMetadataMap = new HashMap<>();
        ColumnMetadata col1 = new ColumnMetadata();
        col1.type = "STRING";
        col1.name = "NAME";
        col1.constraintsList.add(costraintsResolver.resolveConstraint("MANDATORY"));

        ColumnMetadata col2 = new ColumnMetadata();
        col2.type = "INT";
        col2.name = "AGE";

        columnMetadataMap.put("NAME", col1);
        columnMetadataMap.put("AGE", col2);

        collectionManager.createTable("Demo",columnMetadataMap);
        Row r = new Row();
        r.addentry("NAME", "UMANG");
        r.addentry("AGE", "1023");

        collectionManager.insertRow(r,"Demo");
        collectionManager.printRecords("Demo");
    }
}
