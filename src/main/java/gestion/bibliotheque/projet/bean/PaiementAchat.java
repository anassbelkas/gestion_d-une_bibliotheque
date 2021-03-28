package gestion.bibliotheque.projet.bean;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PaiementAchat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String ref ;
    private double montant ;
    private Date datePaiment;
    private String codePaiment ; // le type de paiment : especes,virment bancaire ...
    @ManyToOne
    private Achat achat ;

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

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }
}