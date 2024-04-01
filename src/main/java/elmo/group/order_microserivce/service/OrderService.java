package elmo.group.order_microserivce.service;

import elmo.group.order_microserivce.domain.Order;
import elmo.group.order_microserivce.repository.OrderRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository){this.orderRepository = orderRepository;}
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order save(Order user) throws BadRequestException {
        if(user == null || user.getId() != null) {
            throw new BadRequestException("invalid user creation");
        }
        return orderRepository.save(user) ;
    }

    public Order findById(Long id) throws BadRequestException {
        if(id == null)
            throw new BadRequestException("can't find by id");
        Optional<Order> order = orderRepository.findById(id) ;
        if(!order.isPresent())
            throw new BadRequestException("user not found");

        return order.get();
    }

    public Order update(Long id, Order order) throws BadRequestException {
        Order order1 = findById(id) ;
        order1.setIdUser(order.getIdUser());
        order1.setIdProduct(order.getIdProduct());
        order1.setDateOfOrder(order.getDateOfOrder());
        return save(order1) ;
    }

    public Order deleteById(Long id) throws BadRequestException {
        Order product = findById(id) ;
        orderRepository.deleteById(id);
        return product;
    }

}
