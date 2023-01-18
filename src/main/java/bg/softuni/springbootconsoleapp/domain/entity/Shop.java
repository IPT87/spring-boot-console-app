package bg.softuni.springbootconsoleapp.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "shops")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Shop extends BaseEntity {

    @Size(min = 2)
    @Column(unique = true, nullable = false)
    private String address;

    @Size(min = 2)
    @Column
    private String name;

    @ManyToOne
    private Town town;

    @ManyToMany
    private List<Product> products;

}
