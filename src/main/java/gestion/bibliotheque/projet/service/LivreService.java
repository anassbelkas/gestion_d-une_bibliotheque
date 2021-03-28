package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Livre;
import gestion.bibliotheque.projet.dao.LivreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreDao livreDao;

    @Autowired
    private AchatLivreService achatLivreService;

    @Autowired
    private LocationLivreService locationLivreService;

    public Livre findByIsbn(String isbn) {
        return livreDao.findByIsbn(isbn);
    }

    @Transactional
    public int deleteByIsbn(String isbn) {
        int resultAchatLivre = achatLivreService.deleteByLivreIsbn(isbn);
        int resultLocationLivre = locationLivreService.deleteByLivreIsbn(isbn);
        int resultLivre = livreDao.deleteByIsbn(isbn);
        return resultAchatLivre + resultLocationLivre + resultLivre;
    }

    public List<Livre> findByRefBiblio(String refBiblio) {
        return livreDao.findByRefBiblio(refBiblio);
    }

    public List<Livre> findAll() {
        return livreDao.findAll();
    }

    public List<Livre> findByQteStockExists() {
        return livreDao.findByQteStockExists();
    }

    public List<Livre> findByQteStockNotExists() {
        return livreDao.findByQteStockNotExists();
    }

    public int update(Livre livre) {
        if (findByIsbn(livre.getIsbn()) == null) {
            return -1;
        } else {
            livreDao.save(livre);
            return 1;
        }
    }

    public int save(Livre livre) {
        if (findByIsbn(livre.getIsbn()) != null) {
            return -1;
        } else {
            livreDao.save(livre);
            return 1;
        }
    }

}