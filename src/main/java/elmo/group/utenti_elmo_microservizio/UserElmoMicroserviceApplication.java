package elmo.group.utenti_elmo_microservizio;

import elmo.group.utenti_elmo_microservizio.domain.User;
import elmo.group.utenti_elmo_microservizio.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.GregorianCalendar;

@SpringBootApplication
public class UserElmoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserElmoMicroserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService){
		return args -> {
			userService.save(new User("Aniello", "Aniello", "nello1965@gmail.com", new GregorianCalendar()));
		};
	}
}
