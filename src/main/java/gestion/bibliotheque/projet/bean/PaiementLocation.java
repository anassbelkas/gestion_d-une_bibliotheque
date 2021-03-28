package gestion.bibliotheque.projet.bean;


import javax.persistence.*;
import java.util.Date;

@Entity
public class PaiementLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private double montant;
    private Date datePaiment;
    private String codePaiment;// le type de paiment : especes,virment bancaire ...


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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDatePaiment() {
        return datePaiment;
    }

    public void setDatePaiment(Date datePaiment) {
        this.datePaiment = datePaiment;
    }

    public String getCodePaiment() {
        return codePaiment;
    }

    public void setCodePaiment(String codePaiment) {
        this.codePaiment = codePaiment;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}