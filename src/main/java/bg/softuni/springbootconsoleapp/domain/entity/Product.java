package bg.softuni.springbootconsoleapp.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {

    @Column(name = "best_before")
    private LocalDate bestBefore;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Size(min = 2)
    @Column(nullable = false)
    private String name;

    @Min(value = 1)
    @Column(precision = 19, scale = 2)
    private BigDecimal price;

    @ManyToOne
    private Category category;

}
