package elmo.group.order_microserivce.controller.protorype;

import elmo.group.order_microserivce.domain.Order;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public interface OrderAPI {
    @GetMapping
    public List<Order> findAll();

    @PostMapping
    public Order createProduct(@RequestBody Order order) throws BadRequestException;

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) throws BadRequestException;

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) throws BadRequestException;

    @DeleteMapping("/{id}")
    public Order deleteById(@PathVariable Long id) throws BadRequestException;
}
