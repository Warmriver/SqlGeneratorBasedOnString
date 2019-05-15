package com.github.warmriver.strictsteps;

/**
 * @author <wangwentian0@hotmail.com>
 * Created on 2019-05-15
 */
public interface OrderByStep extends SqlQuery {
    LimitStep orderBy(String...fields);
    SqlQuery limit(int offset, int limit);
    SqlQuery limit(int limit);
}
