package ovh.russi.activemq.messaging.messages;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CAPMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private String alert;
    private String info;
    private String resource;
    private String area;
}
