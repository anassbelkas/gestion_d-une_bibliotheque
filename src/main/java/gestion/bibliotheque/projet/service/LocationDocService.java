package gestion.bibliotheque.projet.service;


import gestion.bibliotheque.projet.bean.Documents;
import gestion.bibliotheque.projet.bean.Location;
import gestion.bibliotheque.projet.bean.LocationDoc;
import gestion.bibliotheque.projet.dao.LocationDocDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LocationDocService {

    public int save(Location location, List<LocationDoc> locationDocs){
        for(LocationDoc locationDoc: locationDocs){
            locationDoc.setPrixTotal(locationDoc.getPrixUnitaire().multiply(locationDoc.getQte()));
            locationDoc.setLocation(location);

            Documents documents = documentsService.findByIsbn(locationDoc.getDocuments().getIsbn());
            locationDoc.setDocuments(documents);

            if (locationDoc.getDocuments() == null ){
                return -1;
            }

            else if(locationDoc.getDocuments().getQteStock().subtract(locationDoc.getQte()).compareTo(BigDecimal.ZERO)<0) {
                return -2;
            }else{

                BigDecimal nvqteStock = locationDoc.getDocuments().getQteStock().subtract(locationDoc.getQte());
                BigDecimal nvqteLouer = locationDoc.getDocuments().getQteLouer().add(locationDoc.getQte());
                locationDoc.getDocuments().setQteStock(nvqteStock);
                locationDoc.getDocuments().setQteLouer(nvqteLouer);
                documentsService.update(locationDoc.getDocuments());

                locationDocDao.save(locationDoc);

            }
        }
        return 1;
    }

    public int update(LocationDoc locationDoc){
        if(findByRef(locationDoc.getRef())==null){
            return -1;
        }else{
            locationDocDao.save(locationDoc);//update
            return 1;
        }
    }

    public LocationDoc findByRef(String ref) {
        return locationDocDao.findByRef(ref);
    }

    public int deleteByRef(String ref) {
        return locationDocDao.deleteByRef(ref);
    }

    public List<LocationDoc> findByLocationRef(String ref) {
        return locationDocDao.findByLocationRef(ref);
    }

    public int deleteByLocationRef(String ref) {
        return locationDocDao.deleteByLocationRef(ref);
    }

    public List<LocationDoc> findAll() {
        return locationDocDao.findAll();
    }

    @Autowired
    private LocationDocDao locationDocDao;

    @Autowired
    private DocumentsService documentsService;
}
