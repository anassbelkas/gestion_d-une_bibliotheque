package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.AchatMagazine;
import gestion.bibliotheque.projet.service.AchatMagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gestion-biblio/AchatMagazine")
public class AchatMagazineRest {
    @Autowired
    private AchatMagazineService achatMagazineService;

    @GetMapping("/ref/{ref}")
    public AchatMagazine findByRef(@PathVariable String ref) {
        return achatMagazineService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return achatMagazineService.deleteByRef(ref);
    }

    @GetMapping("/ref-biblio/{refBiblio}")
    public List<AchatMagazine> findByRefBiblio(@PathVariable String refBiblio) {
        return achatMagazineService.findByRefBiblio(refBiblio);
    }

    @GetMapping("/Magazine/ref/{isbn}")
    public List<AchatMagazine> findByMagazineIsbn(@PathVariable String isbn) {
        return achatMagazineService.findByMagazineIsbn(isbn);
    }

    @DeleteMapping("/Magazine/ref/{isbn}")
    public int deleteByMagazineIsbn(@PathVariable String isbn) {
        return achatMagazineService.deleteByMagazineIsbn(isbn);
    }

    @GetMapping("/achat/ref/{ref}")
    public List<AchatMagazine> findByAchatRef(@PathVariable String ref) {
        return achatMagazineService.findByAchatRef(ref);
    }

    @DeleteMapping("/achat/ref/{ref}")
    public int deleteByAchatRef(@PathVariable String ref) {
        return achatMagazineService.deleteByAchatRef(ref);
    }

    @GetMapping("/")
    public List<AchatMagazine> findAll() {
        return achatMagazineService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody AchatMagazine achatMagazine) {
        return achatMagazineService.update(achatMagazine);
    }

    @PostMapping("/")
    public int save(@RequestBody AchatMagazine achatMagazine) {
        return achatMagazineService.save(achatMagazine);
    }
}