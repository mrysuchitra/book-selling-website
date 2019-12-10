package entity;

import entity.DauSach;
import entity.NguoiDung;
import entity.ReviewSachPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-07T03:31:02")
@StaticMetamodel(ReviewSach.class)
public class ReviewSach_ { 

    public static volatile SingularAttribute<ReviewSach, ReviewSachPK> reviewSachPK;
    public static volatile SingularAttribute<ReviewSach, String> review;
    public static volatile SingularAttribute<ReviewSach, Date> ngayReview;
    public static volatile SingularAttribute<ReviewSach, DauSach> dauSach;
    public static volatile SingularAttribute<ReviewSach, NguoiDung> nguoiDung;
    public static volatile SingularAttribute<ReviewSach, Short> soSao;

}