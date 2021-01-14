package polytech.cinema_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import polytech.cinema_server.exception.ApiException;
import polytech.cinema_server.model.User;
import polytech.cinema_server.repository.UserRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByIdUser(Integer id) throws EntityNotFoundException {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found.")
        );
    }

    @Override
    public User findByEmailUser(String email) throws EntityNotFoundException {
        return userRepository.findFirstByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("User with email " + email + " not found.")
        );
    }

    @Override
    public User findByEmailAndPasswordUser(String email, String password) throws EntityNotFoundException, ApiException {
        User userFound = findByEmailUser(email);

        if (!passwordEncoder.matches(password, userFound.getPassword())) {
            throw new ApiException(HttpStatus.UNAUTHORIZED, "AuthWrongPassword",
                    "Password does not match for user with email " + email + ".");
        }

        return userFound;
    }
}