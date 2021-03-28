package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.Dictionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionnaireDao extends JpaRepository<Dictionnaire,Long> {

    Dictionnaire findByIsbn(String isbn);
    int deleteByIsbn(String isbn);

    List<Dictionnaire> findByRefBiblio(String refBiblio);

}
