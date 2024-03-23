package elmo.group.utenti_elmo_microservizio.service;

import elmo.group.utenti_elmo_microservizio.domain.User;
import elmo.group.utenti_elmo_microservizio.repository.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){this.userRepository = userRepository;}
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(User user) throws BadRequestException {
        if(user == null || user.getId() != null) {
            throw new BadRequestException("invalid user creation");
        }
        return userRepository.save(user) ;
    }

    public User findById(Long id) throws BadRequestException {
        if(id == null)
            throw new BadRequestException("can't find by id");
        Optional<User> user = userRepository.findById(id) ;
        if(!user.isPresent())
            throw new BadRequestException("user not found");

        return user.get();
    }

    public User update(Long id, User user) throws BadRequestException {
        User user1 = findById(id) ;
        user1.setEmail(user.getEmail());
        user1.setUsername(user.getEmail());
        user1.setDateOfBirth(user.getDateOfBirth());
        return save(user1) ;
    }

    public User deleteById(Long id) throws BadRequestException {
        User user = findById(id) ;
        userRepository.deleteById(id);
        return user;
    }

}
