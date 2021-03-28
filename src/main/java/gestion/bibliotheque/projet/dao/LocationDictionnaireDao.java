package gestion.bibliotheque.projet.dao;


import gestion.bibliotheque.projet.bean.LocationDictionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LocationDictionnaireDao extends JpaRepository<LocationDictionnaire, Long> {
    LocationDictionnaire findByRef(String ref);

    int deleteByRef(String ref);

    List<LocationDictionnaire> findByRefBiblio(String refBiblio);

    List<LocationDictionnaire> findByDictionnaireIsbn(String isbn);

    int deleteByDictionnaireIsbn(String isbn);

    List<LocationDictionnaire> findByLocationRef(String ref);

    int deleteByLocationRef(String ref);


}