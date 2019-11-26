package entity;

import entity.DauSach;
import entity.NguoiDung;
import entity.ReviewsachPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T23:51:30")
@StaticMetamodel(Reviewsach.class)
public class Reviewsach_ { 

    public static volatile SingularAttribute<Reviewsach, ReviewsachPK> reviewsachPK;
    public static volatile SingularAttribute<Reviewsach, String> review;
    public static volatile SingularAttribute<Reviewsach, Date> ngayReview;
    public static volatile SingularAttribute<Reviewsach, DauSach> dauSach;
    public static volatile SingularAttribute<Reviewsach, NguoiDung> nguoiDung;
    public static volatile SingularAttribute<Reviewsach, Short> soSao;

}