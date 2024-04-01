package elmo.group.utenti_elmo_microservizio.controller.protorype;

import elmo.group.utenti_elmo_microservizio.domain.User;
import org.apache.coyote.BadRequestException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public interface UserAPI {
    @GetMapping
    public List<User> findAll();

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public User createUser(@RequestBody User user) throws BadRequestException;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) throws BadRequestException;

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) throws BadRequestException;

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public User deleteById(@PathVariable Long id) throws BadRequestException;
}
