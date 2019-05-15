package com.github.warmriver.strictsteps;

/**
 * @author <wangwentian0@hotmail.com>
 * Created on 2019-05-15
 */
public interface MultiFuncStep extends SqlQuery {
    AndStep where(String condition);
    OrderByStep having(String...conditions);
    OnStep leftOuterJoin(String table);
    OnStep rightOuterJoin(String table);
    OnStep innerJoin(String table);
    SqlQuery limit(int offset, int limit);
    SqlQuery limit(int limit);
    HavingOrderStep groupBy(String...fields);
    LimitStep orderBy(String...fields);
}
