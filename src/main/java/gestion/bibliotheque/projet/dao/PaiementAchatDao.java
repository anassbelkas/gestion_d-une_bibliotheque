package gestion.bibliotheque.projet.dao;

import gestion.bibliotheque.projet.bean.PaiementAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PaiementAchatDao extends JpaRepository<PaiementAchat,Long> {

    PaiementAchat findByRef(String ref);

    int deleteByRef(String ref);

    List<PaiementAchat> findByAchatRef(String ref);

    int deleteByAchatRef(String ref);
}
