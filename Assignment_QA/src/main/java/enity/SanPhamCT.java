package enity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ChiTietSP")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamCT implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idCTSP;

    @Column(name = "Anh")
    private String anhCTSP;

    @ManyToOne
    @JoinColumn(name="idSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name="idNSX")
    private NSX nsxCTSP;

    @ManyToOne
    @JoinColumn(name="idMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name="idDongSP")
    private DongSP dongCTSP;

    @Column(name="namBH")
    private int namBH;

    @Column(name="MoTa")
    private String moTa;

    @Column(name="SoLuongTon")
    private int soLuongTon;

    @Column(name="GiaNhap")
    private BigDecimal giaNhap;

    @Column(name="GiaBan")
    private BigDecimal giaBan;
}
