package elmo.group.product_microservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.GregorianCalendar;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Product {
    public Product(String name, String description, Double prezzo) {
        this.name = name;
        this.description = description;
        this.prezzo = prezzo;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, description;
    private Double prezzo;
}
