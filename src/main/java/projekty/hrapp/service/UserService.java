package projekty.hrapp.service;

import org.springframework.stereotype.Service;
import projekty.hrapp.model.dto.UserRequest;
import projekty.hrapp.model.dto.UserResponse;
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

    public Integer getUsersNumber() {
        return Math.toIntExact(userRepository.count());
    }

    public List<UserResponse> getAll() {
        Iterable<User> users = userRepository.findAll();
        List<UserResponse> response = new ArrayList<>();
        for (User user : users) {
            response.add(new UserResponse(user.getId().intValue(), user.getUsername(), user.getEmail()));
        }
        return response;
    }

    public UserResponse get(int ID) {
        try {
            User user = userRepository.findById(ID).orElseThrow(() -> new NoSuchElementException("User not found"));

            return new UserResponse(user.getId().intValue(), user.getUsername(), user.getEmail());
        } catch (NoSuchElementException error) {
            return null;
        }
    }

    public void add(UserRequest request) {
        User user = new User();
        user.setUsername(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);
    }

    public void Remove(int ID) {
        userRepository.deleteById(ID);

    }

    public void Update(UserRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(() -> new NoSuchElementException("User not found"));

        if (request.getName() != null) {
            user.setUsername(request.getName());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }

        userRepository.save(user);
    }
}

