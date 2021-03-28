package gestion.bibliotheque.projet.ws;

import gestion.bibliotheque.projet.bean.Magazine;
import gestion.bibliotheque.projet.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("gestion-biblio/Magazine")
public class MagazineRest {
    @Autowired
    private MagazineService magazineService;

    @GetMapping("/ref/{isbn}")
    public Magazine findByIsbn(@PathVariable String isbn) {
        return magazineService.findByIsbn(isbn);
    }

    @DeleteMapping("/ref/{isbn}")
    public int deleteByIsbn(@PathVariable String isbn) {
        return magazineService.deleteByIsbn(isbn);
    }

    @GetMapping("ref-biblio/{refBiblio}")
    public List<Magazine> findByRefBiblio(@PathVariable String refBiblio) {
        return magazineService.findByRefBiblio(refBiblio);
    }

    @GetMapping("/")
    public List<Magazine> findAll() {
        return magazineService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody Magazine magazine) {
        return magazineService.update(magazine);
    }

    @PostMapping("/")
    public int save(@RequestBody Magazine magazine) {
        return magazineService.save(magazine);
    }
}