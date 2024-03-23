package elmo.group.utenti_elmo_microservizio.controller.protorype;

import elmo.group.utenti_elmo_microservizio.domain.User;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public interface UserAPI {
    @GetMapping
    public List<User> findAll();

    @PostMapping
    public User createUser(@RequestBody User user) throws BadRequestException;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) throws BadRequestException;

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) throws BadRequestException;

    @DeleteMapping("/{id}")
    public User deleteById(@PathVariable Long id) throws BadRequestException;
}
