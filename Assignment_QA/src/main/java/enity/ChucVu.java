package enity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ChucVu")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChucVu {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idCV;

    @Column(name = "Ma")
    private String maCV;

    @Column(name = "Ten")
    private String tenCV;

    @Override
    public String toString() {
        return "MauSac{" +
                "id='" + idCV + '\'' +
                ", Ma='" + maCV + '\'' +
                ", ten='" + tenCV + '\'' +
                '}';
    }
}
