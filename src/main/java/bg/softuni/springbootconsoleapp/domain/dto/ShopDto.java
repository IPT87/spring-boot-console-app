package bg.softuni.springbootconsoleapp.domain.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShopDto {

    @Size(min = 2)
    private String address;

    @Size(min = 2)
    private String name;

}
