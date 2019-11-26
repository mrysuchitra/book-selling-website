/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tien.nh173399
 */
@Entity
@Table(name = "DaMua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DaMua.findAll", query = "SELECT d FROM DaMua d")
    , @NamedQuery(name = "DaMua.findByNguoiDung", query = "SELECT d FROM DaMua d WHERE d.daMuaPK.nguoiDung = :nguoiDung")
    , @NamedQuery(name = "DaMua.findByMaQuyenSach", query = "SELECT d FROM DaMua d WHERE d.daMuaPK.maQuyenSach = :maQuyenSach")
    , @NamedQuery(name = "DaMua.findByNgayMua", query = "SELECT d FROM DaMua d WHERE d.ngayMua = :ngayMua")})
public class DaMua implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DaMuaPK daMuaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngayMua")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayMua;
    @JoinColumn(name = "nguoiDung", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NguoiDung nguoiDung1;
    @JoinColumn(name = "maQuyenSach", referencedColumnName = "maQuyenSach", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private QuyenSach quyenSach;

    public DaMua() {
    }

    public DaMua(DaMuaPK daMuaPK) {
        this.daMuaPK = daMuaPK;
    }

    public DaMua(DaMuaPK daMuaPK, Date ngayMua) {
        this.daMuaPK = daMuaPK;
        this.ngayMua = ngayMua;
    }

    public DaMua(String nguoiDung, int maQuyenSach) {
        this.daMuaPK = new DaMuaPK(nguoiDung, maQuyenSach);
    }

    public DaMuaPK getDaMuaPK() {
        return daMuaPK;
    }

    public void setDaMuaPK(DaMuaPK daMuaPK) {
        this.daMuaPK = daMuaPK;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public NguoiDung getNguoiDung1() {
        return nguoiDung1;
    }

    public void setNguoiDung1(NguoiDung nguoiDung1) {
        this.nguoiDung1 = nguoiDung1;
    }

    public QuyenSach getQuyenSach() {
        return quyenSach;
    }

    public void setQuyenSach(QuyenSach quyenSach) {
        this.quyenSach = quyenSach;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (daMuaPK != null ? daMuaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DaMua)) {
            return false;
        }
        DaMua other = (DaMua) object;
        if ((this.daMuaPK == null && other.daMuaPK != null) || (this.daMuaPK != null && !this.daMuaPK.equals(other.daMuaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DaMua[ daMuaPK=" + daMuaPK + " ]";
    }
    
}
