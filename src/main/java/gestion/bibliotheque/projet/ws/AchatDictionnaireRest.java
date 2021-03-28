package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.AchatDictionnaire;
import gestion.bibliotheque.projet.service.AchatDictionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gestion-biblio/AchatDictionnaire")
public class AchatDictionnaireRest {
    @Autowired
    private AchatDictionnaireService achatDictionnaireService;


    @GetMapping("/ref/{ref}")
    public AchatDictionnaire findByRef(@PathVariable String ref) {
        return achatDictionnaireService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return achatDictionnaireService.deleteByRef(ref);
    }

    @GetMapping("/ref-biblio/{refBiblio}")
    public List<AchatDictionnaire> findByRefBiblio(@PathVariable String refBiblio) {
        return achatDictionnaireService.findByRefBiblio(refBiblio);
    }

    @GetMapping("/Dictionnaire/ref/{isbn}")
    public List<AchatDictionnaire> findByDictionnaireIsbn(@PathVariable String isbn) {
        return achatDictionnaireService.findByDictionnaireIsbn(isbn);
    }

    @DeleteMapping("/Dictionnaire/ref/{isbn}")
    public int deleteByDictionnaireIsbn(@PathVariable String isbn) {
        return achatDictionnaireService.deleteByDictionnaireIsbn(isbn);
    }

    @GetMapping("/achat/ref/{ref}")
    public List<AchatDictionnaire> findByAchatRef(@PathVariable String ref) {
        return achatDictionnaireService.findByAchatRef(ref);
    }

    @DeleteMapping("/achat/ref/{ref}")
    public int deleteByAchatRef(@PathVariable String ref) {
        return achatDictionnaireService.deleteByAchatRef(ref);
    }

    @GetMapping("/")
    public List<AchatDictionnaire> findAll() {
        return achatDictionnaireService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody AchatDictionnaire achatDictionnaire) {
        return achatDictionnaireService.update(achatDictionnaire);
    }

    @PostMapping("/")
    public int save(@RequestBody AchatDictionnaire achatDictionnaire) {
        return achatDictionnaireService.save(achatDictionnaire);
    }
}
