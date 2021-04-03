package gestion.bibliotheque.projet.ws;


import gestion.bibliotheque.projet.bean.AchatDoc;
import gestion.bibliotheque.projet.bean.LocationDoc;
import gestion.bibliotheque.projet.dao.AchatDocDao;
import gestion.bibliotheque.projet.service.AchatDocService;
import gestion.bibliotheque.projet.vo.AchatDocVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gestion-biblio/AchatDoc")
public class AchatDocRest {
    @Autowired
    private AchatDocService achatDocService;

    @PostMapping("/criteria")
    public List<AchatDoc> findByCriteria(@RequestBody AchatDocVo achatDocVo) {
        return achatDocService.findByCriteria(achatDocVo);
    }

    @GetMapping("/achatdocref/{ref}")
    public AchatDoc findByRef(@PathVariable String ref) {
        return achatDocService.findByRef(ref);
    }

    @DeleteMapping("/achatdocref-delete/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return achatDocService.deleteByRef(ref);
    }

    @GetMapping("/achat/achatdocref/{ref}")
    public List<AchatDoc> findByAchatRef(@PathVariable String ref) {
        return achatDocService.findByAchatRef(ref);
    }

    @DeleteMapping("/achat/achatdocref-delete/{ref}")
    public int deleteByAchatRef(@PathVariable String ref) {
        return achatDocService.deleteByAchatRef(ref);
    }

    @GetMapping("/")
    public List<AchatDoc> findAll() {
        return achatDocService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody AchatDoc achatDoc){
        return achatDocService.update(achatDoc);
    }
}
