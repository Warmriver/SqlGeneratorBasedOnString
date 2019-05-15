<h2>sql生成器</h2>
<h3>简介<h3>
string-sql生成器是一个简单实用的基于string的sql生成器，支持通过创建者风格生成string类型的sql语句，有助于不实用ORM框架的用户灵活搭配sql， 所有的表名，字段，占位符均需要用户输入。
<h3>使用说明</h3>

```java
// 不严格的builder，可以使用任意字段
NonStrictQueryBuilder builder = SqlBuilderFactory.nonStrictSqlBuilder();
builder = builder.select("t1.id").from("t1").leftOuterJoin("t2").on("t1.id == t2.id");
if(true){
    builder = builder.where("t1.status=2");
}
builder = builder.and("t2.time > 20251201").having("t1.id in (10,100)").limit(0, 1000);
builder.buildSql(); // 结果： select t1.id from t1 left outer join t2 on t1.id == t2.id where t1.status=2 and t2.time > 20251201 having t1.id in (10,100) limit 0,1000

// 严格类型的生成器，使用时不能违反sql的约定，例如：from关键字后面不能用select
String sql = SqlBuilderFactory.strictSqlBuilder()
                .select("t1.id")
                .from("t1")
                .leftOuterJoin(builder.buildSqlWithBracket() + "as t2") // builder.buildSqlWithBracket是将一个sql作为一个
                .on("t1.id == t2.id", "t1.name=t2.name")
                .where("t1.status=2")
                .buildSql(); //结果/result： select t1.id from t1 left outer join (select t1.id from t1 left outer join t2 on t1.id == t2.id where t1.status=2 ) as t2 on t1.id == t2.id and t1.name=t2.name where t1.status=2

```


<h2>sql generator based on string</h2>
<h3>INTRODUCTION<h3>
string-sql generator is a easy to use tool to generate valid sqls. It helps those who don't want to use a ORM software to manage their sql in a more flexible way. User has to fill table names, fields and placeholders themselves in string。
<h3>USAGE</h3>

```java
// builder require no sql structure validation
NonStrictQueryBuilder builder = SqlBuilderFactory.nonStrictSqlBuilder();
builder = builder.select("t1.id").from("t1").leftOuterJoin("t2").on("t1.id == t2.id");
if(true){
    builder = builder.where("t1.status=2");
}
builder = builder.and("t2.time > 20251201").having("t1.id in (10,100)").limit(0, 1000);
builder.buildSql(); // result： select t1.id from t1 left outer join t2 on t1.id == t2.id where t1.status=2 and t2.time > 20251201 having t1.id in (10,100) limit 0,1000

// builder requires strict sql grammar, e.g. you cannot use from before select in a valid sub sql.
String sql = SqlBuilderFactory.strictSqlBuilder()
                .select("t1.id")
                .from("t1")
                .leftOuterJoin(builder.buildSqlWithBracket() + "as t2") // builder.buildSqlWithBracket是将一个sql作为一个
                .on("t1.id == t2.id", "t1.name=t2.name")
                .where("t1.status=2")
                .buildSql(); //结果/result： select t1.id from t1 left outer join (select t1.id from t1 left outer join t2 on t1.id == t2.id where t1.status=2 ) as t2 on t1.id == t2.id and t1.name=t2.name where t1.status=2

```