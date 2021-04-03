package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.PaiementAchat;
import gestion.bibliotheque.projet.service.PaiementAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gestion-biblio/PaiementAchat")
public class PaiementAchatRest {


    @GetMapping ("/paymentachatreference/{ref}")
    public PaiementAchat findByRef(@PathVariable String ref) {
        return paiementAchatService.findByRef(ref);
    }

    @DeleteMapping("/paymentachatreference-delete/{ref}")
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

    @GetMapping("/achat-ref/{ref}")
    public List<PaiementAchat> findByAchatRef(@PathVariable String ref) {
        return paiementAchatService.findByAchatRef(ref);
    }

    @DeleteMapping("/achat-ref-delete/{ref}")
    public int deleteByAchatRef(@PathVariable String ref) {
        return paiementAchatService.deleteByAchatRef(ref);
    }

    @Autowired
    private PaiementAchatService paiementAchatService ;

}