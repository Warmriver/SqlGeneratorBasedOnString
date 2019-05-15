package com.github.warmriver.strictsteps;

/**
 * @author <wangwentian0@hotmail.com>
 * Created on 2019-05-15
 */
public interface SqlQuery {
    String buildSql();
    String buildSqlWithBracket();
}
