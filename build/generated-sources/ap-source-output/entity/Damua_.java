package entity;

import entity.DamuaPK;
import entity.NguoiDung;
import entity.QuyenSach;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T23:51:30")
@StaticMetamodel(Damua.class)
public class Damua_ { 

    public static volatile SingularAttribute<Damua, NguoiDung> nguoiDung1;
    public static volatile SingularAttribute<Damua, Date> ngaymua;
    public static volatile SingularAttribute<Damua, DamuaPK> damuaPK;
    public static volatile SingularAttribute<Damua, QuyenSach> quyenSach;

}