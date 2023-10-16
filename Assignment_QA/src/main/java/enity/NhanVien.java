package enity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Table(name = "NhanVien")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idNV;

    @Column(name="Ma")
    private String maNV;

    @Column(name = "Ten")
    private String tenNV;

    @Column(name = "TenDem")
    private String tenDemNV;

    @Column(name = "Ho")
    private String hoNV;

    @Column(name = "GioiTinh")
    private String gtNV;

    @Column(name = "NgaySinh")
    private Date ngaySinhNV;

    @Column(name = "DiaChi")
    private String diaChiNV;

    @Column(name = "SDT")
    private String sdtNV;

    @Column(name = "MatKhau")
    private String matKhauNV;

    @ManyToOne
    @JoinColumn(name="idCH")
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name="idCV")
    private ChucVu chucVu;

    @Column(name = "trangThai")
    private int ttNV;
}
