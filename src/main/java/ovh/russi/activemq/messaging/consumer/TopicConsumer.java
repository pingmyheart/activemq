package ovh.russi.activemq.messaging.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ovh.russi.activemq.model.MessageTest;

import java.io.Serializable;

@Component
@Slf4j
public class TopicConsumer {

    @JmsListener(destination = "${spring.activemq.topic.test}", containerFactory = "topicJmsListenerContainerFactory")
    public void messageListener(String messageTest) {
        log.info("received string from topic ->".concat(messageTest.toString()));
    }
}
