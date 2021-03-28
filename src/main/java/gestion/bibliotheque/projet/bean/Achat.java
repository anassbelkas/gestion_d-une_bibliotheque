package gestion.bibliotheque.projet.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Achat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String ref ;
    private String refBiblio ;
    private Date dateAchat ;
    private double Total ;
    private double TotalPaye;

    public double getTotalPaye() {
        return TotalPaye;
    }

    public void setTotalPaye(double totalPaye) {
        TotalPaye = totalPaye;
    }



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

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

}