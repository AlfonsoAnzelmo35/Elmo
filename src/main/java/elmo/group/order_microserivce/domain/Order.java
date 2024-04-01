package elmo.group.order_microserivce.domain;

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
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idUser, idProduct;
    private GregorianCalendar dateOfOrder;
}
