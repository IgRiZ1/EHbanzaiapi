package ehb.be.ehbanzaiapi.model.DAO;

import ehb.be.ehbanzaiapi.model.Boek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoekDAO extends JpaRepository<Boek, Long> {
    List<Boek> findByGenre(String genre);
}