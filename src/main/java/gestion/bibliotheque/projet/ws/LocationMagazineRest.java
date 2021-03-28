package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.LocationMagazine;
import gestion.bibliotheque.projet.service.LocationMagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gestion-biblio/LocationMagazine")
public class LocationMagazineRest {
    @Autowired
    private LocationMagazineService locationMagazineService;

    @GetMapping("/ref/{ref}")
    public LocationMagazine findByRef(@PathVariable String ref) {
        return locationMagazineService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return locationMagazineService.deleteByRef(ref);
    }

    @GetMapping("/ref-biblio/{refBiblio}")
    public List<LocationMagazine> findByRefBiblio(@PathVariable String refBiblio) {
        return locationMagazineService.findByRefBiblio(refBiblio);
    }

    @GetMapping("/Magazine/ref/{isbn}")
    public List<LocationMagazine> findByMagazineIsbn(@PathVariable String isbn) {
        return locationMagazineService.findByMagazineIsbn(isbn);
    }

    @DeleteMapping("/Magazine/ref/{isbn}")
    public int deleteByMagazineIsbn(@PathVariable String isbn) {
        return locationMagazineService.deleteByMagazineIsbn(isbn);
    }

    @GetMapping("/")
    public List<LocationMagazine> findAll() {
        return locationMagazineService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody LocationMagazine locationMagazine) {
        return locationMagazineService.update(locationMagazine);
    }

    @PostMapping("/")
    public int save(@RequestBody LocationMagazine locationMagazine) {
        return locationMagazineService.save(locationMagazine);
    }
    @GetMapping("refrc/{ref}")
    public List<LocationMagazine> findByLocationRef(@PathVariable String ref) {
        return locationMagazineService.findByLocationRef(ref);
    }

    @DeleteMapping("refrc/{ref}")
    public int deleteByLocationRef(@PathVariable String ref) {
        return locationMagazineService.deleteByLocationRef(ref);
    }
}