package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.AchatLivre;
import gestion.bibliotheque.projet.service.AchatLivreService;
import gestion.bibliotheque.projet.vo.AchatLivreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gestion-biblio/achatLivre")
public class AchatLivreRest {


    @Autowired
    private AchatLivreService achatLivreService;


    @PostMapping("/criteria")
    public List<AchatLivre> findByCriteria(@RequestBody AchatLivreVo achatLivreVo) {
        return achatLivreService.findByCriteria(achatLivreVo);
    }


    @GetMapping("/ref/{ref}")
    public AchatLivre findByRef(@PathVariable String ref) {
        return achatLivreService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return achatLivreService.deleteByRef(ref);
    }

    @GetMapping("/ref-biblio/{refBiblio}")
    public List<AchatLivre> findByRefBiblio(@PathVariable String refBiblio) {
        return achatLivreService.findByRefBiblio(refBiblio);
    }

    @GetMapping("/")
    public List<AchatLivre> findAll() {
        return achatLivreService.findAll();
    }


    @GetMapping("/achat/ref/{ref}")
    public List<AchatLivre> findByAchatRef(@PathVariable String ref) {
        return achatLivreService.findByAchatRef(ref);
    }

    @DeleteMapping("/achat/ref/{ref}")
    public int deleteByAchatRef(@PathVariable String ref) {
        return achatLivreService.deleteByAchatRef(ref);
    }

    @GetMapping("/livre/ref/{isbn}")
    public List<AchatLivre> findByLivreIsbn(@PathVariable String isbn) {
        return achatLivreService.findByLivreIsbn(isbn);
    }

    @DeleteMapping("/livre/ref/{isbn}")
    public int deleteByLivreIsbn(@PathVariable String isbn) {
        return achatLivreService.deleteByLivreIsbn(isbn);
    }

    @PutMapping("/")
    public int update(@RequestBody AchatLivre achatLivre) {
        return achatLivreService.update(achatLivre);
    }

    @PostMapping("/")
    public int save(@RequestBody AchatLivre achatLivre) {
        return achatLivreService.save(achatLivre);
    }

}