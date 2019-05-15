package com.github.warmriver;

import com.github.warmriver.loose.NonStrictQueryBuilder;
import com.github.warmriver.loose.NonStrictSqlImpl;
import com.github.warmriver.operation.StringOperation;
import com.github.warmriver.strictsteps.SelectFromStep;
import com.github.warmriver.strictsteps.SqlImpl;
import com.sun.org.apache.xpath.internal.operations.String;

/**
 * @author <wangwentian0@hotmail.com>
 * Created on 2019-05-15
 */
public class SqlBuilderFactory {
    public static SelectFromStep strictSqlBuilder(){
        SelectFromStep initbuilder = new SqlImpl(new StringBuilder(), new StringOperation());
        return initbuilder;
    }
    public static NonStrictQueryBuilder nonStrictSqlBuilder(){
        NonStrictQueryBuilder initBuilder = new NonStrictSqlImpl(new StringBuilder(), new StringOperation());
        return initBuilder;
    }
}
