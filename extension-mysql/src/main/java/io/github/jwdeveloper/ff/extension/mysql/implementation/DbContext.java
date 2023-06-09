package io.github.jwdeveloper.ff.extension.mysql.implementation;

import java.util.ArrayList;
import java.util.List;

public abstract class DbContext {
    final List<SqlTable<?>> tables = new ArrayList<>();

    void addTable(SqlTable<?> table) {
        tables.add(table);
    }


    public void saveChanges() throws Exception {
        for (var table : tables) {
            table.saveChanges();
        }
    }


}
