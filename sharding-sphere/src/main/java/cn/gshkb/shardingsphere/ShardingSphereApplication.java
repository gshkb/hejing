package cn.gshkb.shardingsphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement(proxyTargetClass = true)
//@ComponentScan(basePackages = {"cn.gshkb.shardingsphere"})
public class ShardingSphereApplication {


    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereApplication.class, args);
    }

}
