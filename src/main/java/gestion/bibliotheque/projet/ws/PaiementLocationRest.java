package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.PaiementLocation;
import gestion.bibliotheque.projet.service.PaiementLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-biblio/PaiementLocation")
public class PaiementLocationRest {

    @GetMapping("/ref/{ref}")
    public PaiementLocation findByRef(@PathVariable String ref) {
        return paiementLocationService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return paiementLocationService.deleteByRef(ref);
    }

    @GetMapping("/id/{id}")
    public PaiementLocation getOne(@PathVariable Long id) {
        return paiementLocationService.getOne(id);
    }

    @PostMapping("/paiementLoaction/{paiementLoaction}")
    public int save(@RequestBody PaiementLocation paiementLocation) {
        return paiementLocationService.save(paiementLocation);
    }

    @PutMapping("/paiementLocation/{paiementLoaction}")
    public int update(@RequestBody PaiementLocation paiementLocation) {
        return paiementLocationService.update(paiementLocation);
    }

    @GetMapping("/reference/{ref}")
    public List<PaiementLocation> findByLocationRef(@PathVariable String ref) {
        return paiementLocationService.findByLocationRef(ref);
    }

    @DeleteMapping("/refer/{ref}")
    public int deleteByLocationRef(@PathVariable String ref) {
        return paiementLocationService.deleteByLocationRef(ref);
    }

    @Autowired
    private PaiementLocationService paiementLocationService;

}