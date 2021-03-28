package gestion.bibliotheque.projet.dao;


import gestion.bibliotheque.projet.bean.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreDao extends JpaRepository<Livre, Long> {

    Livre findByIsbn(String isbn);
    int deleteByIsbn(String isbn);

    List<Livre> findByRefBiblio(String refBiblio);

    @Query("SELECT l FROM Livre l WHERE l.qteStock<>0")
    List<Livre> findByQteStockExists();

    @Query("SELECT l FROM Livre l WHERE l.qteStock=0")
    List<Livre> findByQteStockNotExists();

}
