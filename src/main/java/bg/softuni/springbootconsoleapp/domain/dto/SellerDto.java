package bg.softuni.springbootconsoleapp.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SellerDto {

    @Size(min = 2)
    private String firstName;

    @Size(min = 2)
    private String lastName;

    @Min(value = 18)
    private int age;

    @Min(value = 1)
    private BigDecimal salary;

}
