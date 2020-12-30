package polytech.cinema_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import polytech.cinema_server.model.Category;
import polytech.cinema_server.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> findByIdCategory(@PathVariable("id") String id) {
        Category category = categoryService.findByIdCategory(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categories = categoryService.findAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}

