package cn.gshkb.rabbitmq.producer;

import cn.gshkb.rabbitmq.config.*;
import org.slf4j.*;
import org.springframework.amqp.rabbit.connection.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * 消息生产者
 *
 * @author hkb
 * @create 2019-05-07 16:55 v1.0
 **/
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
	 */
	private RabbitTemplate rabbitTemplate;
	/**
	 * 构造方法注入rabbitTemplate
	 */
	@Autowired
	public MsgProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		//rabbitTemplate如果为单例的话，那回调就是最后设置的内容
		rabbitTemplate.setConfirmCallback(this);

	}

	public void sendMsg(String content) {
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		//把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
	}
	/**
	 * 回调
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		logger.info(" 回调id:" + correlationData);
		if (ack) {
			logger.info("消息成功消费");
		} else {
			logger.info("消息消费失败:" + cause);
		}
	}

}
