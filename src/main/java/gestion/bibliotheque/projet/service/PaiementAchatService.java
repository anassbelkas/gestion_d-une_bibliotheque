package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Achat;
import gestion.bibliotheque.projet.bean.PaiementAchat;
import gestion.bibliotheque.projet.dao.PaiementAchatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PaiementAchatService {

    public PaiementAchat findByRef(String ref) {
        return paiementAchatDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return paiementAchatDao.deleteByRef(ref);
    }

    public PaiementAchat getOne(Long id) {
        return paiementAchatDao.getOne(id);
    }

    public List<PaiementAchat> findByAchatRef(String ref) {
        return paiementAchatDao.findByAchatRef(ref);
    }
    @Transactional
    public int deleteByAchatRef(String ref) { return paiementAchatDao.deleteByAchatRef(ref); }

/////////////////////////////////////////////////////////////////////////////////////

    public  int update(PaiementAchat paiementAchat) {
        if (findByRef(paiementAchat.getRef())==null)
            return -1 ;
        else {
            paiementAchatDao.save(paiementAchat);
            return 1;
        }
    }
    public  int save(PaiementAchat paiementAchat) {
        if (findByRef(paiementAchat.getRef())!=null)
            return -1 ;

            Achat achat = achatService.findByRef(paiementAchat.getAchat().getRef());
        paiementAchat.setAchat(achat);

        //paiment continet la commande
        //la commande contient seulement la reference

        if (achat.getRef()== null)
            return -2 ;
        else if (achat.getTotalPaye()+paiementAchat.getMontant()>achat.getTotal())
            return -3 ;
        else {
            double nvTotalPaye = achat.getTotalPaye()+paiementAchat.getMontant();
            achat.setTotalPaye(nvTotalPaye);
            achatService.update(achat);

            paiementAchatDao.save(paiementAchat);

            return 1;
        }

    }



    @Autowired
    private PaiementAchatDao paiementAchatDao;

    @Autowired
    private AchatService achatService ;


}