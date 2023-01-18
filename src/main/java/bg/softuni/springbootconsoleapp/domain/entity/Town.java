package bg.softuni.springbootconsoleapp.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "towns")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Town extends BaseEntity {

    private String name;

}
