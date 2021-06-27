package com.company.SQL;

import com.company.SQL.domain.Collection;
import com.company.SQL.domain.ColumnMetadata;
import com.company.SQL.domain.Row;

import java.util.List;
import java.util.Map;

public class CollectionManager {

    Collection collection = new Collection();

    boolean createTable(String name, Map<String, ColumnMetadata> columns){
        if(collection.tables.get(name) != null) return false;
        return collection.createTable(name, columns);
    }

    boolean insertRow(Row row, String name) {
        if(collection.tables.get(name) == null) return false;
        return collection.insertRow(row, name);
    }

    boolean deleteTable(String name) {
        if(collection.tables.get(name) == null) return false;
        return collection.deleteTable(name);
    }

    void printRecords(String name) {
        if(collection.tables.get(name) == null) return;
        collection.printRecords(name);
    }

    List<Row> filtering(Map<String, String> filters, String name) {
        if(collection.tables.get(name) == null) return null;
        return collection.filtering(filters, name);
    }
}
