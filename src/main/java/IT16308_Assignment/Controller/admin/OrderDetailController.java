package IT16308_Assignment.Controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IT16308_Assignment.beans.OrderDetailsModel;
import IT16308_Assignment.entities.OrderDetails;
import IT16308_Assignment.entities.Orders;
import IT16308_Assignment.entities.Products;
import IT16308_Assignment.repository.OrderDetailRepository;
import IT16308_Assignment.repository.OrderRepository;
import IT16308_Assignment.repository.ProductRepository;

@Controller
@RequestMapping("/admin/orderDetails")
public class OrderDetailController {

	@Autowired
	private OrderDetailRepository orderDetailRepo;
	
	@Autowired
	private OrderRepository orderRepo ;
	
	@Autowired
	private ProductRepository prodRepo ;
	
	@GetMapping("/create")
	public String create(
			Model model ,
			@ModelAttribute("orderDetail") OrderDetailsModel orderDetailsModel 
			,@RequestParam(name = "page" ,defaultValue = "0") Integer page ,
			@RequestParam(name = "size" , defaultValue = "10") Integer size
			
			) {
		Pageable pageable = PageRequest.of(page, size);
		
		Page<OrderDetails> data = this.orderDetailRepo.findAll(pageable);
		
		model.addAttribute("data", data);
		
		 List<Orders> listOrder = this.orderRepo.findAll();
		 
		 model.addAttribute("dsOrder",listOrder);
		 
		 List<Products> listProduct = this.prodRepo.findAll();
		 
		 model.addAttribute("dsProduct",listProduct);
		
		 
		
		return "admin/orderDetails/create";
	}
 	
	@PostMapping("/store")
	public String store(OrderDetailsModel orderDetailsModel) {
		
		OrderDetails entity = new OrderDetails();
		entity.setId(orderDetailsModel.getId());
		entity.setOrder_id(orderDetailsModel.getOrder_id());
		entity.setProduct_id(orderDetailsModel.getProduct_id());
		entity.setPrice(orderDetailsModel.getPrice());
		entity.setQuantity(orderDetailsModel.getQuantity());
		
		this.orderDetailRepo.save(entity);
		
		return "redirect:/admin/orderDetails/create";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(
			Model model ,
			@PathVariable("id") OrderDetails orderDetails,
			@ModelAttribute("orderDetail") OrderDetailsModel orderDetailsModel 
			,@RequestParam(name = "page" ,defaultValue = "0") Integer page ,
			@RequestParam(name = "size" , defaultValue = "10") Integer size
			) {
		Pageable pageable = PageRequest.of(page, size);
		
		Page<OrderDetails> data = this.orderDetailRepo.findAll(pageable);
		
		List<Orders> listOrder = this.orderRepo.findAll();
		 
		 model.addAttribute("dsOrder",listOrder);
		 
		 List<Products> listProduct = this.prodRepo.findAll();
		 
		 model.addAttribute("dsProduct",listProduct);
		
		model.addAttribute("data", data);
		
		model.addAttribute("item",orderDetails);
		return "admin/orderDetails/edit";
	}
	@PostMapping("/update/{id}")
	public String update(
			@PathVariable("id") OrderDetails orderDetails,
			@ModelAttribute("orderDetail") OrderDetailsModel orderDetailsModel 
			) {
		OrderDetails entity = new OrderDetails();
		entity.setId(orderDetailsModel.getId());
		entity.setOrder_id(orderDetailsModel.getOrder_id());
		entity.setProduct_id(orderDetailsModel.getProduct_id());
		entity.setPrice(orderDetailsModel.getPrice());
		entity.setQuantity(orderDetailsModel.getQuantity());
		
		this.orderDetailRepo.save(entity);
		return "redirect:/admin/orderDetails/create";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") OrderDetails orderDetails) {
		
		this.orderDetailRepo.delete(orderDetails);
		
		return "redirect:/admin/orderDetails/create";
	}
}
