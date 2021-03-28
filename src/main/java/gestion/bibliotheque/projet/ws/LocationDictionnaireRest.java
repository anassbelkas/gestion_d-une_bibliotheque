package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.LocationDictionnaire;
import gestion.bibliotheque.projet.service.LocationDictionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gestion-biblio/LocationDictionnaire")
public class LocationDictionnaireRest {

    @Autowired
    private LocationDictionnaireService locationDictionnaireService;

    @GetMapping("/ref/{ref}")
    public LocationDictionnaire findByRef(@PathVariable String ref) {
        return locationDictionnaireService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return locationDictionnaireService.deleteByRef(ref);
    }

    @GetMapping("/ref-biblio/{refBiblio}")
    public List<LocationDictionnaire> findByRefBiblio(@PathVariable String refBiblio) {
        return locationDictionnaireService.findByRefBiblio(refBiblio);
    }

    @GetMapping("/Dictionnaire/ref/{isbn}")
    public List<LocationDictionnaire> findByDictionnaireIsbn(@PathVariable String isbn) {
        return locationDictionnaireService.findByDictionnaireIsbn(isbn);
    }

    @DeleteMapping("/Dictionnaire/ref/{isbn}")
    public int deleteByDictionnaireIsbn(@PathVariable String isbn) {
        return locationDictionnaireService.deleteByDictionnaireIsbn(isbn);
    }

    @GetMapping("/")
    public List<LocationDictionnaire> findAll() {
        return locationDictionnaireService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody LocationDictionnaire locationDictionnaire) {
        return locationDictionnaireService.update(locationDictionnaire);
    }

    @PostMapping("/")
    public int save(@RequestBody LocationDictionnaire locationDictionnaire) {
        return locationDictionnaireService.save(locationDictionnaire);
    }
    @GetMapping("/refrc/{ref}")
    public List<LocationDictionnaire> findByLocationRef(@PathVariable String ref) {
        return locationDictionnaireService.findByLocationRef(ref);
    }

    @DeleteMapping("/refr/{ref}")
    public int deleteByLocationRef(@PathVariable String ref) {
        return locationDictionnaireService.deleteByLocationRef(ref);
    }

}