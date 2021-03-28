package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.PaiementAchat;
import gestion.bibliotheque.projet.service.PaiementAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-biblio/PaiementAchat")
public class PaiementAchatRest {


    @GetMapping ("/reference/{ref}")
    public PaiementAchat findByRef(@PathVariable String ref) {
        return paiementAchatService.findByRef(ref);
    }

    @DeleteMapping("/refer/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return paiementAchatService.deleteByRef(ref);
    }

    @GetMapping("/id/{id}")
    public PaiementAchat getOne(@PathVariable Long id) {
        return paiementAchatService.getOne(id);
    }

    @PostMapping("/")
    public int save(@RequestBody PaiementAchat paiementAchat) {
        return paiementAchatService.save(paiementAchat);
    }

    @PutMapping("/")
    public int update(@RequestBody PaiementAchat paiementAchat) {
        return paiementAchatService.update(paiementAchat);
    }

    @GetMapping("/ref/{ref}")
    public List<PaiementAchat> findByAchatRef(@PathVariable String ref) {
        return paiementAchatService.findByAchatRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByAchatRef(@PathVariable String ref) {
        return paiementAchatService.deleteByAchatRef(ref);
    }

    @Autowired
    private PaiementAchatService paiementAchatService ;

}