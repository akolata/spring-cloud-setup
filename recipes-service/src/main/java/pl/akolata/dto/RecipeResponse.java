package pl.akolata.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import pl.akolata.model.Ingredient;
import pl.akolata.model.Recipe;

import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class RecipeResponse {
    private final Recipe recipe;
    private final List<Ingredient> availableIngredients;
}
