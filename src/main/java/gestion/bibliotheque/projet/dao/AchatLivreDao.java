package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.AchatLivre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AchatLivreDao extends JpaRepository<AchatLivre, Long> {

    AchatLivre findByRef(String ref);
    int deleteByRef(String ref);

    List<AchatLivre> findByRefBiblio(String refBiblio);


    List<AchatLivre> findByAchatRef(String ref);
    int deleteByAchatRef(String ref);

    List<AchatLivre> findByLivreIsbn(String isbn);
    int deleteByLivreIsbn(String isbn);

}