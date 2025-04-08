package org.hibernate.bugs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
public class MultibankFinancingScope {

    @Id
    @SequenceGenerator(name = "CRX_ID_GENERATOR", sequenceName = "CRX_ID_SEQ", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CRX_ID_GENERATOR")
    @Column(name = "id")
    private Long id = null;

    @Column
    private String ref;

    @OneToOne(optional = false)
    private MultibankFinancingSchedule schedule;

    @Version
    @Column(nullable = false)
    private Integer version = -1;

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

    public MultibankFinancingSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(MultibankFinancingSchedule schedule) {
        this.schedule = schedule;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
