package bg.softuni.springbootconsoleapp.repository;

import bg.softuni.springbootconsoleapp.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByName(String categoryName);

}
