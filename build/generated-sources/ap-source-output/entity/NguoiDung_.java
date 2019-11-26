package entity;

import entity.Damua;
import entity.QuyenSach;
import entity.Reviewsach;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T23:51:30")
@StaticMetamodel(NguoiDung.class)
public class NguoiDung_ { 

    public static volatile CollectionAttribute<NguoiDung, Reviewsach> reviewsachCollection;
    public static volatile SingularAttribute<NguoiDung, String> diaChi;
    public static volatile SingularAttribute<NguoiDung, String> soDienThoai;
    public static volatile CollectionAttribute<NguoiDung, Damua> damuaCollection;
    public static volatile SingularAttribute<NguoiDung, String> ten;
    public static volatile SingularAttribute<NguoiDung, String> pwd;
    public static volatile SingularAttribute<NguoiDung, String> username;
    public static volatile CollectionAttribute<NguoiDung, QuyenSach> quyenSachCollection;

}