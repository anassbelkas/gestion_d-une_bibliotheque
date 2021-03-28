package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Location;
import gestion.bibliotheque.projet.bean.PaiementLocation;
import gestion.bibliotheque.projet.dao.PaiementLocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PaiementLocationService {


    public PaiementLocation findByRef(String ref) {
        return paiementLocationDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return paiementLocationDao.deleteByRef(ref);
    }

    public PaiementLocation getOne(Long id) {
        return paiementLocationDao.getOne(id);
    }

    public List<PaiementLocation> findByLocationRef(String ref) {
        return paiementLocationDao.findByLocationRef(ref);
    }

    public int deleteByLocationRef(String ref) {
        return paiementLocationDao.deleteByLocationRef(ref);
    }

    public int save(PaiementLocation paiementLocation) {
        if (findByRef(paiementLocation.getRef()) != null)
            return -1;

        Location location = locationService.findByRef(paiementLocation.getLocation().getRef());
        paiementLocation.setLocation(location);

        //paiment continet la commande
        //la commande contient seulement la reference

        if (location.getRef() == null)
            return -2;
        else if (location.getTotalPaye() + paiementLocation.getMontant() > location.getTotal())
            return -3;
        else {
            double nvTotalPaye = location.getTotalPaye() + paiementLocation.getMontant();
            location.setTotalPaye(nvTotalPaye);
            locationService.update(location);
            paiementLocationDao.save(paiementLocation);

            return 1;
        }

    }

    public int update(PaiementLocation paiementLocation) {
        if (findByRef(paiementLocation.getRef()) == null)
            return -1;
        else {
            paiementLocationDao.save(paiementLocation);
            return 1;
        }
    }


    @Autowired
    private PaiementLocationDao paiementLocationDao;

    @Autowired
    private LocationService locationService;

}