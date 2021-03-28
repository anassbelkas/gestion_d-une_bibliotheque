package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.LocationLivre;
import gestion.bibliotheque.projet.service.LocationLivreService;
import gestion.bibliotheque.projet.vo.LocationLivreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("gestion-biblio/locationlivre")
public class LocationLivreRest {

    @Autowired
    private LocationLivreService locationLivreService;

    @GetMapping("/referenc/{ref}")
    public List<LocationLivre> findByLocationRef(String ref) {
        return locationLivreService.findByLocationRef(ref);
    }

    @DeleteMapping("refernc/{ref}")
    public int deleteByLocationRef(String ref) {
        return locationLivreService.deleteByLocationRef(ref);
    }


    @PostMapping("/criteria")
    public List<LocationLivre> findByCriteria(@RequestBody LocationLivreVo locationLivreVo) {
        return locationLivreService.findByCriteria(locationLivreVo);
    }


    @GetMapping("/ref/{ref}")
    public LocationLivre findByRef(@PathVariable String ref) {

        return locationLivreService.findByRef(ref);
    }

    @DeleteMapping ("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return locationLivreService.deleteByRef(ref);
    }


    @GetMapping("/refBiblio/{refBiblio}")
    public List<LocationLivre> findByRefBiblio(@PathVariable String refBiblio) {
        return locationLivreService.findByRefBiblio(refBiblio);
    }

    @GetMapping("/livre/ref/{isbn}")
    public List<LocationLivre> findByLivreIsbn(@PathVariable String isbn) {
        return locationLivreService.findByLivreIsbn(isbn);
    }

    @DeleteMapping("/livre/ref/{isbn}")
    public int deleteByLivreIsbn(@PathVariable String isbn) {
        return locationLivreService.deleteByLivreIsbn(isbn);
    }


    @GetMapping("/")
    public List<LocationLivre> findAll() {
        return locationLivreService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody LocationLivre locationLivre) {
        return locationLivreService.save(locationLivre);
    }
    @PutMapping("/")
    public int update(@RequestBody LocationLivre locationLivre){
        return locationLivreService.update(locationLivre);
    }


}