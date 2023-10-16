package enity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SanPham")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idSP;

    @Column(name = "Anh")
    private String anhSP;

    @Column(name = "Ma")
    private String maSP;

    @Column(name = "Ten")
    private String tenSP;

    @Override
    public String toString() {
        return "SanPham{" +
                "id='" + idSP + '\'' +
                ", anh='" + anhSP + '\'' +
                ", Ma='" + maSP + '\'' +
                ", ten='" + tenSP + '\'' +
                '}';
    }
}
