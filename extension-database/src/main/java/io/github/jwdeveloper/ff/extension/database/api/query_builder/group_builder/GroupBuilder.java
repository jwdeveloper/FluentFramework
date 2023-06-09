package io.github.jwdeveloper.ff.extension.database.api.query_builder.group_builder;

import io.github.jwdeveloper.ff.extension.database.api.query_abstract.AbstractQuery;
import io.github.jwdeveloper.ff.extension.database.api.query_builder.order_builder.OrderBuilder;
import io.github.jwdeveloper.ff.extension.database.api.query_builder.where_builders.WhereBuilder;

public interface GroupBuilder extends AbstractQuery
{
     GroupBuilder groupBy();

     GroupBuilder column(String table);

     WhereBuilder having();

     OrderBuilder orderBy();
}
