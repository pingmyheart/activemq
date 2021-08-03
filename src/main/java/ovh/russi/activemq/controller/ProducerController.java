package ovh.russi.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.russi.activemq.model.MessageTest;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.StringWriter;

@RestController
public class ProducerController {

    @Autowired
    private JmsTemplate queueJmsTemplate;

    @Autowired
    private JmsTemplate topicJmsTemplate;

    @Value("${spring.activemq.queue.test}")
    private String messageQueue;

    @Value("${spring.activemq.topic.test}")
    private String messageTopic;

    @Value("${spring.activemq.queue.xml-test}")
    private String xmlQueue;

    @Autowired
    private Marshaller jaxbMarshaller;

    /**
     * @author antonio.russi
     * Use this method to generate a fake message to me sent to the queue and check in the log if the
     * message is received
      */
    @GetMapping("/queue/test")
    public void test() {
        MessageTest m = MessageTest.builder()
                .source("laPuttana")
                .message("dituamadre")
                .build();
        try{
            queueJmsTemplate.convertAndSend(messageQueue, m);
        }catch(Exception e){
            throw new RuntimeException("ho cacciato na botta fratellì");
        }
    }

    @GetMapping("/topic/test")
    public void testTopic(){
        MessageTest m = MessageTest.builder()
                .source("laPuttana")
                .message("dituamadre")
                .build();
        try{
            topicJmsTemplate.convertAndSend(messageTopic, m);
        }catch(Exception e){
            throw new RuntimeException("ho cacciato na botta fratellì");
        }
    }

    @GetMapping("/queue/testXml")
    public void testXml(){
        MessageTest m = MessageTest.builder()
                .source("laPuttana")
                .message("dituamadre")
                .build();
        try {
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(m, sw);
            queueJmsTemplate.convertAndSend(xmlQueue, sw.toString());
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
