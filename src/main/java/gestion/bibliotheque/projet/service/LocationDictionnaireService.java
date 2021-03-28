package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Dictionnaire;
import gestion.bibliotheque.projet.bean.Location;
import gestion.bibliotheque.projet.bean.LocationDictionnaire;
import gestion.bibliotheque.projet.dao.LocationDictionnaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LocationDictionnaireService {

    @Autowired
    private LocationDictionnaireDao locationDictionnaireDao;

    @Autowired
    private DictionnaireService dictionnaireService;

    @Autowired
    private LocationService locationService;

    public List<LocationDictionnaire> findByLocationRef(String ref) {
        return locationDictionnaireDao.findByLocationRef(ref);
    }
    @Transactional
    public int deleteByLocationRef(String ref) {
        return locationDictionnaireDao.deleteByLocationRef(ref);
    }


    public LocationDictionnaire findByRef(String ref) {
        return locationDictionnaireDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return locationDictionnaireDao.deleteByRef(ref);
    }

    public List<LocationDictionnaire> findByRefBiblio(String refBiblio) {
        return locationDictionnaireDao.findByRefBiblio(refBiblio);
    }

    public List<LocationDictionnaire> findByDictionnaireIsbn(String isbn) {
        return locationDictionnaireDao.findByDictionnaireIsbn(isbn);
    }

    @Transactional
    public int deleteByDictionnaireIsbn(String isbn) {
        return locationDictionnaireDao.deleteByDictionnaireIsbn(isbn);
    }

    public List<LocationDictionnaire> findAll() {
        return locationDictionnaireDao.findAll();
    }

    public int update(LocationDictionnaire locationDictionnaire){
        if(findByRef(locationDictionnaire.getRef())==null){
            return -1;
        }else{
            locationDictionnaireDao.save(locationDictionnaire);
            return 1;
        }
    }

    public int save(LocationDictionnaire locationDictionnaire){
        if (findByRef(locationDictionnaire.getRef())!=null){
            return -1;
        }
        Dictionnaire dictionnaire = dictionnaireService.findByIsbn(locationDictionnaire.getDictionnaire().getIsbn());
        locationDictionnaire.setDictionnaire(dictionnaire);
        if (dictionnaire.getIsbn()==null){
            return -2;
        }
        else if (dictionnaire.getQteStock()-locationDictionnaire.getQte()<0){
            return -3;
        }
        else{
            double nvqteStock = dictionnaire.getQteStock()-locationDictionnaire.getQte();
            double nvqteLouer = dictionnaire.getQteLouer()+locationDictionnaire.getQte();
            dictionnaire.setQteStock(nvqteStock);
            dictionnaire.setQteLouer(nvqteLouer);
            dictionnaireService.update(dictionnaire);
            locationDictionnaireDao.save(locationDictionnaire);

            prixtotal(locationDictionnaire.getRef());

            prixlocation(locationDictionnaire.getRef());
            return 1;

        }
    }

    public int prixtotal(String ref){
        LocationDictionnaire locationDictionnaire = findByRef(ref);

        double prix = locationDictionnaire.getPrixUnitaire()*locationDictionnaire.getQte();
        locationDictionnaire.setPrixtotal(prix);
        locationDictionnaireDao.save(locationDictionnaire);
        return 1;
    }

    public int prixlocation(String ref){
        LocationDictionnaire locationDictionnaire = findByRef(ref);

        Location location = locationService.findByRef(locationDictionnaire.getLocation().getRef());
        locationDictionnaire.setLocation(location);

        if (location.getRef()==null){
            return -1;
        }
        else {
            double nvTotal = location.getTotal()+ locationDictionnaire.getPrixtotal();
            location.setTotal(nvTotal);
            locationService.update(location);
            locationDictionnaireDao.save(locationDictionnaire);
            return 1;
        }
    }
}