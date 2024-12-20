package projekty.hrapp.service;

import org.springframework.stereotype.Service;
import pl.javastart.hrm3.Model.Pracownik;
import pl.javastart.hrm3.Repozytorium.Pracownikrepozytorium;
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

    public UserService(UserService userService) {
        this.userRepository = userService.userRepository;
    }

    public Integer getUsersnumber() {
        return Math.toIntExact(userRepository.count());
    }

    public List<UserResponse> getAll() {
        List<User> pracownicy = userRepository.findAll();
        List<UserResponse> response = new ArrayList<>();
        for (User pracownik : pracownicy) {
            response.add(new UserResponse((), pracownik.getImie(), pracownik.getNazwisko(), pracownik.getDataUrodzenia()));
        }
        return response;
    }

    public UserResponse get(int ID) {
        try {
            Pracownik pracownik = pracownikrepozytorium.findById(ID).get();

            return new UserResponse(pracownik.getID(), pracownik.getImie(), pracownik.getNazwisko(), pracownik.getDataUrodzenia());
        } catch (NoSuchElementException error) {
            return null;
        }
    }

    public void Add(UserRequest request) {
        Pracownik pracownik = new Pracownik(request.getNazwisko(), request.getImie(), request.getDataurodzenia(), request.getStawka());
        pracownikrepozytorium.saveAndFlush(pracownik);
    }

    public void Remove(int ID) {
        pracownikrepozytorium.deleteById(ID);

    }

    public void Update(UserRequest request) {
        Pracownik pracownik = pracownikrepozytorium.findById(request.getId()).get();
        if (request.getImie() != null) {
            pracownik.setImie(request.getImie());
        }
        if (request.getNazwisko() != null) {
            pracownik.setNazwisko(request.getNazwisko());
        }
        if (request.getDataurodzenia() != null) {
            pracownik.setDataUrodzenia(request.getDataurodzenia());
        }

        pracownikrepozytorium.saveAndFlush(pracownik);
    }
}

