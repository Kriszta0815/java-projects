package springapps.scheduled_user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User save() {
        User user = new User("Bobo" + new Random().nextInt(1000));
        return  userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
