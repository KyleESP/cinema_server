package polytech.cinema_server.service;

import polytech.cinema_server.exception.ApiException;
import polytech.cinema_server.model.User;

import javax.persistence.EntityNotFoundException;

public interface UserService {

    User findByIdUser(Integer id) throws EntityNotFoundException;

    User findByEmailUser(String email) throws EntityNotFoundException;

    User findByEmailAndPasswordUser(String email, String password) throws EntityNotFoundException, ApiException;
}