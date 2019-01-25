package pl.akolata.service.impl;

import org.springframework.stereotype.Service;
import pl.akolata.model.Ingredient;
import pl.akolata.service.ProductsService;

import java.util.Arrays;
import java.util.List;

@Service
public class InMemoryProductsService implements ProductsService {

    private static final List<Ingredient> availableIngredients;

    static {
        availableIngredients = Arrays.asList(
                new Ingredient(1L, "Bread", 200L),
                new Ingredient(2L, "Ham", 500L),
                new Ingredient(3L, "Meat", 50L)
        );
    }

    @Override
    public List<Ingredient> findAvailableIngredients() {
        return availableIngredients;
    }
}
