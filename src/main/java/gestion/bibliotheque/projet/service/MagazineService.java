package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Magazine;
import gestion.bibliotheque.projet.dao.MagazineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MagazineService {
    @Autowired
    private MagazineDao magazineDao;

    @Autowired
    private AchatMagazineService achatMagazineService;

    @Autowired
    private LocationMagazineService locationMagazineService;

    public Magazine findByIsbn(String isbn) {
        return magazineDao.findByIsbn(isbn);
    }

    @Transactional
    public int deleteByIsbn(String isbn) {
        int resultachatMagazine = achatMagazineService.deleteByMagazineIsbn(isbn);
        int resultlocationMagazine = locationMagazineService.deleteByMagazineIsbn(isbn);
        int resultMagazine = magazineDao.deleteByIsbn(isbn);
        return resultachatMagazine + resultlocationMagazine + resultMagazine;
    }

    public List<Magazine> findByRefBiblio(String refBiblio) {
        return magazineDao.findByRefBiblio(refBiblio);
    }

    public List<Magazine> findAll() {
        return magazineDao.findAll();
    }

    public int update(Magazine magazine){
        if(findByIsbn(magazine.getIsbn()) == null){
            return -1;
        }
        else{
            magazineDao.save(magazine);
            return 1;
        }
    }

    public int save(Magazine magazine) {
        if(findByIsbn(magazine.getIsbn())!=null){
            return -1;
        }
        else{
            magazineDao.save(magazine);
            return 1;
        }
    }
}