package bg.softuni.springbootconsoleapp.service.impl;

import bg.softuni.springbootconsoleapp.domain.dto.CategoryDto;
import bg.softuni.springbootconsoleapp.domain.entity.Category;
import bg.softuni.springbootconsoleapp.repository.CategoryRepository;
import bg.softuni.springbootconsoleapp.service.CategoryService;
import bg.softuni.springbootconsoleapp.utills.Messages;
import bg.softuni.springbootconsoleapp.utills.ValidationUtilsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;
    private final ValidationUtilsImpl validator;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper, ValidationUtilsImpl validator) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean isCategoryImported(String categoryName) {
        return this.categoryRepository.findByName(categoryName).isPresent();
    }

    @Override
    public void importCategory(String categoryName) {
        if (isCategoryImported(categoryName)) {
            System.out.println(Messages.CATEGORY_EXISTS);
        } else {

            CategoryDto categoryDto = new CategoryDto(categoryName);
            Category category = mapper.map(categoryDto, Category.class);
            boolean isValid = validator.isValid(category);

            if (isValid) {
                this.categoryRepository.save(mapper.map(categoryDto, Category.class));
                System.out.println(Messages.SUCCESSFULLY_ADDED_CATEGORY);
            } else {
                System.out.println(Messages.INVALID_CATEGORY_NAME);
            }

        }

    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return this.categoryRepository.findByName(categoryName).orElse(null);
    }
}
