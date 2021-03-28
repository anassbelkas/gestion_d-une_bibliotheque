package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.Dictionnaire;
import gestion.bibliotheque.projet.service.DictionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gestion-biblio/Dictionnaire")
public class DictionnaireRest {

    @Autowired
    private DictionnaireService dictionnaireService;

    @GetMapping("/ref/{isbn}")
    public Dictionnaire findByIsbn(@PathVariable String isbn) {
        return dictionnaireService.findByIsbn(isbn);
    }

    @DeleteMapping("/ref/{isbn}")
    public int deleteByIsbn(@PathVariable String isbn) {
        return dictionnaireService.deleteByIsbn(isbn);
    }

    @GetMapping("ref-biblio/{refBiblio}")
    public List<Dictionnaire> findByRefBiblio(@PathVariable String refBiblio) {
        return dictionnaireService.findByRefBiblio(refBiblio);
    }

    @GetMapping("/")
    public List<Dictionnaire> findAll() {
        return dictionnaireService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody Dictionnaire dictionnaire) {
        return dictionnaireService.update(dictionnaire);
    }

    @PostMapping("/")
    public int save(@RequestBody Dictionnaire dictionnaire) {
        return dictionnaireService.save(dictionnaire);
    }
}