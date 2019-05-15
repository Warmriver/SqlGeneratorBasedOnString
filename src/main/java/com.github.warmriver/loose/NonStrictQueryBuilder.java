package com.github.warmriver.loose;

/**
 * @author <wangwentian0@hotmail.com>
 * Created on 2019-05-15
 */
public interface NonStrictQueryBuilder {
    NonStrictQueryBuilder and(String condition);
    NonStrictQueryBuilder limit(int offset, int limit);
    NonStrictQueryBuilder limit(int limit);
    NonStrictQueryBuilder orderBy(String...fields);
    NonStrictQueryBuilder having(String...conditions);
    NonStrictQueryBuilder groupBy(String...fields);

    NonStrictQueryBuilder where(String condition);
    NonStrictQueryBuilder leftOuterJoin(String table);
    NonStrictQueryBuilder rightOuterJoin(String table);
    NonStrictQueryBuilder innerJoin(String table);
    NonStrictQueryBuilder on(String...conditions);
    NonStrictQueryBuilder from(String...table);
    NonStrictQueryBuilder select(String...fields);

    String buildSql();
    String buildSqlWithBracket();
}
