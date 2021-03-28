package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MagazineDao extends JpaRepository<Magazine,Long> {

    Magazine findByIsbn(String isbn);
    int deleteByIsbn(String isbn);

    List<Magazine> findByRefBiblio(String refBiblio);


}
