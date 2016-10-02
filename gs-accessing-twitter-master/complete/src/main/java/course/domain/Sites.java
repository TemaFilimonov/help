package course.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Артем Константинович on 02.10.2016.
 */
@Entity
public class Sites {
    private int id;
    private String ownerId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ownerID")
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sites sites = (Sites) o;

        if (id != sites.id) return false;
        if (ownerId != null ? !ownerId.equals(sites.ownerId) : sites.ownerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        return result;
    }
}
