package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.AchatDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchatDocDao extends JpaRepository<AchatDoc, Long> {
    AchatDoc findByRef(String ref);
    int deleteByRef(String ref);

    List<AchatDoc> findByAchatRef(String ref);
    int deleteByAchatRef(String ref);


}
