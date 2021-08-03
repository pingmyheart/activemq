package ovh.russi.activemq.messaging.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ovh.russi.activemq.model.MessageTest;

@Component
public class TestProducer implements Producer<MessageTest> {

    @Value("${spring.activemq.topic.test}")
    private String destination;

    @Autowired
    private JmsTemplate queueJmsTemplate;

    @Override
    public void produce(MessageTest messageTest) {
        queueJmsTemplate.convertAndSend(destination, messageTest);
    }
}
