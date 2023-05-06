package io.github.jwdeveloper.ff.extension.mysql.implementation.factories;

import io.github.jwdeveloper.ff.extension.mysql.api.annotations.*;
import io.github.jwdeveloper.ff.extension.mysql.implementation.models.ColumnModel;
import io.github.jwdeveloper.ff.extension.mysql.implementation.models.TableModel;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Optional;

public class TableModelFactory {
    private final HashMap<Class<?>, TableModel> cachedTableModes = new HashMap<>();

    public TableModel createTableModel(Class<?> clazz) {
        if (clazz == null)
            return null;

        if (cachedTableModes.containsKey(clazz)) {
            return cachedTableModes.get(clazz);
        }

        var result = new TableModel();
        result.setName(getTableName(clazz));
        result.setClazz(clazz);

        for (var field : clazz.getDeclaredFields()) {
            var columnResult = getColumn(field);
            if (columnResult.isEmpty())
                continue;

            var column = columnResult.get();
            if (column.isKey()) {
                result.setPrimaryKeyColumn(column);
            }

            result.getColumnList().add(column);
        }

        cachedTableModes.put(clazz, result);
        return result;
    }


    private String getTableName(Class<?> clazz) {
        var isAnnotation = clazz.isAnnotationPresent(Table.class);
        if (!isAnnotation) {
            return clazz.getSimpleName();
        }
        var annotation = clazz.getAnnotation(Table.class);
        if (annotation.name().isEmpty()) {
            return clazz.getSimpleName();
        }
        return annotation.name();
    }

    private Optional<ColumnModel> getColumn(Field field) {
        var isColumn = false;
        var result = new ColumnModel();
        for (var annotation : field.getAnnotations()) {

            if (annotation instanceof Column column) {
                isColumn = true;

                if (column.name().isEmpty())
                    result.setName(field.getName());
                else
                    result.setName(column.name());

                result.setField(field);
                result.setType(column.type());
                result.setSize(column.size());
                continue;
            }
            if (annotation instanceof Required) {

                result.setRequired(true);
                continue;
            }

            if (annotation instanceof Key key) {
                result.setKey(true);
                result.setPrimaryKey(key.isPrimary());
                result.setAutoIncrement(key.autoIncrement());
                continue;
            }

            if (annotation instanceof ForeignKey key) {
                isColumn = true;
                var table = createTableModel(field.getType());
                result.setForeignKeyTableName(table.getName());
                result.setForeignKey(true);
                result.setForeignKeyReference(key.referencedColumnName());
                result.setForeignKeyName(key.columnName());
                result.setField(field);
                result.setOnUpdate(key.onUpdate());
                result.setOnDelete(key.onDelete());
                result.setType(field.getType().getSimpleName());
            }
        }

        if (!isColumn) {
            return Optional.empty();
        }

        return Optional.of(result);
    }
}
