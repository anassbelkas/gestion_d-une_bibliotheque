package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Location;
import gestion.bibliotheque.projet.bean.LocationDoc;
import gestion.bibliotheque.projet.dao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Service
public class LocationService {

    public Location findByRef(String ref) {
        return locationDao.findByRef(ref);
    }

    public List<Location> findAll() {
        return locationDao.findAll();
    }



    public int save(Location location) {
        if (findByRef(location.getRef())!=null)
            return -1 ;

        else {
            prepare(location);
            locationDao.save(location);
            locationDocService.save(location,location.getLocationDocs());
            return 1 ;
        }
    }

    private void prepare(Location location) {
        BigDecimal total = BigDecimal.ZERO;
        for (LocationDoc locationDoc : location.getLocationDocs()){
            total = total.add(locationDoc.getPrixUnitaire().multiply(locationDoc.getQte()));
        }
        location.setTotal(total);
        if (location.getTotalPaye() == null){
            location.setTotalPaye(BigDecimal.ZERO);
        }

    }





    @Transactional
    public int deleteByRef(String ref) {
        int resultLocationDoc = locationDocService.deleteByLocationRef(ref);
        int resultLocationPaiemenet = paiementLocationService.deleteByLocationRef(ref);
        int resultLocation = locationDao.deleteByRef(ref);

        return resultLocation+resultLocationPaiemenet+resultLocationDoc;
    }



    ///////////////////////////




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
    private LocationDocService locationDocService;

    @Autowired
    private PaiementLocationService paiementLocationService;

}
