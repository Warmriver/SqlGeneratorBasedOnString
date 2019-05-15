package com.github.warmriver.strictsteps;

/**
 * @author <wangwentian0@hotmail.com>
 * Created on 2019-05-15
 */
public interface HavingOrderStep extends SqlQuery {
    OrderByStep having(String...field);
    LimitStep orderBy(String...fields);
    SqlQuery limit(int offset, int limit);
    SqlQuery limit(int limit);
}
