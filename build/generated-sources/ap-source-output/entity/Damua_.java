package entity;

import entity.DaMuaPK;
import entity.NguoiDung;
import entity.QuyenSach;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-06T19:20:57")
@StaticMetamodel(DaMua.class)
public class DaMua_ { 

    public static volatile SingularAttribute<DaMua, Date> ngayMua;
    public static volatile SingularAttribute<DaMua, NguoiDung> nguoiDung1;
    public static volatile SingularAttribute<DaMua, QuyenSach> quyenSach;
    public static volatile SingularAttribute<DaMua, DaMuaPK> daMuaPK;

}