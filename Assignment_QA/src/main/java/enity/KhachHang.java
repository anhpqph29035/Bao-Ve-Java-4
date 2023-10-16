package enity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Table(name = "KhachHang")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idKH;

    @Column(name = "Ma")
    private String maKH;

    @Column(name = "Ten")
    private String tenKH;

    @Column(name = "TenDem")
    private String tenDemKH;

    @Column(name = "Ho")
    private String hoKH;

    @Column(name = "NgaySinh")
    private Date ngaySinhKH;

    @Column(name = "SDT")
    private String sdtKH;

    @Column(name = "DiaChi")
    private String diaChiKH;

    @Column(name = "ThanhPho")
    private String thanhPhoKH;

    @Column(name = "QuocGia")
    private String quocGiaKH;

    @Column(name = "MatKhau")
    private String matKhauKH;
}
