package enity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "NSX")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NSX {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idNSX;

    @Column(name = "Ma")
    private String maNSX;

    @Column(name = "Ten")
    private String tenNSX;

    @Override
    public String toString() {
        return "NSX{" +
                "id='" + idNSX + '\'' +
                ", Ma='" + maNSX + '\'' +
                ", ten='" + tenNSX + '\'' +
                '}';
    }
}
