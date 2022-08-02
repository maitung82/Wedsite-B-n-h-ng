package IT16308_Assignment.Controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import IT16308_Assignment.beans.OrdersModel;
import IT16308_Assignment.entities.Accounts;
import IT16308_Assignment.entities.Orders;
import IT16308_Assignment.repository.AccountRepository;
import IT16308_Assignment.repository.OrderRepository;


@Controller
@RequestMapping("/admin/orders")
public class OrderController {
	@Autowired
	private OrderRepository orRepo ;
	
	@Autowired
	HttpSession session ;
	
	@Autowired
	HttpServletRequest request ;
	
	@Autowired
	private AccountRepository accRepo ;
	
	@GetMapping("/create")
	public String create(Model model,
			@ModelAttribute("order") OrdersModel orderModel
			,@RequestParam(name = "page",defaultValue = "0") Integer page 
			,@RequestParam(name = "size" ,defaultValue = "10")Integer size
			) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Orders> data = this.orRepo.findAll(pageable);
		
		model.addAttribute("data",data);
		
		List<Accounts> list = this.accRepo.findAll();
		
		model.addAttribute("ds",list);
		
		
		
		
		
		return "admin/orders/create";
	}
	
//	@PostMapping("/store")
//	public String store(OrdersModel model) {
//		
//		Orders entity = new Orders();
//		
//		Accounts accounts = (Accounts) session.getAttribute("accounts");
//		
//		
//		entity.setId(model.getId());
//		entity.setUser_id(accounts);
//		entity.setCreate_date(model.getCreate_date());
//		entity.setAddress(model.getAddress());
//		
//		
//		this.orRepo.save(entity);
//		
//		return "redirect:/admin/orders/create";
//	}
	@PostMapping("/store")
	public String store(OrdersModel model) {
		Orders entity = new Orders();
		Accounts accounts = (Accounts) session.getAttribute("accounts");
		entity.setId(model.getId());
		entity.setUser_id(model.getUser_id());
		entity.setCreate_date(model.getCreate_date());
		entity.setAddress(model.getAddress());
		this.orRepo.save(entity);
		return "redirect:/admin/orders/create";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(Model model ,
				@PathVariable("id") Orders order ,
				@ModelAttribute("order") OrdersModel ordersModel
				,@RequestParam(name = "page",defaultValue = "0") Integer page 
				,@RequestParam(name = "size" ,defaultValue = "10")Integer size
			) {
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Orders> data = this.orRepo.findAll(pageable);
		
		List<Accounts> list = this.accRepo.findAll();
		
		model.addAttribute("ds",list);
		
		model.addAttribute("data",data);
		
		model.addAttribute("item",order);
		
		return "/admin/orders/edit";
	}
	
	@PostMapping("/update/{id}")
	public String update(OrdersModel model) {
		
		Orders entity = new Orders();
		entity.setId(model.getId());
		entity.setUser_id(model.getUser_id());
		entity.setCreate_date(model.getCreate_date());
		entity.setAddress(model.getAddress());
		
		this.orRepo.save(entity);
		
		
		return "redirect:/admin/orders/create";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Orders order) {
		
		this.orRepo.delete(order);
		
		return "redirect:/admin/orders/create";
	}
	
	
}
