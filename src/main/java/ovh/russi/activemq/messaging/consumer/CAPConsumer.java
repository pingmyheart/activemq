package ovh.russi.activemq.messaging.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ovh.russi.activemq.dto.CAPDTO;
import ovh.russi.activemq.helper.CAPHelper;
import ovh.russi.activemq.model.CAP;
import ovh.russi.activemq.model.MessageTest;

@Component
@Slf4j
public class CAPConsumer {

    @Autowired
    private CAPHelper capHelper;

    @JmsListener(destination = "${spring.activemq.queue.cap}", containerFactory = "queueJmsListenerContainerFactory")
    public void messageListener(CAPDTO cap) {
        capHelper.saveCap(CAP.builder()
                .resource(cap.resource)
                .alert(cap.alert)
                .area(cap.area)
                .info(cap.info)
                .build()
        );
    }
}
