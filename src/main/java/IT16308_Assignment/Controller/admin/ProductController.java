package IT16308_Assignment.Controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IT16308_Assignment.beans.ProductsModel;
import IT16308_Assignment.entities.Categories;
import IT16308_Assignment.entities.Products;
import IT16308_Assignment.repository.CategoryRepository;
import IT16308_Assignment.repository.ProductRepository;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
	
	@Autowired
	private ProductRepository proRe ;
	
	@Autowired
	private CategoryRepository cateRe ;
	
	@GetMapping("/create")
	public String create(Model model,
			@ModelAttribute("product") ProductsModel productsModel
			,@RequestParam(name = "page",defaultValue = "0") Integer page 
			,@RequestParam(name = "size" ,defaultValue = "10")Integer size
			) {		
		Pageable pageable = PageRequest.of(page, size);		
		Page<Products> data = this.proRe.findAll(pageable);		
		model.addAttribute("data",data);	
		List<Categories> list = this.cateRe.findAll();		
		model.addAttribute("ds",list);		
		return "admin/products/create";
	}	
	@PostMapping("/store")
	public String store(@Valid @ModelAttribute("product") ProductsModel model , BindingResult resul, Model hihi) {		
		if (resul.hasErrors()) {
			List<Categories> list = this.cateRe.findAll();		
			hihi.addAttribute("ds",list);	
			return "admin/products/create";
		}else {
			Products entity = new Products();
			entity.setId(model.getId());
			entity.setName(model.getName());
			entity.setPrice(model.getPrice());
			entity.setImage(model.getImage());
			entity.setCreated_date(model.getCreated_date());
			entity.setAvailable(model.getAvailable());
			entity.setCategory_id(model.getCategory_id());
			
			this.proRe.save(entity);
			return "redirect:/admin/products/create";
		}
		
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model ,
				@PathVariable("id") Products products ,
				@ModelAttribute("product") ProductsModel productsModel
				,@RequestParam(name = "page",defaultValue = "0") Integer page 
				,@RequestParam(name = "size" ,defaultValue = "10")Integer size
			) {
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Products> data = this.proRe.findAll(pageable);
		List<Categories> list = this.cateRe.findAll();
		
		model.addAttribute("ds",list);
		
		
		model.addAttribute("data",data);
		
		model.addAttribute("item",products);
		
		return "/admin/products/edit";
	}
	
	@PostMapping("/update/{id}")
	public String update(ProductsModel model) {
		
		Products entity = new Products();
		entity.setId(model.getId());
		entity.setName(model.getName());
		entity.setPrice(model.getPrice());
		entity.setImage(model.getImage());
		entity.setCreated_date(model.getCreated_date());
		entity.setAvailable(model.getAvailable());
		entity.setCategory_id(model.getCategory_id());
		
		this.proRe.save(entity);
		
		
		return "redirect:/admin/products/create";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Products products) {
		
		this.proRe.delete(products);
		
		return "redirect:/admin/products/create";
	}
	
	@ModelAttribute("available")
	public Map<Integer,String> getAvailable(){
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1,"Avaliable");
		map.put(0,"Unvaliable");
		return map ;
	}
	
	
}
