package IT16308_Assignment.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(name="name")
	private String name ;
	
	@Column(name = "image")
	private String image ;
	
	@Column(name = "price")
	private double price ;
	
	@Column(name = "created_date")
	private Date created_date ;
	
	@Column(name = "available")
	private int available ;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories category_id ;
}
