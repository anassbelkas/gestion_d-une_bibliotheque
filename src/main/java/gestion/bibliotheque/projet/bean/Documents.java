package gestion.bibliotheque.projet.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String isbn;
    private BigDecimal qteStock;
    private BigDecimal qteAcheter;
    private BigDecimal qteLouer;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public BigDecimal getQteStock() {
        return qteStock;
    }

    public void setQteStock(BigDecimal qteStock) {
        this.qteStock = qteStock;
    }

    public BigDecimal getQteAcheter() {
        return qteAcheter;
    }

    public void setQteAcheter(BigDecimal qteAcheter) {
        this.qteAcheter = qteAcheter;
    }

    public BigDecimal getQteLouer() {
        return qteLouer;
    }

    public void setQteLouer(BigDecimal qteLouer) {
        this.qteLouer = qteLouer;
    }
}
