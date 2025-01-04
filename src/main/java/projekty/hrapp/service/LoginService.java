package projekty.hrapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import projekty.hrapp.model.dto.RegisterRequest;
import projekty.hrapp.model.dto.LoginRequest;
import projekty.hrapp.model.dto.LoginResponse;
import projekty.hrapp.model.entity.UserType;
import projekty.hrapp.security.Passwordutil;
import projekty.hrapp.security.JWTUtil;
import projekty.hrapp.model.entity.User;
import projekty.hrapp.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;

@Service
public class LoginService {
    private UserRepository userRepository;
    private UserRepository userTypeRepository;

    public LoginService(UserRepository userRepository, UserRepository userTypeRepository, JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
        this.jwtUtil = jwtUtil;
    }

    @Autowired
    private JWTUtil jwtUtil;

    public LoginResponse login(LoginRequest request) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(request.getLogin()));
        if (user.isEmpty()) {
            return null;
        }
        String hashPassword = Passwordutil.hashPassword(request.getPassword(), user.get().getSalt());
        if (Objects.equals(hashPassword, user.get().getPassword())) {
            LoginResponse loginResponse = new LoginResponse(jwtUtil.generateToken(request.getLogin()));
            return loginResponse;
        }
        return null;
    }

    public String register(RegisterRequest registerRequest) {
        if (userRepository.findByUsername(registerRequest.getLogin()) != null) {
            return ("User already exists with login: ");
        }

        try {
            String salt = Passwordutil.generateSalt();
            User user = new User();
            user.setUsername(registerRequest.getLogin());
            user.setPassword(Passwordutil.hashPassword(registerRequest.getPassword(), salt));
            user.setSalt(salt);
            UserType userType = userTypeRepository.findById(registerRequest.getUserType()).orElseThrow(() -> new RuntimeException("invalid usertype")).getUserType();
            user.setUserType(userType);
            userRepository.save(user);
            return "registration successful";
        } catch (Exception e) {
            return ("registration failed" + e.getMessage());
        }

    }
}