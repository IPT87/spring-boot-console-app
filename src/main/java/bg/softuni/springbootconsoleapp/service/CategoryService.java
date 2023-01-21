package bg.softuni.springbootconsoleapp.service;

import bg.softuni.springbootconsoleapp.domain.entity.Category;

public interface CategoryService {

    boolean isCategoryImported(String categoryName);
    void importCategory(String categoryName);
    Category getCategoryByName(String categoryName);

}
