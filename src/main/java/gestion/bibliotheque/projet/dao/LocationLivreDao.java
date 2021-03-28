package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.LocationLivre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LocationLivreDao extends JpaRepository<LocationLivre,Long> {

    LocationLivre findByRef(String ref);
    int deleteByRef(String ref);

    List<LocationLivre> findByRefBiblio(String refBiblio);

    List<LocationLivre> findByLocationRef(String ref);
    int deleteByLocationRef(String ref);

    List<LocationLivre> findByLivreIsbn(String isbn);
    int deleteByLivreIsbn(String isbn);

}