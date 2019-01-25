package pl.akolata.service.impl;

import org.springframework.stereotype.Service;
import pl.akolata.model.Ingredient;
import pl.akolata.model.Recipe;
import pl.akolata.service.RecipesService;

import java.util.*;

@Service
public class InMemoryRecipesService implements RecipesService {

    private static final List<Recipe> recipes;

    static {
        Set<Ingredient> sandwichIngredients = new HashSet<>();
        sandwichIngredients.add(new Ingredient(1L, "Bread", 2L));
        sandwichIngredients.add(new Ingredient(2L, "Ham", 10L));
        Recipe sandwichRecipe = new Recipe(1L, "sandwich", "Just a sandwich", sandwichIngredients);

        Set<Ingredient> burgerIngredients = new HashSet<>();
        burgerIngredients.add(new Ingredient(3L, "Bun", 1L));
        burgerIngredients.add(new Ingredient(4L, "Meat", 1L));
        burgerIngredients.add(new Ingredient(5L, "Salad", 2L));
        burgerIngredients.add(new Ingredient(6L, "Cheese", 2L));
        Recipe burgerRecipe = new Recipe(2L, "Burger", "Delicious burger", burgerIngredients);

        recipes = Arrays.asList(sandwichRecipe, burgerRecipe);
    }

    @Override
    public List<Recipe> findAllRecipes() {
        return recipes;
    }

    @Override
    public Optional<Recipe> findRecipeById(Long id) {
        return recipes
                .stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }
}
