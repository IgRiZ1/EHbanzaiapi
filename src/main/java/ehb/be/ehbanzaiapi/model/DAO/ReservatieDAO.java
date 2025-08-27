package ehb.be.ehbanzaiapi.model.DAO;

import ehb.be.ehbanzaiapi.model.Reservatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservatieDAO extends JpaRepository<Reservatie, Long> {
}