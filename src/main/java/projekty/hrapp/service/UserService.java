package projekty.hrapp.service;

import org.springframework.stereotype.Service;
import projekty.hrapp.model.entity.User;
import projekty.hrapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer getUsersCount() {
        return Math.toIntExact(userRepository.count());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
    public void updateEloRating(long id, double rating) {
        User user = getUserById(id);
        user.setEloRating(rating);
                userRepository.save(user);
    }
}

