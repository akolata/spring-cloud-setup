package pl.akolata.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akolata.model.Ingredient;

import java.util.List;

@FeignClient(name = "api-gateway", configuration = FeignConfiguration.class)
@RibbonClient(name = "products-service")
public interface AvailableIngredientsProxy {

    @GetMapping(path = "/api/products")
    List<Ingredient> getAvailableIngredients();
}
