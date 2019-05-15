package com.github.warmriver.loose;

import com.github.warmriver.operation.StringOperation;

/**
 * @author <wangwentian0@hotmail.com>
 * Created on 2019-05-15
 */
public class NonStrictSqlImpl implements NonStrictQueryBuilder{
    private StringBuilder sql;
    private StringOperation operation;

    public NonStrictSqlImpl(StringBuilder sql, StringOperation operation){
        this.sql = sql;
        this.operation = operation;
    }


    @Override
    public NonStrictQueryBuilder and(String condition) {
        operation.and(sql, condition);
        return this;
    }

    @Override
    public NonStrictQueryBuilder where(String condition) {
        operation.where(sql, condition);
        return this;
    }

    @Override
    public NonStrictQueryBuilder having(String...conditions) {
        operation.having(sql, conditions);
        return this;
    }

    @Override
    public NonStrictQueryBuilder leftOuterJoin(String table) {
        operation.leftOuterJoin(sql, table);
        return this;
    }

    @Override
    public NonStrictQueryBuilder rightOuterJoin(String table) {
        operation.rightOuterJoin(sql, table);
        return this;
    }

    @Override
    public NonStrictQueryBuilder innerJoin(String table) {
       operation.innerJoin(sql, table);
        return this;
    }

    @Override
    public NonStrictQueryBuilder limit(int offset, int limit) {
        operation.limit(sql, offset, limit);
        return this;
    }

    @Override
    public NonStrictQueryBuilder limit(int limit) {
        operation.limit(sql, limit);
        return this;
    }

    @Override
    public NonStrictQueryBuilder orderBy(String...fields) {
        operation.orderBy(sql, fields);
        return this;
    }

    @Override
    public NonStrictQueryBuilder on(String...conditions) {
        operation.on(sql, conditions);
        return this;
    }

    @Override
    public NonStrictQueryBuilder from(String... tables) {
        operation.from(sql, tables);
        return this;
    }

    @Override
    public NonStrictQueryBuilder select(String...fields) {
       operation.select(sql, fields);
        return this;
    }

    @Override
    public NonStrictQueryBuilder groupBy(String...fields) {
       operation.groupBy(sql, fields);
        return this;
    }

    @Override
    public String buildSql() {
        return operation.buildSql(sql);
    }

    @Override
    public String buildSqlWithBracket() {
        return operation.buildSqlWithBracket(sql);
    }
}
