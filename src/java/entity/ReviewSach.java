/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tien.nh173399
 */
@Entity
@Table(name = "ReviewSach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewSach.findAll", query = "SELECT r FROM ReviewSach r")
    , @NamedQuery(name = "ReviewSach.findByMaDauSach", query = "SELECT r FROM ReviewSach r WHERE r.reviewSachPK.maDauSach = :maDauSach")
    , @NamedQuery(name = "ReviewSach.findByNguoiReview", query = "SELECT r FROM ReviewSach r WHERE r.reviewSachPK.nguoiReview = :nguoiReview")
    , @NamedQuery(name = "ReviewSach.findBySoSao", query = "SELECT r FROM ReviewSach r WHERE r.soSao = :soSao")
    , @NamedQuery(name = "ReviewSach.findByReview", query = "SELECT r FROM ReviewSach r WHERE r.review = :review")
    , @NamedQuery(name = "ReviewSach.findByNgayReview", query = "SELECT r FROM ReviewSach r WHERE r.ngayReview = :ngayReview")})
public class ReviewSach implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReviewSachPK reviewSachPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soSao")
    private int soSao;
    @Size(max = 500)
    @Column(name = "review")
    private String review;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngayReview")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayReview;
    @JoinColumn(name = "maDauSach", referencedColumnName = "maDauSach", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DauSach dauSach;
    @JoinColumn(name = "nguoiReview", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NguoiDung nguoiDung;

    public ReviewSach() {
    }

    public ReviewSach(ReviewSachPK reviewSachPK) {
        this.reviewSachPK = reviewSachPK;
    }

    public ReviewSach(ReviewSachPK reviewSachPK, int soSao, String review, Date ngayReview) {
        this.reviewSachPK = reviewSachPK;
        this.soSao = soSao;
        this.review=review;
        this.ngayReview = ngayReview;
    }

    public ReviewSach(int maDauSach, String nguoiReview) {
        this.reviewSachPK = new ReviewSachPK(maDauSach, nguoiReview);
    }

    public ReviewSachPK getReviewSachPK() {
        return reviewSachPK;
    }

    public void setReviewSachPK(ReviewSachPK reviewSachPK) {
        this.reviewSachPK = reviewSachPK;
    }

    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(short soSao) {
        this.soSao = soSao;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getNgayReview() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return df.format(this.ngayReview);
    }

    public void setNgayReview(Date ngayReview) {
        this.ngayReview = ngayReview;
    }

    public DauSach getDauSach() {
        return dauSach;
    }

    public void setDauSach(DauSach dauSach) {
        this.dauSach = dauSach;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewSachPK != null ? reviewSachPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewSach)) {
            return false;
        }
        ReviewSach other = (ReviewSach) object;
        if ((this.reviewSachPK == null && other.reviewSachPK != null) || (this.reviewSachPK != null && !this.reviewSachPK.equals(other.reviewSachPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReviewSach[ reviewSachPK=" + reviewSachPK + " ]";
    }
    
}
