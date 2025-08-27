package ehb.be.ehbanzaiapi.repository;

import ehb.be.ehbanzaiapi.model.Reservatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservatieRepository extends JpaRepository<Reservatie, Long> {
}