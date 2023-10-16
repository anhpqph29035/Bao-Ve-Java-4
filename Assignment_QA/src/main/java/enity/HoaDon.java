package enity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;

@Table(name = "HoaDon")
@Entity
@Getter
@Setter
@ToString
public class HoaDon implements Serializable {
    @Id
    @GenericGenerator(name="generator",strategy = "guid",parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private  String id;

    @ManyToOne
    @JoinColumn(name="IdKH",referencedColumnName = "Id")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name="IdNV",referencedColumnName = "Id")
    private NhanVien nhanVien;



    @Column(name="Ma")
    private  String ma;

    @Column(name="NgayTao")
    private Date ngayTao;

    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name="TinhTrang")
    private int tinhTrang ;

    @Column(name="TenNguoiNhan")
    private String tenNguoiNhan ;

    @Column(name="DiaChi")
    private String diaChi ;

    @Column(name="Sdt")
    private String sdt ;

    public HoaDon() {
    }

    public HoaDon(String id, KhachHang khachHang, NhanVien nhanVien, String ma, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, String diaChi, String sdt) {
        this.id = id;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }
}
