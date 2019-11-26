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
@Table(name = "NguoiDung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NguoiDung.findAll", query = "SELECT n FROM NguoiDung n")
    , @NamedQuery(name = "NguoiDung.findByUsername", query = "SELECT n FROM NguoiDung n WHERE n.username = :username")
    , @NamedQuery(name = "NguoiDung.findByTen", query = "SELECT n FROM NguoiDung n WHERE n.ten = :ten")
    , @NamedQuery(name = "NguoiDung.findByPwd", query = "SELECT n FROM NguoiDung n WHERE n.pwd = :pwd")
    , @NamedQuery(name = "NguoiDung.findByDiaChi", query = "SELECT n FROM NguoiDung n WHERE n.diaChi = :diaChi")
    , @NamedQuery(name = "NguoiDung.findBySoDienThoai", query = "SELECT n FROM NguoiDung n WHERE n.soDienThoai = :soDienThoai")})
public class NguoiDung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ten")
    private String ten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "pwd")
    private String pwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "diaChi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "soDienThoai")
    private String soDienThoai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiBan")
    private Collection<QuyenSach> quyenSachCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDung1")
    private Collection<DaMua> daMuaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDung")
    private Collection<ReviewSach> reviewSachCollection;

    public NguoiDung() {
    }

    public NguoiDung(String username) {
        this.username = username;
    }

    public NguoiDung(String username, String ten, String pwd, String diaChi, String soDienThoai) {
        this.username = username;
        this.ten = ten;
        this.pwd = pwd;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @XmlTransient
    public Collection<QuyenSach> getQuyenSachCollection() {
        return quyenSachCollection;
    }

    public void setQuyenSachCollection(Collection<QuyenSach> quyenSachCollection) {
        this.quyenSachCollection = quyenSachCollection;
    }

    @XmlTransient
    public Collection<DaMua> getDaMuaCollection() {
        return daMuaCollection;
    }

    public void setDaMuaCollection(Collection<DaMua> daMuaCollection) {
        this.daMuaCollection = daMuaCollection;
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
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NguoiDung)) {
            return false;
        }
        NguoiDung other = (NguoiDung) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.NguoiDung[ username=" + username + " ]";
    }
    
}
