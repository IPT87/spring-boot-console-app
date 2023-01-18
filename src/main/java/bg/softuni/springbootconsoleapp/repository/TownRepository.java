package bg.softuni.springbootconsoleapp.repository;

import bg.softuni.springbootconsoleapp.domain.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, String> {
}
