package IT16308_Assignment.entities;

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
@Table(name="order_details")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
	
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Orders order_id ;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Products  product_id ;
	
	@Column(name="price")
	private double price ;
	
	@Column(name="quantity")
	private int quantity ;
}
