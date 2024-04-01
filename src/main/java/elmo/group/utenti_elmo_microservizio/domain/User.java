package elmo.group.utenti_elmo_microservizio.domain;

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
public class User {
    public User(String username, String password, String email, GregorianCalendar dateOfBirth) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username, password, email;
    private GregorianCalendar dateOfBirth;
}
