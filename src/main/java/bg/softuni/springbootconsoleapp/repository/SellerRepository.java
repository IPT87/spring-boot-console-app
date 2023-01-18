package bg.softuni.springbootconsoleapp.repository;

import bg.softuni.springbootconsoleapp.domain.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {

    Optional<Seller> findSellerByFirstNameAndLastName(String firstName, String lastName);

}
