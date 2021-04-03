package gestion.bibliotheque.projet.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Achat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String ref ;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateAchat ;
    private BigDecimal total ;
    private BigDecimal totalPaye;




    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "achat")
    private List<AchatDoc> achatDocs;

  /*
    public List<PaiementAchat> getPaiementAchats() {
        return paiementAchats;
    }

    public void setPaiementAchats(List<PaiementAchat> paiementAchats) {
        this.paiementAchats = paiementAchats;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "achat")
    private List<PaiementAchat> paiementAchats;

 */




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


    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(BigDecimal totalPaye) {
        this.totalPaye = totalPaye;
    }

    public List<AchatDoc> getAchatDocs() {
        return achatDocs;
    }

    public void setAchatDocs(List<AchatDoc> achatDocs) {
        this.achatDocs = achatDocs;
    }
}