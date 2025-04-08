package org.hibernate.bugs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;

@Entity
public class MultibankFinancingSchedule {

    @Id
    @SequenceGenerator(name = "CRX_ID_GENERATOR", sequenceName = "CRX_ID_SEQ", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CRX_ID_GENERATOR")
    @Column(name = "id")
    private Long id = null;

    @Column
    private String ref;

    @OneToOne(optional = true, mappedBy = "schedule")
    private MultibankFinancingScope scope;

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

    public MultibankFinancingScope getScope() {
        return scope;
    }

    public void setScope(MultibankFinancingScope scope) {
        this.scope = scope;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
