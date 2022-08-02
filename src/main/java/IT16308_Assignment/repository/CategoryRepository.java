package IT16308_Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IT16308_Assignment.entities.Categories;



public interface CategoryRepository extends JpaRepository<Categories,Integer> {

}
