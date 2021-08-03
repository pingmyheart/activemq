package ovh.russi.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.russi.activemq.dto.CAPDTO;
import ovh.russi.activemq.model.CAP;
import ovh.russi.activemq.service.CAPService;

@RestController
public class CAPController {
    @Autowired
    private CAPService capService;

    @Autowired
    private JmsTemplate queueJmsTemplate;

    @Value("${spring.activemq.queue.cap}")
    private String capQueue;

    @GetMapping("/testCap")
    public void sendCAP() {
        CAPDTO c = CAPDTO.builder()
                .alert("aller")
                .info("info")
                .area("boarea")
                .resource("some_resource")
                .build();
        queueJmsTemplate.convertAndSend(capQueue, c);
    }
}
