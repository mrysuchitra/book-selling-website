package entity;

import entity.QuyenSach;
import entity.ReviewSach;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-14T21:55:30")
@StaticMetamodel(DauSach.class)
public class DauSach_ { 

    public static volatile SingularAttribute<DauSach, String> tenSach;
    public static volatile SingularAttribute<DauSach, String> theLoai;
    public static volatile SingularAttribute<DauSach, String> urlAnh;
    public static volatile SingularAttribute<DauSach, Short> namSuatBan;
    public static volatile CollectionAttribute<DauSach, ReviewSach> reviewSachCollection;
    public static volatile SingularAttribute<DauSach, Integer> maDauSach;
    public static volatile SingularAttribute<DauSach, String> moTa;
    public static volatile CollectionAttribute<DauSach, QuyenSach> quyenSachCollection;

}