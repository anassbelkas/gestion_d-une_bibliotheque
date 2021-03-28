package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.Location;
import gestion.bibliotheque.projet.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("gestion-biblio/Location")
@RestController
public class LocationRest {

    @GetMapping("/ref/{ref}")
    public Location findByRef(@PathVariable String ref) {
        return locationService.findByRef( ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return locationService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<Location> findAll() {
        return locationService.findAll();
    }

    @GetMapping("/id/{id}")
    public Location getOne(@PathVariable Long id) {
        return locationService.getOne(id);
    }

    @PostMapping("/")
    public int save(@RequestBody Location location) {
        return locationService.save(location);
    }

    @PutMapping("/")
    public int update(@RequestBody Location location) {
        return locationService.update(location);
    }

    @Autowired
    private LocationService locationService;
}
