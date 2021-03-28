package gestion.bibliotheque.projet.bean;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LocationLivre implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String refBiblio;
    private double qte;
    private double prixUnitaire;
    private double prixtotal;


    @ManyToOne
    private Livre livre;



    @ManyToOne
    private Location location;



    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getRef() {

        return ref;
    }

    public void setRef(String ref) {

        this.ref = ref;
    }

    public String getRefBiblio() {

        return refBiblio;
    }

    public void setRefBiblio(String refBiblio) {

        this.refBiblio = refBiblio;
    }

    public double getQte() {

        return qte;
    }

    public void setQte(double qte) {

        this.qte = qte;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(double prixtotal) {
        this.prixtotal = prixtotal;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}