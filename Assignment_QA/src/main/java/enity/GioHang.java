package enity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "GioHang")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class GioHang implements Serializable {
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    @Column(name = "Id")
    private  String id;

    @ManyToOne
    @JoinColumn(name="IdKH",referencedColumnName = "Id")
    private KhachHang khachHang;

    @Column(name="IdNV")
    private  String idNV;

    @Column(name="Ma")
    private  String ma;

    @Column(name="NgayTao")
    private Date ngayTao;

    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name="TenNguoiNhan")
    private String tenNguoiNhan ;

    @Column(name="DiaChi")
    private String diaChi ;

    @Column(name="Sdt")
    private String sdt ;

    @Column(name="TinhTrang")
    private int tinhTrang ;
}
