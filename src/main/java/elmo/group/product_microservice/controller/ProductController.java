package elmo.group.product_microservice.controller;

import elmo.group.product_microservice.controller.protorype.ProductAPI;
import elmo.group.product_microservice.domain.Product;
import elmo.group.product_microservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductController implements ProductAPI {
    private final ProductService productService;

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public Product createProduct(Product product) throws BadRequestException {
        return productService.save(product);
    }

    @Override
    public Product findById(Long id) throws BadRequestException {
        return productService.findById(id);
    }

    @Override
    public Product update(Long id, Product product) throws BadRequestException {
        return productService.update(id, product);
    }

    @Override
    public Product deleteById(Long id) throws BadRequestException {
        return productService.deleteById(id);
    }
}
