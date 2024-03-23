package elmo.group.utenti_elmo_microservizio.controller;

import elmo.group.utenti_elmo_microservizio.controller.protorype.UserAPI;
import elmo.group.utenti_elmo_microservizio.domain.User;
import elmo.group.utenti_elmo_microservizio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserController implements UserAPI {
    private final UserService userService;

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public User createUser(User user) throws BadRequestException {
        return userService.save(user);
    }

    @Override
    public User findById(Long id) throws BadRequestException {
        return userService.findById(id);
    }

    @Override
    public User update(Long id, User user) throws BadRequestException {
        return userService.update(id, user);
    }

    @Override
    public User deleteById(Long id) throws BadRequestException {
        return userService.deleteById(id);
    }
}
