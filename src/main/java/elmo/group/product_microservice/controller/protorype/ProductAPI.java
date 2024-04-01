package elmo.group.product_microservice.controller.protorype;

import elmo.group.product_microservice.domain.Product;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public interface ProductAPI {
    @GetMapping
    public List<Product> findAll();

    @PostMapping
    public Product createProduct(@RequestBody Product product) throws BadRequestException;

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) throws BadRequestException;

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) throws BadRequestException;

    @DeleteMapping("/{id}")
    public Product deleteById(@PathVariable Long id) throws BadRequestException;
}
