import com.github.warmriver.SqlBuilderFactory;
import com.github.warmriver.loose.NonStrictQueryBuilder;
import com.github.warmriver.strictsteps.AndStep;
import com.github.warmriver.strictsteps.SelectFromStep;
import com.github.warmriver.strictsteps.WhereStep;
import org.junit.Test;

/**
 * @author <wangwentian0@hotmail.comm>
 * Created on 2019-05-15
 */


public class TestCases {

    @Test
    public void testNonStrictQueryBuilder() {
        NonStrictQueryBuilder b = SqlBuilderFactory.nonStrictSqlBuilder();
        b = b.select("t1.id").from("t1").leftOuterJoin("t2").on("t1.id == t2.id");
        if(true){

            b = b.where("t1.status=2");
        }
        b = b.and("t2.time > 20251201").having("t1.id in (10,100)").limit(0, 1000);
        assert "select t1.id from t1 left outer join t2 on t1.id == t2.id where t1.status=2 and t2.time > 20251201 having t1.id in (10,100) limit 0,1000".equals(b.buildSql().trim());



    }
    @Test
    public void testStrictQueryBuilder() {
        NonStrictQueryBuilder b = SqlBuilderFactory.nonStrictSqlBuilder();
        b = b.select("t1.id").from("t1").leftOuterJoin("t2").on("t1.id == t2.id");
        if(true){
            b = b.where("t1.status=2");
        }
        SelectFromStep query = SqlBuilderFactory.strictSqlBuilder();
        WhereStep where = query.select("t1.id").from("t1").leftOuterJoin(b.buildSqlWithBracket() + "as t2").on("t1.id == t2.id", "t1.name=t2.name");
        AndStep andStep = where.where("t1.status=2");
        assert "select t1.id from t1 left outer join (select t1.id from t1 left outer join t2 on t1.id == t2.id where t1.status=2 ) as t2 on t1.id == t2.id and t1.name=t2.name where t1.status=2".equals(andStep.buildSql().trim());
    }
}
