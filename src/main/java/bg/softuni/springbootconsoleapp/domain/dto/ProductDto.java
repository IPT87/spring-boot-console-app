package bg.softuni.springbootconsoleapp.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

    private LocalDate bestBefore;

    @Size(min = 2)
    private String name;

    @Min(value = 1)
    private BigDecimal price;

}
