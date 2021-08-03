package ovh.russi.activemq.messaging.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ovh.russi.activemq.model.MessageTest;

@Component
@Slf4j
public class QueueConsumer {

    @JmsListener(destination = "${spring.activemq.queue.test}", containerFactory = "queueJmsListenerContainerFactory")
    public void messageListener(MessageTest messageTest) {
        log.info("received string from queue ->".concat(messageTest.toString()));
    }
}
