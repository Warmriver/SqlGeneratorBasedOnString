package com.github.warmriver.strictsteps;

import com.github.warmriver.operation.StringOperation;

/**
 * @author <wangwentian0@hotmail.com>
 * Created on 2019-05-15
 */
public class SqlImpl implements OnStep, SelectFromStep, MultiFuncStep, WhereStep, LimitStep, SqlQuery, OrderByStep, HavingOrderStep, AndStep {

    private StringBuilder sql;
    private StringOperation operation;

    public SqlImpl(StringBuilder sql, StringOperation stringOperation) {
        this.sql = sql;
        this.operation = stringOperation;
    }

    @Override
    public AndStep and(String condition) {
        operation.and(sql, condition);
        return this;
    }
//
//    @Override
//    public AndStep where(String condition) {
//        sql.append("where ");
//        sql.append(condition);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public OrderByStep having(String condition) {
//        sql.append("having ");
//        sql.append(condition);
//        this.addBlank();
//        return null;
//    }
//
//    @Override
//    public OrderByStep having(String...conditions) {
//        sql.append("having ");
//        for(int i = 0; i < conditions.length; i++) {
//            sql.append(conditions[i]);
//            if(i == conditions.length - 1) break;
//            sql.append("and ");
//        }
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public OnStep leftOuterJoin(String table) {
//        sql.append("left outer join ");
//        sql.append(table);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public OnStep rightOuterJoin(String table) {
//        sql.append("right outer join ");
//        sql.append(table);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public OnStep innerJoin(String table) {
//        sql.append("inner join ");
//        sql.append(table);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public SqlQuery limit(int offset, int limit) {
//        sql.append("limit ");
//        sql.append(offset);
//        sql.append(",");
//        sql.append(limit);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public SqlQuery limit(int limit) {
//        sql.append("limit ");
//        sql.append(limit);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public HavingOrderStep groupBy(String condition) {
//        sql.append("having ");
//        sql.append(condition);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public LimitStep orderBy(String...fields) {
//        sql.append("order by ");
//        for(int i = 0; i < fields.length; i++) {
//            sql.append(fields[i]);
//            if(i == fields.length - 1) break;
//            sql.append(",");
//        }
//        this.addBlank();
//        return null;
//    }
//
//    @Override
//    public LimitStep orderBy(String field) {
//        sql.append("order by ");
//        sql.append(field);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public WhereStep on(String...conditions) {
//        sql.append("on ");
//        for(int i = 0; i < conditions.length; i++) {
//            sql.append(conditions[i]);
//            if(i == conditions.length - 1) break;
//            sql.append("and ");
//        }
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public WhereStep on(String condition) {
//        sql.append("on ");
//        sql.append(condition);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public WhereStep from(String... tables) {
//        sql.append("from ");
//        for(int i = 0; i < tables.length; i++) {
//            sql.append(tables[i]);
//            if(i != tables.length - 1) {
//                sql.append(",");
//            }
//        }
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public MultiFuncStep from(String table) {
//        sql.append("from ");
//        sql.append(table);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public SelectFromStep select(String...fields) {
//        sql.append("select ");
//        for(int i = 0; i < fields.length; i++) {
//            sql.append(fields[i]);
//            if(i != fields.length - 1) {
//                sql.append(",");
//            }
//        }
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public SelectFromStep select(String field) {
//        sql.append("select ");
//        sql.append(field);
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public HavingOrderStep groupBy(String...fields) {
//        sql.append("group by ");
//        for(int i = 0; i < fields.length; i++) {
//            sql.append(fields[i]);
//            if(i != fields.length - 1) {
//                sql.append(",");
//            }
//        }
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public String buildSql() {
//        return sql.toString();
//    }
//
//    @Override
//    public String buildSqlWithBracket() {
//        sql.insert(0, "(");
//        sql.append(")");
//        this.addBlank();
//        return this.buildSql();
//    }

//    @Override
//    public SqlImpl insertSql(String subSql) {
//        sql.append("(");
//        sql.append(subSql);
//        sql.append(")");
//        this.addBlank();
//        return this;
//    }
//
//    @Override
//    public SqlImpl insertSqlAsAlias(String subSql, String alias) {
//        sql.append("(");
//        sql.append(subSql);
//        sql.append(")");
//        sql.append("as ");
//        sql.append(alias);
//        this.addBlank();
//        return this;
//    }

    @Override
    public AndStep where(String condition) {
       operation.where(sql, condition);
        return this;
    }

    @Override
    public OrderByStep having(String...conditions) {
        operation.having(sql, conditions);
        return this;
    }

    @Override
    public OnStep leftOuterJoin(String table) {
        operation.leftOuterJoin(sql, table);
        return this;
    }

    @Override
    public OnStep rightOuterJoin(String table) {
        operation.leftOuterJoin(sql, table);
        return this;
    }

    @Override
    public OnStep innerJoin(String table) {
        operation.innerJoin(sql, table);
        return this;
    }

    @Override
    public SqlQuery limit(int offset, int limit) {
        operation.limit(sql, offset, limit);
        return this;
    }

    @Override
    public SqlQuery limit(int limit) {
        operation.limit(sql, limit);
        return this;
    }

    @Override
    public LimitStep orderBy(String...fields) {
        operation.orderBy(sql, fields);
        return null;
    }

    @Override
    public WhereStep on(String...conditions) {
        operation.on(sql, conditions);
        return this;
    }

    @Override
    public WhereStep from(String... tables) {
        operation.from(sql, tables);
        return this;
    }

    @Override
    public MultiFuncStep from(String table) {
        operation.from(sql, table);
        return this;
    }

    @Override
    public SelectFromStep select(String...fields) {
        operation.select(sql, fields);
        return this;
    }

    @Override
    public HavingOrderStep groupBy(String...fields) {
        operation.groupBy(sql, fields);
        return this;
    }

    @Override
    public String buildSql() {
        return operation.buildSql(sql);
    }

    @Override
    public String buildSqlWithBracket() {
        return operation.buildSql(sql);
    }
}
