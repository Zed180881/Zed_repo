package springdatajpa.entity;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Audited
@Table(name = "contact_audit")
public class ContactAudit implements Auditable<String, Long>, Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String createdBy;
    private DateTime createdDate;
    private String lastModifiedBy;
    private DateTime lastModifiedDate;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "CREATED_BY")
    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "CREATED_DATE")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Override
    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "LAST_MODIFIED_BY")
    @Override
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Column(name = "LAST_MODIFIED_DATE")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Override
    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Transient
    @Override
    public boolean isNew() {
        if (id == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Contact - Id: " + id + ", First name: " + firstName + " Last name: " + lastName + ", Birthday: " + birthDate + ", Create bу: " + createdBy + ", Create date: " + createdDate + ", Modified bу: " + lastModifiedBy + ", Modified date: " + lastModifiedDate;
    }
}
