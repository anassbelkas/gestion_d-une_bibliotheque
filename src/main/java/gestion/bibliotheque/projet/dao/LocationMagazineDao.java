package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.LocationMagazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LocationMagazineDao extends JpaRepository<LocationMagazine,Long> {

    LocationMagazine findByRef(String ref);
    int deleteByRef(String ref);

    List<LocationMagazine> findByRefBiblio(String refBiblio);

    List<LocationMagazine> findByMagazineIsbn(String isbn);
    int deleteByMagazineIsbn(String isbn);

    List<LocationMagazine> findByLocationRef(String ref);
    int deleteByLocationRef(String ref);



}
