package polytech.cinema_server.service;

import polytech.cinema_server.model.Category;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface CategoryService {
    Category findByIdCategory(String id) throws EntityNotFoundException;

    List<Category> findAllCategory();
}