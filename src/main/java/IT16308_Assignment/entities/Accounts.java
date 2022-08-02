package IT16308_Assignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="accounts")


@NamedQuery(name = "account.findByEmail" , 
		query = "SELECT acc FROM Accounts acc WHERE acc.email = :email"
		)
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ;
	
	
	@Column(name = "username")
	private String username ;
	
	
	@Column(name="password")
	private String password ;
	
	
	@Column(name="fullname")
	private String fullname ;
	
	
	@Column(name = "email")
	private String email ;
	
	
	@Column(name="photo")
	private String photo ;
	
	
	@Column(name="activated")
	private int activated ;
	
	
	@Column(name="admin")
	private int admin ;
}
