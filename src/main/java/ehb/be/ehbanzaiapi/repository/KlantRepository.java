package ehb.be.ehbanzaiapi.repository;

import ehb.be.ehbanzaiapi.model.Klant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlantRepository extends JpaRepository<Klant, Long> {
}