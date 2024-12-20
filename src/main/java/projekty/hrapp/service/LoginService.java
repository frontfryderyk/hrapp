package projekty.hrapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.hrm3.Model.Uzytkownik;
import pl.javastart.hrm3.Model.Uzytkowniktyp;
import pl.javastart.hrm3.Repozytorium.Uzytkownikrepozytorium;
import pl.javastart.hrm3.Repozytorium.Uzytkowniktyprepozytorium;
import pl.javastart.hrm3.Request.RegisterRequest;


import projekty.hrapp.model.dto.LoginRequest;
import projekty.hrapp.model.dto.LoginResponse;
import projekty.hrapp.security.Passwordutil;
import projekty.hrapp.security.JWTUtil;
import projekty.hrapp.model.entity.User;
import projekty.hrapp.repository.UserRepository;

import java.util.Objects;

@Service
public class LoginService {
    private UserRepository userRepository;
    private UserRepository uzytkowniktyprepozytorium;

    public LoginService(UserRepository uzytkownikrepozytorium, UserRepository uzytkowniktyprepozytorium) {
        this.userRepository = uzytkownikrepozytorium;
        this.uzytkowniktyprepozytorium = uzytkowniktyprepozytorium;
    }

    @Autowired
    private JWTUtil jwtUtil;

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByLogin(request.getLogin());
        if (user == null) {
            return null;
        }
        String hashPassword = Passwordutil.hashPassword(request.getHaslo(), user.getSalt());
        if (Objects.equals(hashPassword, user.getPassword())) {
            LoginResponse loginResponse = new LoginResponse(jwtUtil.generateToken(request.getLogin()));
            return loginResponse;
        }
        return null;
    }

    public String register(RegisterRequest registerRequest) {
        User uzytkownik = uzytkownikrepozytorium.findByLogin(registerRequest.getLogin());
        if (uzytkownik != null) {
            return ("User already exists with login: " + uzytkownik.getLogin());
        }

        String passwordregex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if (registerRequest.getPassword().matches(passwordregex)) {
            String salt = Passwordutil.generateSalt();
            User nowyuzytkownik = new User();
            nowyuzytkownik.setUsername(registerRequest.getLogin());
            nowyuzytkownik.setPassword(Passwordutil.hashPassword(registerRequest.getPassword(), salt));
            nowyuzytkownik.setSalt(salt);
            Uzytkowniktyp uzytkowniktyp = uzytkowniktyprepozytorium.findById(registerRequest.getTyp()).get();
            nowyuzytkownik.setUzytkowniktyp(uzytkowniktyp);
            uzytkownikrepozytorium.saveAndFlush(nowyuzytkownik);
            return "Successfully registered with login: " + nowyuzytkownik.getLogin();
        } else {
            return ("Passwords do not match");
        }


    }
}