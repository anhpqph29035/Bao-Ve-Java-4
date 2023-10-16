package enity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "GioHangChiTiet")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GioHangChiTiet implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "IdGioHang",referencedColumnName = "Id")
    private GioHang gioHang;
    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP",referencedColumnName = "Id")
    private SanPhamCT chiTietSP;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonGia")
    private BigDecimal donGia;
    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;
}
