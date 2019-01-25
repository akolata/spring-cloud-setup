package pl.akolata.service;

import pl.akolata.model.Ingredient;

import java.util.List;

public interface ProductsService {

    List<Ingredient> findAvailableIngredients();
}
