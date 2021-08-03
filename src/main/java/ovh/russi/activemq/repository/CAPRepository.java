package ovh.russi.activemq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ovh.russi.activemq.model.CAP;

@Repository
public interface CAPRepository extends JpaRepository<CAP, Long> {

    Boolean existsByUsername(String username);
}
