package elmo.group.order_microserivce.controller;

import elmo.group.order_microserivce.controller.protorype.OrderAPI;
import elmo.group.order_microserivce.domain.Order;
import elmo.group.order_microserivce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderController implements OrderAPI {
    private final OrderService orderService;
    @Override
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @Override
    public Order createProduct(Order order) throws BadRequestException {
        return orderService.save(order);
    }

    @Override
    public Order findById(Long id) throws BadRequestException {
        return orderService.findById(id);
    }

    @Override
    public Order update(Long id, Order order) throws BadRequestException {
        return orderService.update(id, order);
    }

    @Override
    public Order deleteById(Long id) throws BadRequestException {
        return orderService.deleteById(id);
    }
}
