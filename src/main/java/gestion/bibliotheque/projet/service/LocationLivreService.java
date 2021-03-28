package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Livre;
import gestion.bibliotheque.projet.bean.Location;
import gestion.bibliotheque.projet.bean.LocationLivre;
import gestion.bibliotheque.projet.dao.LocationLivreDao;
import gestion.bibliotheque.projet.vo.LocationLivreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class LocationLivreService {
    @Autowired
    private LocationLivreDao locationlivreDao;

    @Autowired
    private LivreService livreService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private EntityManager entityManager;


    public List<LocationLivre> findByLocationRef(String ref) {
        return locationlivreDao.findByLocationRef(ref);
    }

    @Transactional
    public int deleteByLocationRef(String ref) {
        return locationlivreDao.deleteByLocationRef(ref);
    }



    public List<LocationLivre> findByCriteria(LocationLivreVo locationLivreVo){
        String query="SELECT al FROM LocationLivre al WHERE 1=1 ";
        if (locationLivreVo.getRef() != null){
            query+="AND al.ref LIKE '%"+locationLivreVo.getRef()+"%'";
        }
        if (locationLivreVo.getPrixMin() != null){
            query+="AND al.prixtotal >= '"+locationLivreVo.getPrixMin()+"'";
        }
        if (locationLivreVo.getPrixMax() != null){
            query+="AND al.prixtotal <= '"+locationLivreVo.getPrixMax()+"'";
        }
        return entityManager.createQuery(query).getResultList();
    }



    public LocationLivre findByRef(String ref) {
        return locationlivreDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return locationlivreDao.deleteByRef(ref);
    }

    public List<LocationLivre> findByRefBiblio(String refBiblio) {
        return locationlivreDao.findByRefBiblio(refBiblio);
    }

    public List<LocationLivre> findByLivreIsbn(String isbn) {
        return locationlivreDao.findByLivreIsbn(isbn);
    }

    @Transactional
    public int deleteByLivreIsbn(String isbn) {
        return locationlivreDao.deleteByLivreIsbn(isbn);
    }

    public List<LocationLivre> findAll() {

        return locationlivreDao.findAll();
    }

    public int update(LocationLivre locationLivre){
        if(findByRef(locationLivre.getRef())==null){
            return -1;
        }else{
            locationlivreDao.save(locationLivre);//update
            return 1;
        }
    }

    public int save(LocationLivre locationLivre){
        if(findByRef(locationLivre.getRef())!=null) {
            return -1;
        }
        Livre livre = livreService.findByIsbn(locationLivre.getLivre().getIsbn());
        locationLivre.setLivre(livre);

        if(livre.getIsbn()==null){
            return -2;
        }else if(livre.getQteStock()-locationLivre.getQte()<0){
            return -3;
        }
        else {
            double nvqteStock = livre.getQteStock()-locationLivre.getQte();
            double nvqteLouer = livre.getQteLouer()+locationLivre.getQte();
            livre.setQteStock(nvqteStock);
            livre.setQteLouer(nvqteLouer);
            livreService.update(livre);
            locationlivreDao.save(locationLivre);

            prixtotal(locationLivre.getRef());

            return 1;
        }

    }

    public int prixtotal(String ref){
        LocationLivre locationLivre = findByRef(ref);

            double prix = locationLivre.getPrixUnitaire()*locationLivre.getQte();
            locationLivre.setPrixtotal(prix);
            locationlivreDao.save(locationLivre);
            return 1;
    }

    public int prixlocation(String ref){
        LocationLivre locationLivre = findByRef(ref);

        Location location = locationService.findByRef(locationLivre.getLocation().getRef());
        locationLivre.setLocation(location);

        if (location.getRef()==null){
            return -1;
        }else {
            double nvTotal = location.getTotal()+locationLivre.getPrixtotal();
            location.setTotal(nvTotal);
            locationService.update(location);
            locationlivreDao.save(locationLivre);
            return 1;
        }
    }



}