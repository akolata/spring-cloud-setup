package pl.akolata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.akolata.dto.RecipeResponse;
import pl.akolata.model.Ingredient;
import pl.akolata.model.Recipe;
import pl.akolata.proxy.AvailableIngredientsProxy;
import pl.akolata.service.RecipesService;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class RecipesController {

    private final RecipesService recipesService;
    private final AvailableIngredientsProxy availableIngredientsProxy;

    @Autowired
    public RecipesController(RecipesService recipesService, AvailableIngredientsProxy availableIngredientsProxy) {
        this.recipesService = recipesService;
        this.availableIngredientsProxy = availableIngredientsProxy;
    }

    @GetMapping(path = "/recipes")
    public List<Recipe> getAllRecipes() {
        log.info("Returning a list of all recipes");
        return recipesService.findAllRecipes();
    }

    @GetMapping(path = "/recipes/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RecipeResponse> getRecipe(@PathVariable Long id) {
        log.info("Request for a recipe with id {}", id);

        Optional<Recipe> recipeById = recipesService.findRecipeById(id);

        if (!recipeById.isPresent()) {
            log.info("Recipe with id {} not found.", id);
            return ResponseEntity.notFound().build();
        }

        Recipe recipe = recipeById.get();
        log.info("Recipe with id found: {}", recipe);

        List<Ingredient> availableIngredients = availableIngredientsProxy.getAvailableIngredients();
        log.info("Available ingredients: {}", availableIngredients.size());

        return ResponseEntity.ok().body(new RecipeResponse(recipe, availableIngredients));
    }
}
