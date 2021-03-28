package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Achat;
import gestion.bibliotheque.projet.dao.AchatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AchatService {

    public Achat findByRef(String ref) {
        return achatDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        int resultachatlivre = achatLivreService.deleteByAchatRef(ref);
        int resultachatDictionnaire = achatDictionnaireService.deleteByAchatRef(ref);
        int resultachatMagazine = achatMagazineService.deleteByAchatRef(ref);
        int resultachatPaiemenet = paiementAchatService.deleteByAchatRef(ref);
        int resultachat = achatDao.deleteByRef(ref);
        return resultachatlivre+resultachatDictionnaire+resultachatMagazine+resultachatPaiemenet+resultachat;
    }

    public List<Achat> findAll() {
        return achatDao.findAll();
    }

    public int save(Achat achat) {
        if (findByRef(achat.getRef())!=null)
            return -1 ;

        else {
            achatDao.save(achat);
            return 1 ;
        }
    }

    public int update (Achat achat){
        if (findByRef(achat.getRef())==null)
            return -1;//existe pas
        else {
            achatDao.save(achat);
            return 1;
        }
    }


    @Autowired
    private AchatDao achatDao ;

    @Autowired
    private AchatLivreService achatLivreService;

    @Autowired
    private AchatDictionnaireService achatDictionnaireService;

    @Autowired
    private AchatMagazineService achatMagazineService;

    @Autowired
    private PaiementAchatService paiementAchatService;

}