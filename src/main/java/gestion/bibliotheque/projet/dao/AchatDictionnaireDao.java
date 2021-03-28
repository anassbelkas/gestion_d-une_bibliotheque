package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.AchatDictionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AchatDictionnaireDao extends JpaRepository<AchatDictionnaire, Long> {
    AchatDictionnaire findByRef(String ref);
    int deleteByRef(String ref);

    List<AchatDictionnaire> findByRefBiblio(String refBiblio);

    List<AchatDictionnaire> findByDictionnaireIsbn(String isbn);
    int deleteByDictionnaireIsbn(String isbn);

    List<AchatDictionnaire> findByAchatRef(String ref);
    int deleteByAchatRef(String ref);
}
