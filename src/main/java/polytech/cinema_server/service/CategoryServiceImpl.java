package polytech.cinema_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytech.cinema_server.model.Category;
import polytech.cinema_server.repository.CategoryRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByIdCategory(String id) throws EntityNotFoundException {
        return categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category with code " + id + " not found.")
        );
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

}