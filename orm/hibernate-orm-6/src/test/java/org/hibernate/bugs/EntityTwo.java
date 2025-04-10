package org.hibernate.bugs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@Entity
public class EntityTwo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id = null;

    @Column
    private String ref;

    @OneToOne(mappedBy = "entityTwo")
    private EntityOne entityOne;

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

    public EntityOne getEntityOne() {
        return entityOne;
    }

    public void setEntityOne(EntityOne scope) {
        this.entityOne = scope;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
