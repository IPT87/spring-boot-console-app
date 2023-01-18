package bg.softuni.springbootconsoleapp.repository;

import bg.softuni.springbootconsoleapp.domain.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, String> {

    Optional<Town> findTownByName(String townName);

}
