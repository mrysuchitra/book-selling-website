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
public class ReviewSachPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "maDauSach")
    private int maDauSach;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nguoiReview")
    private String nguoiReview;

    public ReviewSachPK() {
    }

    public ReviewSachPK(int maDauSach, String nguoiReview) {
        this.maDauSach = maDauSach;
        this.nguoiReview = nguoiReview;
    }

    public int getMaDauSach() {
        return maDauSach;
    }

    public void setMaDauSach(int maDauSach) {
        this.maDauSach = maDauSach;
    }

    public String getNguoiReview() {
        return nguoiReview;
    }

    public void setNguoiReview(String nguoiReview) {
        this.nguoiReview = nguoiReview;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maDauSach;
        hash += (nguoiReview != null ? nguoiReview.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewSachPK)) {
            return false;
        }
        ReviewSachPK other = (ReviewSachPK) object;
        if (this.maDauSach != other.maDauSach) {
            return false;
        }
        if ((this.nguoiReview == null && other.nguoiReview != null) || (this.nguoiReview != null && !this.nguoiReview.equals(other.nguoiReview))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReviewSachPK[ maDauSach=" + maDauSach + ", nguoiReview=" + nguoiReview + " ]";
    }
    
}
