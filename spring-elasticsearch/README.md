#**springboot整合ES的三种方式**
##1.使用Java API
引入spring-data-es的依赖:要求和当前安装的es的版本一致,目前我的版本是6.5.0,最新的spring-data-elasticsearch不支持7.0的es
<!--引入spring-data-es的依赖-->
        <dependency>
            <groupId>org.elasticsearch.client</groupId>
            <artifactId>transport</artifactId>
            <version>${elasticsearch.version}</version>
        </dependency>
