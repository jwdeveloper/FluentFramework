package io.github.jwdeveloper.ff.extension.database.api;
import io.github.jwdeveloper.ff.extension.database.api.database_table.DbTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDbContext
{
    public List<DbTable<?>> tables = new ArrayList<>();
    private Connection connection;

    public void setConnection(Connection connection)
    {
        this.connection = connection;
        for (var table: tables)
        {
            table.setConnection(connection);
        }
    }

    public void saveChanges() throws SQLException
    {
        for (var table: tables)
        {
         table.saveChanges();
        }
    }
}
