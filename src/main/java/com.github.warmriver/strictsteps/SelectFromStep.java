package com.github.warmriver.strictsteps;

/**
 * @author <wangwentian0@hotmail.com>
 * Created on 2019-05-15
 */
public interface SelectFromStep extends SqlQuery{
    WhereStep from(String...table);
    MultiFuncStep from(String table);
    SelectFromStep select(String...fields);
}
