package enity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CuaHang")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CuaHang {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idCH;

    @Column(name = "Ma")
    private String maCH;

    @Column(name = "Ten")
    private String tenCH;

    @Column(name = "DiaChi")
    private String diaChiCH;

    @Column(name = "ThanhPho")
    private String thanhPhoCH;

    @Column(name = "QuocGia")
    private String quocGiaCH;

    @Override
    public String toString() {
        return "CuaHang{" +
                "idCH='" + idCH + '\'' +
                ", maCH='" + maCH + '\'' +
                ", tenCH='" + tenCH + '\'' +
                ", diaChiCH='" + diaChiCH + '\'' +
                ", thanhPhoCH='" + thanhPhoCH + '\'' +
                ", quocGiaCH='" + quocGiaCH + '\'' +
                '}';
    }
}
