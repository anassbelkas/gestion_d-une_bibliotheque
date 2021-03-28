package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Location;
import gestion.bibliotheque.projet.dao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class LocationService {

    public Location findByRef(String ref) {
        return locationDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        int resultLocationDictionnaire = locationDictionnaireService.deleteByLocationRef(ref);
        int resultLocationMagazine = locationMagazineService.deleteByLocationRef(ref);
        int resultLocationLivre = locationLivreService.deleteByLocationRef(ref);
        int resultLocationPaiemenet = paiementLocationService.deleteByLocationRef(ref);
        int resultLocation = locationDao.deleteByRef(ref);

        return resultLocationLivre+resultLocation+resultLocationDictionnaire+resultLocationMagazine+resultLocationPaiemenet;
    }

    public List<Location> findAll() {
        return locationDao.findAll();
    }

    public Location getOne(Long id) {
        return locationDao.getOne(id);
    }
    ///////////////////////////


    public int save(Location location) {
        if (findByRef(location.getRef()) != null)//existe deja
            return -1;

        else {
            locationDao.save(location);
            return 1;
        }
    }

    public int update(Location location){
        if (findByRef(location.getRef())==null)
            return -1;//existe deja
        else{
            locationDao.save(location);
            return 1 ;
        }
    }

    @Autowired
    private LocationDao locationDao ;
    @Autowired
    private LocationLivreService locationLivreService;

    @Autowired
    private LocationMagazineService locationMagazineService;


    @Autowired
    private LocationDictionnaireService locationDictionnaireService;

    @Autowired
    private PaiementLocationService paiementLocationService;

}
