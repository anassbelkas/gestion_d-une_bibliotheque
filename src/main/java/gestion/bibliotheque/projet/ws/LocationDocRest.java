package gestion.bibliotheque.projet.ws;


import gestion.bibliotheque.projet.bean.LocationDoc;
import gestion.bibliotheque.projet.service.LocationDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("gestion-biblio/LocationDoc")
public class LocationDocRest {

    @Autowired
    private LocationDocService locationDocService;

    @GetMapping("/locationdocref/{ref}")
    public LocationDoc findByRef(@PathVariable String ref) {
        return locationDocService.findByRef(ref);
    }

    @DeleteMapping("/locationdocref-delete/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return locationDocService.deleteByRef(ref);
    }

    @GetMapping("/location/locationdocref/{ref}")
    public List<LocationDoc> findByLocationRef(@PathVariable String ref) {
        return locationDocService.findByLocationRef(ref);
    }

    @DeleteMapping("/location/locationdocref-delete/{ref}")
    public int deleteByLocationRef(@PathVariable String ref) {
        return locationDocService.deleteByLocationRef(ref);
    }

    @GetMapping("/")
    public List<LocationDoc> findAll() {
        return locationDocService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody LocationDoc locationDoc){
        return locationDocService.update(locationDoc);
    }
}
