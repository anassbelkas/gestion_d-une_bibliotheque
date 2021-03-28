package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Dictionnaire;
import gestion.bibliotheque.projet.dao.DictionnaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class DictionnaireService {

    @Autowired
    private DictionnaireDao dictionnaireDao;

    @Autowired
    private LocationDictionnaireService locationDictionnaireService;

    @Autowired
    private AchatDictionnaireService achatDictionnaireService;


    public Dictionnaire findByIsbn(String isbn) {
        return dictionnaireDao.findByIsbn(isbn);
    }

    @Transactional
    public int deleteByIsbn(String isbn) {
        int resultLocationDictionnaire = locationDictionnaireService.deleteByDictionnaireIsbn(isbn);
        int resultachatDictionnaire = achatDictionnaireService.deleteByDictionnaireIsbn(isbn);
        int resultDictionnaire = dictionnaireDao.deleteByIsbn(isbn);
        return resultDictionnaire+resultLocationDictionnaire+resultachatDictionnaire;
    }

    public List<Dictionnaire> findByRefBiblio(String refBiblio) {
        return dictionnaireDao.findByRefBiblio(refBiblio);
    }

    public List<Dictionnaire> findAll() {
        return dictionnaireDao.findAll();
    }

    public int update(Dictionnaire dictionnaire){
        if(findByIsbn(dictionnaire.getIsbn()) == null){
            return -1;
        }
        else{
            dictionnaireDao.save(dictionnaire);
            return 1;
        }
    }

    public int save(Dictionnaire dictionnaire) {
        if(findByIsbn(dictionnaire.getIsbn())!=null){
            return -1;
        }
        else{
            dictionnaireDao.save(dictionnaire);
            return 1;
        }
    }
}
