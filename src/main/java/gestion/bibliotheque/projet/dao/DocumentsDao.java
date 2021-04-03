package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsDao extends JpaRepository<Documents, Long> {

    Documents findByType(String type);

    Documents findByIsbn(String isbn);
    int deleteByIsbn(String isbn);


    @Query("SELECT d FROM Documents d WHERE d.qteStock<>0")
    List<Documents> findByQteStockExists();

    @Query("SELECT d FROM Documents d WHERE d.qteStock=0")
    List<Documents> findByQteStockNotExists();
}
