package pl.akolata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.akolata.model.Ingredient;
import pl.akolata.service.ProductsService;

import java.util.List;

@RestController
@Slf4j
public class AvailableProductsController {

    private final ProductsService productsService;

    @Autowired
    public AvailableProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Ingredient> getAvailableProducts() {
        log.info("Request for available products");
        return productsService.findAvailableIngredients();
    }
}
