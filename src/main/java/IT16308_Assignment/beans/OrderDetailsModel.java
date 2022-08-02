package IT16308_Assignment.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import IT16308_Assignment.entities.Orders;
import IT16308_Assignment.entities.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsModel {
	private int id ;
	
	
	private Orders order_id ;
	
	private Products  product_id ;
	@NotNull(message = "Không được để trống")
	private double price ;
	@NotNull(message = "Không được để trống")
	private int quantity ;
}
