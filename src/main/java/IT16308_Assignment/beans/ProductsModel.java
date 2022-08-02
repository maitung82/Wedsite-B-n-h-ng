package IT16308_Assignment.beans;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import IT16308_Assignment.entities.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsModel {
	private int id ;
	@NotBlank(message = "name k dc dẻ trong")
	private String name ;
	@NotBlank(message = "Không được để trống")
	private String image ;
	@NotNull(message = "Không được để trống")
	@Min(value =0, message = "giá phải lớn hơn 0 hoặc =0")
	private double price ;
	
	private Date created_date ;
	
	private int available ;

	private Categories category_id ;
}
