package pl.akolata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class Recipe {
    private Long id;
    private String name;
    private String description;
    private Set<Ingredient> ingredients = new HashSet<>();
}
