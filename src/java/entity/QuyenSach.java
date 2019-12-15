/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tien.nh173399
 */
@Entity
@Table(name = "QuyenSach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuyenSach.findAll", query = "SELECT q FROM QuyenSach q")
    , @NamedQuery(name = "QuyenSach.findByMaQuyenSach", query = "SELECT q FROM QuyenSach q WHERE q.maQuyenSach = :maQuyenSach")
    , @NamedQuery(name = "QuyenSach.findByNgayDang", query = "SELECT q FROM QuyenSach q WHERE q.ngayDang = :ngayDang")
    , @NamedQuery(name = "QuyenSach.findByTinhTrang", query = "SELECT q FROM QuyenSach q WHERE q.tinhTrang = :tinhTrang")
    , @NamedQuery(name = "QuyenSach.findByConHang", query = "SELECT q FROM QuyenSach q WHERE q.conHang = :conHang")})
public class QuyenSach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maQuyenSach")
    private Integer maQuyenSach;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngayDang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDang;
    @Size(max = 50)
    @Column(name = "tinhTrang")
    private String tinhTrang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conHang")
    private boolean conHang;
    @JoinColumn(name = "maDauSach", referencedColumnName = "maDauSach")
    @ManyToOne(optional = false)
    private DauSach maDauSach;
    @JoinColumn(name = "nguoiBan", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private NguoiDung nguoiBan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quyenSach")
    private Collection<DaMua> daMuaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maQuyenSach")
    private Collection<Anh> anhCollection;
    public QuyenSach() {
    }

    public QuyenSach(Integer maQuyenSach) {
        this.maQuyenSach = maQuyenSach;
    }

    public QuyenSach(Integer maQuyenSach, Date ngayDang, boolean conHang) {
        this.maQuyenSach = maQuyenSach;
        this.ngayDang = ngayDang;
        this.conHang = conHang;
    }
    
//    public void setUrlAnh(List<String> input){
//        this.urlAnh=input;
//    }
//    
//    public List<String> getUrlAnh(){
//        return this.urlAnh;
//    }
    
    public Integer getMaQuyenSach() {
        return maQuyenSach;
    }

    public void setMaQuyenSach(Integer maQuyenSach) {
        this.maQuyenSach = maQuyenSach;
    }

    public String getNgayDang() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return df.format(this.ngayDang);
    }

    public void setNgayDang(Date ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public boolean getConHang() {
        return conHang;
    }

    public void setConHang(boolean conHang) {
        this.conHang = conHang;
    }

    public DauSach getMaDauSach() {
        return maDauSach;
    }

    public void setMaDauSach(DauSach maDauSach) {
        this.maDauSach = maDauSach;
    }

    public NguoiDung getNguoiBan() {
        return nguoiBan;
    }

    public void setNguoiBan(NguoiDung nguoiBan) {
        this.nguoiBan = nguoiBan;
    }

    @XmlTransient
    public Collection<DaMua> getDaMuaCollection() {
        return daMuaCollection;
    }

    public void setDaMuaCollection(Collection<DaMua> daMuaCollection) {
        this.daMuaCollection = daMuaCollection;
    }

    @XmlTransient
    public Collection<Anh> getAnhCollection() {
        return anhCollection;
    }

    public void setAnhCollection(Collection<Anh> anhCollection) {
        this.anhCollection = anhCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maQuyenSach != null ? maQuyenSach.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuyenSach)) {
            return false;
        }
        QuyenSach other = (QuyenSach) object;
        if ((this.maQuyenSach == null && other.maQuyenSach != null) || (this.maQuyenSach != null && !this.maQuyenSach.equals(other.maQuyenSach))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.QuyenSach[ maQuyenSach=" + maQuyenSach + " ]";
    }
    
}
