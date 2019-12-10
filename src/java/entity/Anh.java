/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tien.nh173399
 */
@Entity
@Table(name = "Anh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anh.findAll", query = "SELECT a FROM Anh a")
    , @NamedQuery(name = "Anh.findByTenAnh", query = "SELECT a FROM Anh a WHERE a.tenAnh = :tenAnh")})
public class Anh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tenAnh")
    private String tenAnh;
    @JoinColumn(name = "maQuyenSach", referencedColumnName = "maQuyenSach")
    @ManyToOne(optional = false)
    private QuyenSach maQuyenSach;

    public Anh() {
    }

    public Anh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    public String getTenAnh() {
        return tenAnh.replaceAll("\'", "");
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    public QuyenSach getMaQuyenSach() {
        return maQuyenSach;
    }

    public void setMaQuyenSach(QuyenSach maQuyenSach) {
        this.maQuyenSach = maQuyenSach;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tenAnh != null ? tenAnh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anh)) {
            return false;
        }
        Anh other = (Anh) object;
        if ((this.tenAnh == null && other.tenAnh != null) || (this.tenAnh != null && !this.tenAnh.equals(other.tenAnh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Anh[ tenAnh=" + tenAnh + " ]";
    }
    
}
