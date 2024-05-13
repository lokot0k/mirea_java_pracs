package demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "creation_date")
    public String creationDate;

    @Column(name = "type")
    public String type;

    @OneToMany(mappedBy = "building")
    private List<Address> addresses;

    public Building(String creationDate, String type) {
        this.creationDate = creationDate;
        this.type = type;
    }
}
