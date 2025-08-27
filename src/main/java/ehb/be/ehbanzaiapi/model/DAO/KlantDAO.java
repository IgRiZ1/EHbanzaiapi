package ehb.be.ehbanzaiapi.model.DAO;

import ehb.be.ehbanzaiapi.model.Klant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlantDAO extends JpaRepository<Klant, Long> {
}