package ovh.russi.activemq.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@XmlRootElement //use this annotation otherwise laxb doesn't work while converting
public class MessageTest implements Serializable {
    private String source;
    private String message;
}
