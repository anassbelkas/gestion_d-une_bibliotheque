package gestion.bibliotheque.projet.ws;


import gestion.bibliotheque.projet.bean.Documents;
import gestion.bibliotheque.projet.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("gestion-biblio/Documents")
public class DocumentsRest {

    @Autowired
    private DocumentsService documentsService;

    @GetMapping("/type/{type}")
    public Documents findByType(@PathVariable String type) {
        return documentsService.findByType(type);
    }

    @GetMapping("/docref/{isbn}")
    public Documents findByIsbn(@PathVariable String isbn) {
        return documentsService.findByIsbn(isbn);
    }

    @DeleteMapping("/docref-delete/{isbn}")
    public int deleteByIsbn(@PathVariable String isbn) {
        return documentsService.deleteByIsbn(isbn);
    }

    @GetMapping("/exist")
    public List<Documents> findByQteStockExists() {
        return documentsService.findByQteStockExists();
    }

    @GetMapping("/not-exist")
    public List<Documents> findByQteStockNotExists() {
        return documentsService.findByQteStockNotExists();
    }

    @GetMapping("/")
    public List<Documents> findAll() {
        return documentsService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody Documents documents) {
        return documentsService.update(documents);
    }

    @PostMapping("/")
    public int save(@RequestBody Documents documents) {
        return documentsService.save(documents);
    }
}
