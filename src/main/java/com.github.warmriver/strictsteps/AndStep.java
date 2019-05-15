package com.github.warmriver.strictsteps;

/**
 * @author <wangwentian0@hotmail.com>
 * Created on 2019-05-15
 */
public interface AndStep extends SqlQuery {
    AndStep and(String condition);
    SqlQuery limit(int offset, int limit);
    SqlQuery limit(int limit);
    LimitStep orderBy(String...fields);
    OrderByStep having(String...conditions);
    HavingOrderStep groupBy(String...fields);
}
