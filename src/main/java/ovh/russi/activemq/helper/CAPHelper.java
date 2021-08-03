package ovh.russi.activemq.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ovh.russi.activemq.model.CAP;
import ovh.russi.activemq.repository.CAPRepository;

@Component
@Slf4j
public class CAPHelper {

    @Autowired
    private CAPRepository capRepository;

    public void saveCap(CAP cap) {
        capRepository.save(cap);
        log.info("cap saved".concat(cap.toString()));
    }
}
