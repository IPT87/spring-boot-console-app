package bg.softuni.springbootconsoleapp.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shops")
@AllArgsConstructor
@Getter
@Setter
public class Shop extends BaseEntity {

    public Shop() {
        this.products = new ArrayList<>();
        this.sellers = new ArrayList<>();
    }

    @Size(min = 2)
    @Column(unique = true, nullable = false)
    private String address;

    @Size(min = 2)
    @Column
    private String name;

    @ManyToOne
    private Town town;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> products;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Seller> sellers;

}
