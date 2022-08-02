package IT16308_Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IT16308_Assignment.entities.Products;



public interface ProductRepository extends JpaRepository<Products,Integer> {

}
