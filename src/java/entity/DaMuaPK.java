/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author tien.nh173399
 */
@Embeddable
public class DaMuaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nguoiDung")
    private String nguoiDung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maQuyenSach")
    private int maQuyenSach;

    public DaMuaPK() {
    }

    public DaMuaPK(String nguoiDung, int maQuyenSach) {
        this.nguoiDung = nguoiDung;
        this.maQuyenSach = maQuyenSach;
    }

    public String getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(String nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public int getMaQuyenSach() {
        return maQuyenSach;
    }

    public void setMaQuyenSach(int maQuyenSach) {
        this.maQuyenSach = maQuyenSach;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nguoiDung != null ? nguoiDung.hashCode() : 0);
        hash += (int) maQuyenSach;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DaMuaPK)) {
            return false;
        }
        DaMuaPK other = (DaMuaPK) object;
        if ((this.nguoiDung == null && other.nguoiDung != null) || (this.nguoiDung != null && !this.nguoiDung.equals(other.nguoiDung))) {
            return false;
        }
        if (this.maQuyenSach != other.maQuyenSach) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DaMuaPK[ nguoiDung=" + nguoiDung + ", maQuyenSach=" + maQuyenSach + " ]";
    }
    
}
