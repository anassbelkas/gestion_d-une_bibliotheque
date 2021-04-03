package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AchatDao extends JpaRepository<Achat,Long> {

    Achat findByRef(String ref);
    int deleteByRef(String ref);



}