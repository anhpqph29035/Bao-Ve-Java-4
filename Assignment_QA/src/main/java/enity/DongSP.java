package enity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DongSP")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DongSP {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idDSP;

    @Column(name = "Ma")
    private String maDSP;

    @Column(name = "Ten")
    private String tenDSP;

    @Override
    public String toString() {
        return "DongSP{" +
                "id='" + idDSP + '\'' +
                ", Ma='" + maDSP + '\'' +
                ", ten='" + tenDSP + '\'' +
                '}';
    }
}
