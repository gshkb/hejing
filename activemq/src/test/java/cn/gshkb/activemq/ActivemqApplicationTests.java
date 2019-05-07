package cn.gshkb.activemq;

import cn.gshkb.activemq.producer.*;
import org.apache.activemq.command.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqApplicationTests {

	@Autowired
	private Producer producer;

	@Test
	public void contextLoads() throws InterruptedException {
		Destination destination = new ActiveMQQueue("mytest.queue");

		for(int i=0; i<100; i++){
			producer.sendMessage(destination, "myname is chhliu!!!");
		}

	}

}
