package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.PaiementLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaiementLocationDao extends JpaRepository<PaiementLocation, Long> {

    PaiementLocation findByRef(String ref);
    int deleteByRef(String ref);

    List<PaiementLocation> findByLocationRef(String ref);
    int deleteByLocationRef(String ref);
}
