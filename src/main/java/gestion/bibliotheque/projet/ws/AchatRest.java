package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.Achat;
import gestion.bibliotheque.projet.service.AchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("gestion-biblio/Achat")
public class AchatRest {
    @GetMapping("/ref/{ref}")
    public Achat findByRef(@PathVariable String ref) {
        return achatService.findByRef(ref);
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return achatService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<Achat> findAll() {
        return achatService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Achat achat) {
        return achatService.save(achat);
    }
    @PutMapping ("/")
    public int update(@RequestBody Achat achat) {
        return achatService.update(achat);
    }

    @Autowired
    private AchatService achatService ;
}