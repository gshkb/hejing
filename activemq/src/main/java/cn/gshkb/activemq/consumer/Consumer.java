package cn.gshkb.activemq.consumer;

import org.springframework.stereotype.*;
import org.springframework.jms.annotation.JmsListener;

/**
 * 消费者
 *
 * @author hkb
 * @create 2019-05-07 15:23 v1.0
 **/

@Component
public class Consumer {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:" + text);
    }
}
