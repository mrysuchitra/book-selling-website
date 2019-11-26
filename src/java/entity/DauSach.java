/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tien.nh173399
 */
@Entity
@Table(name = "DauSach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DauSach.findAll", query = "SELECT d FROM DauSach d")
    , @NamedQuery(name = "DauSach.findByMaDauSach", query = "SELECT d FROM DauSach d WHERE d.maDauSach = :maDauSach")
    , @NamedQuery(name = "DauSach.findByTenSach", query = "SELECT d FROM DauSach d WHERE d.tenSach = :tenSach")
    , @NamedQuery(name = "DauSach.findByNamSuatBan", query = "SELECT d FROM DauSach d WHERE d.namSuatBan = :namSuatBan")
    , @NamedQuery(name = "DauSach.findByUrlAnh", query = "SELECT d FROM DauSach d WHERE d.urlAnh = :urlAnh")
    , @NamedQuery(name = "DauSach.findByTheLoai", query = "SELECT d FROM DauSach d WHERE d.theLoai = :theLoai")})
public class DauSach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maDauSach")
    private Integer maDauSach;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tenSach")
    private String tenSach;
    @Column(name = "namSuatBan")
    private Short namSuatBan;
    @Size(max = 50)
    @Column(name = "urlAnh")
    private String urlAnh;
    @Size(max = 30)
    @Column(name = "theLoai")
    private String theLoai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maDauSach")
    private Collection<QuyenSach> quyenSachCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dauSach")
    private Collection<ReviewSach> reviewSachCollection;

    public DauSach() {
    }

    public DauSach(Integer maDauSach) {
        this.maDauSach = maDauSach;
    }

    public DauSach(Integer maDauSach, String tenSach) {
        this.maDauSach = maDauSach;
        this.tenSach = tenSach;
    }

    public Integer getMaDauSach() {
        return maDauSach;
    }

    public void setMaDauSach(Integer maDauSach) {
        this.maDauSach = maDauSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public Short getNamSuatBan() {
        return namSuatBan;
    }

    public void setNamSuatBan(Short namSuatBan) {
        this.namSuatBan = namSuatBan;
    }

    public String getUrlAnh() {
        return urlAnh;
    }

    public void setUrlAnh(String urlAnh) {
        this.urlAnh = urlAnh;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    @XmlTransient
    public Collection<QuyenSach> getQuyenSachCollection() {
        return quyenSachCollection;
    }

    public void setQuyenSachCollection(Collection<QuyenSach> quyenSachCollection) {
        this.quyenSachCollection = quyenSachCollection;
    }

    @XmlTransient
    public Collection<ReviewSach> getReviewSachCollection() {
        return reviewSachCollection;
    }

    public void setReviewSachCollection(Collection<ReviewSach> reviewSachCollection) {
        this.reviewSachCollection = reviewSachCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDauSach != null ? maDauSach.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DauSach)) {
            return false;
        }
        DauSach other = (DauSach) object;
        if ((this.maDauSach == null && other.maDauSach != null) || (this.maDauSach != null && !this.maDauSach.equals(other.maDauSach))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DauSach[ maDauSach=" + maDauSach + " ]";
    }
    
}
