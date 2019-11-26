package entity;

import entity.QuyenSach;
import entity.Reviewsach;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T23:51:30")
@StaticMetamodel(DauSach.class)
public class DauSach_ { 

    public static volatile SingularAttribute<DauSach, String> tensach;
    public static volatile SingularAttribute<DauSach, String> theloai;
    public static volatile CollectionAttribute<DauSach, Reviewsach> reviewsachCollection;
    public static volatile SingularAttribute<DauSach, Short> namSuatBan;
    public static volatile SingularAttribute<DauSach, String> maDauSach;
    public static volatile SingularAttribute<DauSach, String> urlanh;
    public static volatile CollectionAttribute<DauSach, QuyenSach> quyenSachCollection;

}