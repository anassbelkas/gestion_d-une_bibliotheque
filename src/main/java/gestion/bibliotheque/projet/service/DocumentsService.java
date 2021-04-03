package gestion.bibliotheque.projet.service;

import gestion.bibliotheque.projet.bean.Documents;
import gestion.bibliotheque.projet.dao.DocumentsDao;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentsService {
    @Autowired
    private DocumentsDao documentsDao;

    public Documents findByType(String type) {
        return documentsDao.findByType(type);
    }

    public Documents findByIsbn(String isbn) {
        return documentsDao.findByIsbn(isbn);
    }

    public int deleteByIsbn(String isbn) {
        return documentsDao.deleteByIsbn(isbn);
    }

    public List<Documents> findByQteStockExists() {
        return documentsDao.findByQteStockExists();
    }

    public List<Documents> findByQteStockNotExists() {
        return documentsDao.findByQteStockNotExists();
    }

    public List<Documents> findAll() {
        return documentsDao.findAll();
    }

    public int update(Documents documents) {
        if (findByIsbn(documents.getIsbn()) == null) {
            return -1;
        } else {
            documentsDao.save(documents);
            return 1;
        }
    }

    public int save(Documents documents) {
        if (findByIsbn(documents.getIsbn()) != null) {
            return -1;
        }
        else {
            documentsDao.save(documents);
            return 1;
        }
    }
}

