package entity;

import entity.Anh;
import entity.Damua;
import entity.DauSach;
import entity.NguoiDung;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T23:51:30")
@StaticMetamodel(QuyenSach.class)
public class QuyenSach_ { 

    public static volatile CollectionAttribute<QuyenSach, Damua> damuaCollection;
    public static volatile CollectionAttribute<QuyenSach, Anh> anhCollection;
    public static volatile SingularAttribute<QuyenSach, Date> ngayDang;
    public static volatile SingularAttribute<QuyenSach, String> tinhTrang;
    public static volatile SingularAttribute<QuyenSach, Boolean> conHang;
    public static volatile SingularAttribute<QuyenSach, String> maQuyenSach;
    public static volatile SingularAttribute<QuyenSach, DauSach> maDauSach;
    public static volatile SingularAttribute<QuyenSach, NguoiDung> nguoiBan;

}