package ovh.russi.activemq.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ovh.russi.activemq.model.MessageTest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Configuration
public class BeanConfiguration {

    @Bean
    public JAXBContext messageTestJAXBContext() {
        try {
            return JAXBContext.newInstance(MessageTest.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public Marshaller jaxbMarshaller(){
        try {
            return messageTestJAXBContext().createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
