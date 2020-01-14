package gen;


import org.jooq.codegen.*;
import org.jooq.meta.jaxb.*;
import org.jooq.meta.jaxb.Generator;

import java.util.*;




public class MainClass {
    public static String EXCLUDES = "schema_version|flyway_schema_history";

    public void codeGgenerator() throws Exception {
        List   list   = new ArrayList();
        Schema schema = new Schema();
        schema.setInputSchema("ds");
        schema.setOutputSchema("ds");
        list.add(schema);
        String path = System.getProperty("user.dir") + "/sharding-sphere";
 //      File directory = new File(".");
 //       String path = directory.getAbsolutePath();

        Configuration configuration = new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("com.mysql.cj.jdbc.Driver")
                        .withUrl("jdbc:mysql://localhost:3306/ds?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC")
                        .withUser("dbadmin")
                        .withPassword("123456"))
                .withGenerator(new Generator()
                        .withDatabase(new Database()
                                // .withRecordTimestampFields("create_at")
                               // .withRecordVersionFields("version").withDateAsTimestamp(false)
                                //.withForcedTypes(new ForcedType().withExpression("is_*").withName("BOOLEAN"))

                                .withName("org.jooq.meta.mysql.MySQLDatabase")
                                .withIncludes(".*")
                                .withExcludes(EXCLUDES)
                                .withSchemata(list))
                        .withStrategy(new Strategy().withName("gen.CustomGenertor"))
                        .withGenerate(new Generate().withFluentSetters(true)
                                                    .withPojos(false).withDaos(false))
                        .withTarget(new Target()
                                .withPackageName("cn.gshkb.shardingsphere.domain")
                                .withDirectory(path + "/src/main/java")));

        configuration.getGenerator().setName("gen.CustomJavaGenerator");

        GenerationTool.generate(configuration);

    }

    public static void main(String[] args) throws Exception {
        MainClass mainClass = new MainClass();
        mainClass.codeGgenerator();
    }
}