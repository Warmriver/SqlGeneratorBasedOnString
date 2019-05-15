package com.github.warmriver.operation;

/**
 * Created by wentian.wang on 2019/5/16
 */
public class StringOperation {
    public void and(StringBuilder sql, String condition) {
        sql.append("and ");
        sql.append(condition);
        sql.append(" ");
    }

    public void where(StringBuilder sql,String condition) {
        sql.append("where ");
        sql.append(condition);
        sql.append(" ");
    }

    public void having(StringBuilder sql, String...conditions) {
        sql.append("having ");
        for(int i = 0; i < conditions.length; i++) {
            sql.append(conditions[i]);
            if(i == conditions.length - 1) break;
            sql.append(" and ");
        }
        sql.append(" ");
    }
    
    public void leftOuterJoin(StringBuilder sql, String table) {
        sql.append("left outer join ");
        sql.append(table);
        sql.append(" ");
    }


    public void rightOuterJoin(StringBuilder sql, String table) {
        sql.append("right outer join ");
        sql.append(table);
        sql.append(" ");
    }
    
    public void innerJoin(StringBuilder sql, String table) {
        sql.append("inner join ");
        sql.append(table);
        sql.append(" ");
    }
    
    public void limit(StringBuilder sql, int offset, int limit) {
        sql.append("limit ");
        sql.append(offset);
        sql.append(",");
        sql.append(limit);
        sql.append(" ");
    }

    public void limit(StringBuilder sql, int limit) {
        sql.append("limit ");
        sql.append(limit);
        sql.append(" ");
    }
    
    public void orderBy(StringBuilder sql, String...fields) {
        sql.append("order by ");
        for(int i = 0; i < fields.length; i++) {
            sql.append(fields[i]);
            if(i == fields.length - 1) break;
            sql.append(",");
        }
        sql.append(" ");
    }

    public void on(StringBuilder sql, String...conditions) {
        sql.append("on ");
        for(int i = 0; i < conditions.length; i++) {
            sql.append(conditions[i]);
            if(i == conditions.length - 1) break;
            sql.append(" and ");
        }
        sql.append(" ");
    }
    
    public void from(StringBuilder sql, String... tables) {
        sql.append("from ");
        for(int i = 0; i < tables.length; i++) {
            sql.append(tables[i]);
            if(i != tables.length - 1) {
                sql.append(",");
            }
        }
        sql.append(" ");
    }
    
    public void select(StringBuilder sql, String...fields) {
        sql.append("select ");
        for(int i = 0; i < fields.length; i++) {
            sql.append(fields[i]);
            if(i != fields.length - 1) {
                sql.append(",");
            }
        }
        sql.append(" ");
    }
    
    public void groupBy(StringBuilder sql, String...fields) {
        sql.append("group by ");
        for(int i = 0; i < fields.length; i++) {
            sql.append(fields[i]);
            if(i != fields.length - 1) {
                sql.append(",");
            }
        }
        sql.append(" ");
    }
    
    public String buildSql(StringBuilder sql) {
        return sql.toString();
    }
    
    public String buildSqlWithBracket(StringBuilder sql) {
        sql.insert(0, "(");
        sql.append(")");
        sql.append(" ");
        return buildSql(sql);
    }
}
