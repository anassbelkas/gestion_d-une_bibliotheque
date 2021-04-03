package gestion.bibliotheque.projet.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String ref ;
    private BigDecimal total ;
    private BigDecimal totalPaye;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateLocation;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "location")
    private List<LocationDoc> locationDocs;
    /*
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "location")
    private List<PaiementLocation> paiementLocations;

    public List<PaiementLocation> getPaiementLocations() {
        return paiementLocations;
    }

    public void setPaiementLocations(List<PaiementLocation> paiementLocations) {
        this.paiementLocations = paiementLocations;
    }


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

    public Date getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(Date dateLocation) {
        this.dateLocation = dateLocation;
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

    public List<LocationDoc> getLocationDocs() {
        return locationDocs;
    }

    public void setLocationDocs(List<LocationDoc> locationDocs) {
        this.locationDocs = locationDocs;
    }
}
