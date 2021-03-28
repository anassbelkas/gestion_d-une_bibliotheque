package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends JpaRepository<Location, Long > {

    Location findByRef(String ref);
    int deleteByRef(String ref);

}
