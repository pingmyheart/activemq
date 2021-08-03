package ovh.russi.activemq.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CAP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String alert;

    @Column
    private String info;

    @Column
    private String resource;

    @Column
    private String area;

    @Column(unique = true)
    private String username;
}
