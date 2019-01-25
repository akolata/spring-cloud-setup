package pl.akolata.service;

import pl.akolata.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipesService {

    List<Recipe> findAllRecipes();

    Optional<Recipe> findRecipeById(Long id);
}
