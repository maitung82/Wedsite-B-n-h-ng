package IT16308_Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import IT16308_Assignment.entities.Accounts;



public interface AccountRepository extends JpaRepository<Accounts,Integer> {
	
		@Query(name = "account.findByEmail")
		public Accounts findByEmail(@Param("email") String email) ;
}
