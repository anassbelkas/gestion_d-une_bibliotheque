package gestion.bibliotheque.projet.bean;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Dictionnaire implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String refBiblio;
    private double qteStock;
    private double qteAcheter;
    private double qteLouer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getRefBiblio() {
        return refBiblio;
    }

    public void setRefBiblio(String refBiblio) {
        this.refBiblio = refBiblio;
    }

    public double getQteStock() {
        return qteStock;
    }

    public void setQteStock(double qteStock) {
        this.qteStock = qteStock;
    }

    public double getQteAcheter() {
        return qteAcheter;
    }

    public void setQteAcheter(double qteAcheter) {
        this.qteAcheter = qteAcheter;
    }

    public double getQteLouer() {
        return qteLouer;
    }

    public void setQteLouer(double qteLouer) {
        this.qteLouer = qteLouer;
    }


}
