package bg.softuni.springbootconsoleapp.repository;

import bg.softuni.springbootconsoleapp.domain.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {
}
