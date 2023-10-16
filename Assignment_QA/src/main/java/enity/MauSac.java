package enity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "MauSac")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MauSac {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idMS;

    @Column(name = "Ma")
    private String maMS;

    @Column(name = "Ten")
    private String tenMS;

    @Override
    public String toString() {
        return "MauSac{" +
                "id='" + idMS + '\'' +
                ", Ma='" + maMS + '\'' +
                ", ten='" + tenMS + '\'' +
                '}';
    }
}
