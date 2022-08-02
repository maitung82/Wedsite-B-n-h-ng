package IT16308_Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IT16308_Assignment.entities.Orders;



public interface OrderRepository extends JpaRepository<Orders,Integer>  {

}
