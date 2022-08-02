package IT16308_Assignment.beans;




import java.sql.Date;

import org.hibernate.validator.constraints.NotBlank;

import IT16308_Assignment.entities.Accounts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersModel {
	private int id ;
	
	private Accounts user_id ;
	
	private Date create_date;
	@NotBlank(message = "Không được để trống")
	private String address ; 
}
