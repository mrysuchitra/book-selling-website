package entity;

import entity.DaMua;
import entity.QuyenSach;
import entity.ReviewSach;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-06T19:20:57")
@StaticMetamodel(NguoiDung.class)
public class NguoiDung_ { 

    public static volatile SingularAttribute<NguoiDung, String> diaChi;
    public static volatile SingularAttribute<NguoiDung, String> soDienThoai;
    public static volatile CollectionAttribute<NguoiDung, ReviewSach> reviewSachCollection;
    public static volatile SingularAttribute<NguoiDung, String> ten;
    public static volatile SingularAttribute<NguoiDung, String> pwd;
    public static volatile CollectionAttribute<NguoiDung, DaMua> daMuaCollection;
    public static volatile SingularAttribute<NguoiDung, String> username;
    public static volatile CollectionAttribute<NguoiDung, QuyenSach> quyenSachCollection;

}