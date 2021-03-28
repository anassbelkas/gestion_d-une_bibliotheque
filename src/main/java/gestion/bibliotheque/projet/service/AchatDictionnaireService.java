package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Achat;
import gestion.bibliotheque.projet.bean.AchatDictionnaire;
import gestion.bibliotheque.projet.bean.Dictionnaire;
import gestion.bibliotheque.projet.dao.AchatDictionnaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AchatDictionnaireService {

    @Autowired
    private AchatDictionnaireDao achatDictionnaireDao;

    @Autowired
    private DictionnaireService dictionnaireService;

    @Autowired
    private AchatService achatService;


    public AchatDictionnaire findByRef(String ref) {
        return achatDictionnaireDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return achatDictionnaireDao.deleteByRef(ref);
    }

    public List<AchatDictionnaire> findByRefBiblio(String refBiblio) {
        return achatDictionnaireDao.findByRefBiblio(refBiblio);
    }

    public List<AchatDictionnaire> findByDictionnaireIsbn(String isbn) {
        return achatDictionnaireDao.findByDictionnaireIsbn(isbn);
    }

    @Transactional
    public int deleteByDictionnaireIsbn(String isbn) {
        return achatDictionnaireDao.deleteByDictionnaireIsbn(isbn);
    }

    public List<AchatDictionnaire> findByAchatRef(String ref) {
        return achatDictionnaireDao.findByAchatRef(ref);
    }

    @Transactional
    public int deleteByAchatRef(String ref) {
        return achatDictionnaireDao.deleteByAchatRef(ref);
    }

    public List<AchatDictionnaire> findAll() {
        return achatDictionnaireDao.findAll();
    }

    public int update(AchatDictionnaire achatDictionnaire){
        if (findByRef(achatDictionnaire.getRef())==null){
            return -1;
        }
        else{
            achatDictionnaireDao.save(achatDictionnaire);
            return 1;
        }
    }

    public int save(AchatDictionnaire achatDictionnaire){
        if(findByRef(achatDictionnaire.getRef())!=null){
            return -1;
        }
        Dictionnaire dictionnaire = dictionnaireService.findByIsbn(achatDictionnaire.getDictionnaire().getIsbn());
        achatDictionnaire.setDictionnaire(dictionnaire);

        if (dictionnaire.getIsbn()==null){
            return -2;
        }else if(dictionnaire.getQteStock()-achatDictionnaire.getQte()<0){
            return -3;
        }
        else{
            double nvqteStock = dictionnaire.getQteStock()-achatDictionnaire.getQte();
            double nvqteAcheter = dictionnaire.getQteAcheter()+achatDictionnaire.getQte();
            dictionnaire.setQteStock(nvqteStock);
            dictionnaire.setQteAcheter(nvqteAcheter);
            dictionnaireService.update(dictionnaire);
            achatDictionnaireDao.save(achatDictionnaire);

            prixtotal(achatDictionnaire.getRef());

            prixachat(achatDictionnaire.getRef());

            return 1;
        }
    }

    public int prixtotal(String ref){
        AchatDictionnaire achatDictionnaire = findByRef(ref);

        double prix = achatDictionnaire.getPrixUnitaire()*achatDictionnaire.getQte();
        achatDictionnaire.setPrixTotal(prix);
        achatDictionnaireDao.save(achatDictionnaire);
        return 1;

    }

    public int prixachat(String ref){
        AchatDictionnaire achatDictionnaire = findByRef(ref);

        Achat achat = achatService.findByRef(achatDictionnaire.getAchat().getRef());
        achatDictionnaire.setAchat(achat);

        if (achat.getRef()==null){
            return -1;
        }else {
            double nvtotal = achat.getTotal()+ achatDictionnaire.getPrixTotal();
            achat.setTotal(nvtotal);
            achatService.update(achat);
            achatDictionnaireDao.save(achatDictionnaire);
            return 1;
        }
    }
}
