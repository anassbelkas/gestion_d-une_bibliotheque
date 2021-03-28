package gestion.bibliotheque.projet.bean;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AchatDictionnaire implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String refBiblio;
    private double qte;
    private double prixUnitaire;
    private double prixTotal;

    @ManyToOne
    private Dictionnaire dictionnaire;

    @ManyToOne
    private Achat achat;

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

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Dictionnaire getDictionnaire() {
        return dictionnaire;
    }

    public void setDictionnaire(Dictionnaire dictionnaire) {
        this.dictionnaire = dictionnaire;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }
}

