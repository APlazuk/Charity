package pl.coderslab.charity.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.services.CategoryService;

import java.util.List;

@Service
@Transactional
public class DefaultCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
