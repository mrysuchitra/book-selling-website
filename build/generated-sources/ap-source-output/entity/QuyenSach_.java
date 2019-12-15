package entity;

import entity.Anh;
import entity.DaMua;
import entity.DauSach;
import entity.NguoiDung;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-14T21:55:30")
@StaticMetamodel(QuyenSach.class)
public class QuyenSach_ { 

    public static volatile CollectionAttribute<QuyenSach, Anh> anhCollection;
    public static volatile SingularAttribute<QuyenSach, Date> ngayDang;
    public static volatile SingularAttribute<QuyenSach, String> tinhTrang;
    public static volatile SingularAttribute<QuyenSach, Boolean> conHang;
    public static volatile SingularAttribute<QuyenSach, Integer> maQuyenSach;
    public static volatile SingularAttribute<QuyenSach, DauSach> maDauSach;
    public static volatile CollectionAttribute<QuyenSach, DaMua> daMuaCollection;
    public static volatile SingularAttribute<QuyenSach, NguoiDung> nguoiBan;

}