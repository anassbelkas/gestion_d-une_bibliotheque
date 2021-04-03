package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Achat;
import gestion.bibliotheque.projet.bean.AchatDoc;
import gestion.bibliotheque.projet.bean.Documents;
import gestion.bibliotheque.projet.bean.LocationDoc;
import gestion.bibliotheque.projet.dao.AchatDao;
import gestion.bibliotheque.projet.dao.AchatDocDao;
import gestion.bibliotheque.projet.vo.AchatDocVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AchatDocService {



    @Autowired
    private EntityManager entityManager;

    public List<AchatDoc> findByCriteria(AchatDocVo achatDocVo){
        String query="SELECT ad FROM AchatDoc ad WHERE 1=1 ";
        if (achatDocVo.getRef() != null){
            query+="AND ad.ref LIKE '%"+achatDocVo.getRef()+"%'";
        }
        if (achatDocVo.getPrixMin() != null){
            query+="AND ad.prixTotal >= '"+achatDocVo.getPrixMin()+"'";
        }
        if (achatDocVo.getPrixMax() != null){
            query+="AND ad.prixTotal <= '"+achatDocVo.getPrixMax()+"'";
        }
        return entityManager.createQuery(query).getResultList();
    }




    public int save(Achat achat, List<AchatDoc> achatDocs){
        for(AchatDoc achatDoc: achatDocs){
            achatDoc.setPrixTotal(achatDoc.getPrixUnitaire().multiply(achatDoc.getQte()));

            achatDoc.setAchat(achat);

            Documents documents = documentsService.findByIsbn(achatDoc.getDocuments().getIsbn());
            achatDoc.setDocuments(documents);

            if (achatDoc.getDocuments() == null){
                return -1;
            }

            else if(achatDoc.getDocuments().getQteStock().subtract(achatDoc.getQte()).compareTo(BigDecimal.ZERO)<0){
                return -2;}

            else {
                BigDecimal nvqteStock = achatDoc.getDocuments().getQteStock().subtract(achatDoc.getQte());
                BigDecimal nvqteAcheter = achatDoc.getDocuments().getQteAcheter().add(achatDoc.getQte());
                achatDoc.getDocuments().setQteStock(nvqteStock);
                achatDoc.getDocuments().setQteAcheter(nvqteAcheter);
                documentsService.update(achatDoc.getDocuments());


                achatDocDao.save(achatDoc);


            }
        }
        return 1;
    }


    public int update(AchatDoc achatDoc){
        if(findByRef(achatDoc.getRef())==null){
            return -1;
        }else{
            achatDocDao.save(achatDoc);//update
            return 1;
        }
    }


    public AchatDoc findByRef(String ref) {
        return achatDocDao.findByRef(ref);
    }

    public int deleteByRef(String ref) {
        return achatDocDao.deleteByRef(ref);
    }

    public List<AchatDoc> findByAchatRef(String ref) {
        return achatDocDao.findByAchatRef(ref);
    }

    public int deleteByAchatRef(String ref) {
        return achatDocDao.deleteByAchatRef(ref);
    }

    public List<AchatDoc> findAll() {
        return achatDocDao.findAll();
    }

    @Autowired
    private AchatDocDao achatDocDao;

    @Autowired
    private DocumentsService documentsService;


}
