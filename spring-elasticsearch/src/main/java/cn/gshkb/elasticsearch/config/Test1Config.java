package cn.gshkb.elasticsearch.config;

import org.elasticsearch.client.transport.*;
import org.elasticsearch.common.settings.*;
import org.elasticsearch.common.transport.*;
import org.elasticsearch.transport.client.*;
import org.springframework.context.annotation.*;

import java.net.*;

/**
 * test1config\
 *
 * @author hkb
 * @create 2019-07-30 17:41 v1.0
 **/
@Configuration
public class Test1Config {


    @Bean
    public TransportClient client() throws UnknownHostException {

        // 指定集群名,默认为elasticsearch,如果改了集群名,这里一定要加
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .build();

        TransportClient client = new PreBuiltTransportClient(settings);

        /*
        ES的TCP端口为9300,而不是之前练习的HTTP端口9200
        这里只配置了一个节点的地址然添加进去,也可以配置多个从节点添加进去再返回
         */
        TransportAddress node = new TransportAddress(
                InetAddress.getByName("localhost"),
                9300
        );
        client.addTransportAddress(node);

        return client;
    }
}


