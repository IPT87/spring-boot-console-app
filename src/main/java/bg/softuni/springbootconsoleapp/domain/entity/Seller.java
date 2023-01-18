package bg.softuni.springbootconsoleapp.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "sellers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seller extends BaseEntity {

    @Size(min = 2)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 2)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Min(value = 18)
    @Column(nullable = false)
    private int age;

    @Min(value = 1)
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal salary;

    @ManyToOne
    private Shop shop;

    @Column(name = "manager_id")
    private String managerId;

}
