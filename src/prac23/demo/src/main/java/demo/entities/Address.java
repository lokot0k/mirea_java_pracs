package demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "address_text")
    public String addressText;

    @Column(name = "zip_code")
    public String zipCode;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "building_id")
    public Building building;

    public Address(String addressText, String zipCode) {
        this.addressText = addressText;
        this.zipCode = zipCode;
    }
}
