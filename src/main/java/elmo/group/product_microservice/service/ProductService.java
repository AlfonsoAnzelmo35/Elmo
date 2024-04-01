package elmo.group.product_microservice.service;

import elmo.group.product_microservice.domain.Product;
import elmo.group.product_microservice.repository.ProductRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){this.productRepository = productRepository;}
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product save(Product user) throws BadRequestException {
        if(user == null || user.getId() != null) {
            throw new BadRequestException("invalid user creation");
        }
        return productRepository.save(user) ;
    }

    public Product findById(Long id) throws BadRequestException {
        if(id == null)
            throw new BadRequestException("can't find by id");
        Optional<Product> product = productRepository.findById(id) ;
        if(!product.isPresent())
            throw new BadRequestException("user not found");

        return product.get();
    }

    public Product update(Long id, Product product) throws BadRequestException {
        Product product1 = findById(id) ;
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrezzo(product.getPrezzo());
        return save(product1) ;
    }

    public Product deleteById(Long id) throws BadRequestException {
        Product product = findById(id) ;
        productRepository.deleteById(id);
        return product;
    }

}
