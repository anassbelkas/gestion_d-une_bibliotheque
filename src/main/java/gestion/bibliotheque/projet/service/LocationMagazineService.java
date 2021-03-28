package gestion.bibliotheque.projet.service;


import gestion.bibliotheque.projet.bean.Location;
import gestion.bibliotheque.projet.bean.LocationDictionnaire;
import gestion.bibliotheque.projet.bean.LocationMagazine;
import gestion.bibliotheque.projet.bean.Magazine;
import gestion.bibliotheque.projet.dao.LocationMagazineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationMagazineService {

    public List<LocationMagazine> findByLocationRef(String ref) {
        return locationMagazineDao.findByLocationRef(ref);
    }
    @Transactional
    public int deleteByLocationRef(String ref) {
        return locationMagazineDao.deleteByLocationRef(ref);
    }

    @Autowired
    private LocationMagazineDao locationMagazineDao;

    @Autowired
    private MagazineService magazineService;

    @Autowired
    private LocationService locationService;

    public LocationMagazine findByRef(String ref) {
        return locationMagazineDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return locationMagazineDao.deleteByRef(ref);
    }

    public List<LocationMagazine> findByRefBiblio(String refBiblio) {
        return locationMagazineDao.findByRefBiblio(refBiblio);
    }

    public List<LocationMagazine> findByMagazineIsbn(String isbn) {
        return locationMagazineDao.findByMagazineIsbn(isbn);
    }

    @Transactional
    public int deleteByMagazineIsbn(String isbn) {
        return locationMagazineDao.deleteByMagazineIsbn(isbn);
    }

    public List<LocationMagazine> findAll() {
        return locationMagazineDao.findAll();
    }

    public int update(LocationMagazine locationMagazine){
        if(findByRef(locationMagazine.getRef())==null){
            return -1;
        }else{
            locationMagazineDao.save(locationMagazine);
            return 1;
        }
    }

    public int save(LocationMagazine locationMagazine){
        if (findByRef(locationMagazine.getRef())!=null){
            return -1;
        }
        Magazine magazine = magazineService.findByIsbn(locationMagazine.getMagazine().getIsbn());
        locationMagazine.setMagazine(magazine);
        if (magazine.getIsbn()==null){
            return -2;
        }
        else if (magazine.getQteStock()-locationMagazine.getQte()<0){
            return -3;
        }
        else{
            double nvqteStock = magazine.getQteStock()-locationMagazine.getQte();
            double nvqteLouer = magazine.getQteLouer()+locationMagazine.getQte();
            magazine.setQteStock(nvqteStock);
            magazine.setQteLouer(nvqteLouer);
            magazineService.update(magazine);
            locationMagazineDao.save(locationMagazine);

            prixtotal(locationMagazine.getRef());
            return 1;

        }
    }

    public int prixtotal(String ref){
        LocationMagazine locationMagazine = findByRef(ref);

            double prix = locationMagazine.getPrixUnitaire()*locationMagazine.getQte();
            locationMagazine.setPrixtotal(prix);
            locationMagazineDao.save(locationMagazine);
            return 1;

    }

    public int prixlocation(String ref){
        LocationMagazine locationMagazine = findByRef(ref);

        Location location = locationService.findByRef(locationMagazine.getLocation().getRef());
        locationMagazine.setLocation(location);

        if (location.getRef()==null){
            return -1;
        }
        else {
            double nvTotal = location.getTotal()+ locationMagazine.getPrixtotal();
            location.setTotal(nvTotal);
            locationService.update(location);
            locationMagazineDao.save(locationMagazine);
            return 1;
        }
    }
}
