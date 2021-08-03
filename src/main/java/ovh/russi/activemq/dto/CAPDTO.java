package ovh.russi.activemq.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Builder
public class CAPDTO implements Serializable {
    public String alert;
    public String info;
    public String resource;
    public String area;
    @CreationTimestamp
    public Instant creationInstant;
}

