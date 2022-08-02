package IT16308_Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IT16308_Assignment.entities.OrderDetails;


public interface OrderDetailRepository extends JpaRepository<OrderDetails, Integer> {

}
