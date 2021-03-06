package se.kth.iv1201projekt.integration.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the competence profile
 *
 * @author Kim
 */
@Entity
@Table(name = "competence_profile_sv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompetenceProfileSv.findAll", query = "SELECT c FROM CompetenceProfileSv c"),
    @NamedQuery(name = "CompetenceProfileSv.findByCompetenceProfileId", query = "SELECT c FROM CompetenceProfileSv c WHERE c.competenceProfileId = :competenceProfileId"),
    @NamedQuery(name = "CompetenceProfileSv.findByYearsOfExperience", query = "SELECT c FROM CompetenceProfileSv c WHERE c.yearsOfExperience = :yearsOfExperience"),
    @NamedQuery(name = "CompetenceProfileSv.findByVersion", query = "SELECT c FROM CompetenceProfileSv c WHERE c.version = :version")})
public class CompetenceProfileSv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "competence_profile_id")
    private Long competenceProfileId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "years_of_experience")
    private BigDecimal yearsOfExperience;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private int version;
    @JoinColumn(name = "competence_id", referencedColumnName = "competence_id")
    @ManyToOne
    private CompetenceSv competenceId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personId;

    public CompetenceProfileSv() {
    }

    public CompetenceProfileSv(Long competenceProfileId) {
        this.competenceProfileId = competenceProfileId;
    }

    public CompetenceProfileSv(Long competenceProfileId, int version) {
        this.competenceProfileId = competenceProfileId;
        this.version = version;
    }

    public Long getCompetenceProfileId() {
        return competenceProfileId;
    }

    public void setCompetenceProfileId(Long competenceProfileId) {
        this.competenceProfileId = competenceProfileId;
    }

    public BigDecimal getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(BigDecimal yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public CompetenceSv getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(CompetenceSv competenceId) {
        this.competenceId = competenceId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenceProfileId != null ? competenceProfileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetenceProfileSv)) {
            return false;
        }
        CompetenceProfileSv other = (CompetenceProfileSv) object;
        if ((this.competenceProfileId == null && other.competenceProfileId != null) || (this.competenceProfileId != null && !this.competenceProfileId.equals(other.competenceProfileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.kth.iv1201projekt.integration.model.CompetenceProfileSv[ competenceProfileId=" + competenceProfileId + " ]";
    }

}
