package pl.akolata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private Long id;
    private String name;
    private Long amount;
}
