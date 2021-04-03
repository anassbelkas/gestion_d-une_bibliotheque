package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Achat;
import gestion.bibliotheque.projet.bean.AchatDoc;
import gestion.bibliotheque.projet.bean.PaiementAchat;
import gestion.bibliotheque.projet.dao.AchatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AchatService {

    public Achat findByRef(String ref) {
        return achatDao.findByRef(ref);
    }

    public List<Achat> findAll() {
        return achatDao.findAll();
    }



    public int save(Achat achat) {
        if (findByRef(achat.getRef())!=null)
            return -1 ;

        else {
            prepare(achat);

            achatDao.save(achat);
            achatDocService.save(achat,achat.getAchatDocs());

            return 1 ;
        }
    }

    private void prepare(Achat achat) {
        BigDecimal total = BigDecimal.ZERO;
        for (AchatDoc achatDoc : achat.getAchatDocs()){
            total = total.add(achatDoc.getPrixUnitaire().multiply(achatDoc.getQte()));
        }
        achat.setTotal(total);

        if (achat.getTotalPaye() == null){
            achat.setTotalPaye(BigDecimal.ZERO);
        }

    }


    @Transactional
    public int deleteByRef(String ref) {
        int resultachatDoc = achatDocService.deleteByAchatRef(ref);
        int resultachatPaiemenet = paiementAchatService.deleteByAchatRef(ref);
        int resultachat = achatDao.deleteByRef(ref);
        return resultachatDoc+resultachatPaiemenet+resultachat;
    }



    public int update (Achat achat){
        if (findByRef(achat.getRef())==null)
            return -1;//existe pas
        else {
            achatDao.save(achat);
            return 1;
        }
    }


    @Autowired
    private AchatDao achatDao ;

    @Autowired
    private AchatDocService achatDocService;

    @Autowired
    private PaiementAchatService paiementAchatService;

}