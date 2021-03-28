package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Achat;
import gestion.bibliotheque.projet.bean.AchatLivre;
import gestion.bibliotheque.projet.bean.Livre;
import gestion.bibliotheque.projet.dao.AchatLivreDao;
import gestion.bibliotheque.projet.vo.AchatLivreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AchatLivreService {


    @Autowired
    private AchatLivreDao achatLivreDao;

    @Autowired
    private LivreService livreService;

    @Autowired
    private AchatService achatService;

    @Autowired
    private EntityManager entityManager;

    public List<AchatLivre> findByCriteria(AchatLivreVo achatLivreVo){
        String query="SELECT al FROM AchatLivre al WHERE 1=1 ";
        if (achatLivreVo.getRef() != null){
            query+="AND al.ref LIKE '%"+achatLivreVo.getRef()+"%'";
        }
        if (achatLivreVo.getPrixMin() != null){
            query+="AND al.prixTotal >= '"+achatLivreVo.getPrixMin()+"'";
        }
        if (achatLivreVo.getPrixMax() != null){
            query+="AND al.prixTotal <= '"+achatLivreVo.getPrixMax()+"'";
        }
        return entityManager.createQuery(query).getResultList();
    }



    public AchatLivre findByRef(String ref) {
        return achatLivreDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return achatLivreDao.deleteByRef(ref);
    }

    public List<AchatLivre> findByRefBiblio(String refBiblio) {
        return achatLivreDao.findByRefBiblio(refBiblio);
    }


    public List<AchatLivre> findAll() {
        return achatLivreDao.findAll();
    }


    public List<AchatLivre> findByAchatRef(String ref) {
        return achatLivreDao.findByAchatRef(ref);
    }

    @Transactional
    public int deleteByAchatRef(String ref) {
        return achatLivreDao.deleteByAchatRef(ref);
    }

    public List<AchatLivre> findByLivreIsbn(String isbn) {
        return achatLivreDao.findByLivreIsbn(isbn);
    }

    @Transactional
    public int deleteByLivreIsbn(String isbn) {
        return achatLivreDao.deleteByLivreIsbn(isbn);
    }


    public int update(AchatLivre achatLivre) {
        if(findByRef(achatLivre.getRef())==null){
            return -1;
        }
        else{
            achatLivreDao.save(achatLivre);
            return 1;
        }
    }

    public int save(AchatLivre achatLivre) {
        if(findByRef(achatLivre.getRef())!=null){
            return -1;
        }

        Livre livre = livreService.findByIsbn(achatLivre.getLivre().getIsbn());
        achatLivre.setLivre(livre);

        if(livre.getIsbn()==null){
            return -2;
        }else if(livre.getQteStock()-achatLivre.getQte()<0){
            return -3;
        }
        else{
            double nvqteStock = livre.getQteStock()-achatLivre.getQte();
            double nvqteAcheter = livre.getQteAcheter()+achatLivre.getQte();
            livre.setQteStock(nvqteStock);
            livre.setQteAcheter(nvqteAcheter);
            livreService.update(livre);
            achatLivreDao.save(achatLivre);

            prixtotal(achatLivre.getRef());

            prixachat(achatLivre.getRef());

            return 1;

        }
    }

    public int prixtotal(String ref){
        AchatLivre achatLivre = findByRef(ref);

        double prix = achatLivre.getPrixUnitaire()*achatLivre.getQte();
        achatLivre.setPrixTotal(prix);
        achatLivreDao.save(achatLivre);
        return 1;

    }


    public int prixachat(String ref){
        AchatLivre achatLivre = findByRef(ref);

        Achat achat = achatService.findByRef(achatLivre.getAchat().getRef());
        achatLivre.setAchat(achat);

        if (achat.getRef()==null){
            return -1;
        }else {
            double nvtotal = achat.getTotal()+ achatLivre.getPrixTotal();
            achat.setTotal(nvtotal);
            achatService.update(achat);
            achatLivreDao.save(achatLivre);
            return 1;
        }
    }


}