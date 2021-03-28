package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Achat;
import gestion.bibliotheque.projet.bean.AchatMagazine;
import gestion.bibliotheque.projet.bean.Magazine;
import gestion.bibliotheque.projet.dao.AchatMagazineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AchatMagazineService {


    @Autowired
    private AchatMagazineDao achatMagazineDao;

    @Autowired
    private MagazineService magazineService;

    @Autowired
    private AchatService achatService;


    public AchatMagazine findByRef(String ref) {
        return achatMagazineDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return achatMagazineDao.deleteByRef(ref);
    }

    public List<AchatMagazine> findByRefBiblio(String refBiblio) {
        return achatMagazineDao.findByRefBiblio(refBiblio);
    }

    public List<AchatMagazine> findByMagazineIsbn(String isbn) {
        return achatMagazineDao.findByMagazineIsbn(isbn);
    }

    @Transactional
    public int deleteByMagazineIsbn(String isbn) {
        return achatMagazineDao.deleteByMagazineIsbn(isbn);
    }

    public List<AchatMagazine> findByAchatRef(String ref) {
        return achatMagazineDao.findByAchatRef(ref);
    }

    @Transactional
    public int deleteByAchatRef(String ref) {
        return achatMagazineDao.deleteByAchatRef(ref);
    }

    public List<AchatMagazine> findAll() {
        return achatMagazineDao.findAll();
    }

    public int update(AchatMagazine achatMagazine){
        if (findByRef(achatMagazine.getRef())==null){
            return -1;
        }
        else{
            achatMagazineDao.save(achatMagazine);
            return 1;
        }
    }

    public int save(AchatMagazine achatMagazine){
        if(findByRef(achatMagazine.getRef())!=null){
            return -1;
        }
        Magazine magazine = magazineService.findByIsbn(achatMagazine.getMagazine().getIsbn());
        achatMagazine.setMagazine(magazine);

        if (magazine.getIsbn()==null){
            return -2;
        }else if(magazine.getQteStock()-achatMagazine.getQte()<0){
            return -3;
        }
        else{
            double nvqteStock = magazine.getQteStock()-achatMagazine.getQte();
            double nvqteAcheter = magazine.getQteAcheter()+achatMagazine.getQte();
            magazine .setQteStock(nvqteStock);
            magazine.setQteAcheter(nvqteAcheter);
            magazineService.update(magazine);
            achatMagazineDao.save(achatMagazine);

            prixtotal(achatMagazine.getRef());

            prixachat(achatMagazine.getRef());

            return 1;
        }
    }

    public int prixtotal(String ref){
        AchatMagazine achatMagazine = findByRef(ref);

        double prix = achatMagazine.getPrixUnitaire()*achatMagazine.getQte();
        achatMagazine.setPrixTotal(prix);
        achatMagazineDao.save(achatMagazine);
        return 1;

    }

    public int prixachat(String ref){
        AchatMagazine achatMagazine = findByRef(ref);

        Achat achat = achatService.findByRef(achatMagazine.getAchat().getRef());
        achatMagazine.setAchat(achat);

        if (achat.getRef()==null){
            return -1;
        }else {
            double nvtotal = achat.getTotal()+ achatMagazine.getPrixTotal();
            achat.setTotal(nvtotal);
            achatService.update(achat);
            achatMagazineDao.save(achatMagazine);
            return 1;
        }
    }

}