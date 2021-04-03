package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.LocationDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationDocDao extends JpaRepository<LocationDoc, Long> {

    LocationDoc findByRef(String ref);
    int deleteByRef(String ref);

    List<LocationDoc> findByLocationRef(String ref);
    int deleteByLocationRef(String ref);
}
