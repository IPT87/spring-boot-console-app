package bg.softuni.springbootconsoleapp.service;

public interface CategoryService {

    boolean isCategoryImported(String categoryName);
    void importCategory(String categoryName);

}
