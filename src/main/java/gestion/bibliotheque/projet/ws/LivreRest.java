package gestion.bibliotheque.projet.ws;


import gestion.bibliotheque.projet.bean.Livre;
import gestion.bibliotheque.projet.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gestion-biblio/Livre")
public class LivreRest {

    @Autowired
    private LivreService livreService;

    @GetMapping("/ref/{isbn}")
    public  Livre findByIsbn(@PathVariable String isbn) {
        return livreService.findByIsbn(isbn);
    }

    @DeleteMapping("ref/{isbn}")
    public int deleteByIsbn(@PathVariable String isbn) {
        return livreService.deleteByIsbn(isbn);
    }

    @GetMapping("ref-biblio/{refBiblio}")
    public List<Livre> findByRefBiblio(@PathVariable String refBiblio) {
        return livreService.findByRefBiblio(refBiblio);
    }

    @GetMapping("/")
    public List<Livre> findAll() {
        return livreService.findAll();
    }


    @GetMapping("/exist")
    public List<Livre> findByQteStockExists() {
        return livreService.findByQteStockExists();
    }

    @GetMapping("/not-exist")
    public List<Livre> findByQteStockNotExists() {
        return livreService.findByQteStockNotExists();
    }

    @PutMapping("/")
    public int update(@RequestBody Livre livre) {
        return livreService.update(livre);
    }

    @PostMapping("/")
    public int save(@RequestBody Livre livre) {
        return livreService.save(livre);
    }
}