package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.AchatMagazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AchatMagazineDao extends JpaRepository<AchatMagazine, Long> {
    AchatMagazine findByRef(String ref);
    int deleteByRef(String ref);

    List<AchatMagazine> findByRefBiblio(String refBiblio);

    List<AchatMagazine> findByMagazineIsbn(String isbn);
    int deleteByMagazineIsbn(String isbn);

    List<AchatMagazine> findByAchatRef(String ref);
    int deleteByAchatRef(String ref);
}
