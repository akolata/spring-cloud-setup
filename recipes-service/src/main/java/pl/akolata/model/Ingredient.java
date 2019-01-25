package pl.akolata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private Long id;
    private String name;
    private Long amount;
}
