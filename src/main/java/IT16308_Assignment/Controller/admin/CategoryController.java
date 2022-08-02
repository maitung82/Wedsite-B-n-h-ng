package IT16308_Assignment.Controller.admin;

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

import IT16308_Assignment.beans.CategoriesModel;
import IT16308_Assignment.entities.Categories;
import IT16308_Assignment.repository.CategoryRepository;


@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	private CategoryRepository catRep ;
	
	
	
	@GetMapping("/create")
	public String create(Model model , 
			@ModelAttribute("category") CategoriesModel category,
			@RequestParam(name = "page" ,defaultValue = "0") Integer page,
			@RequestParam(name = "size" ,defaultValue = "10") Integer size
			) {
		Pageable pageable = PageRequest.of(page, size); 
		
		Page<Categories> data = this.catRep.findAll(pageable);
		model.addAttribute("data",data);
		
		02.
		
		return "admin/categories/create";
	}
	
	@PostMapping("/store")
	public String store(Model model, CategoriesModel categoriesModel,
			@Valid @ModelAttribute("category") CategoriesModel category,BindingResult result) {
		if (result.hasErrors() == true) {
			model.addAttribute("message","form chưa hợp lệ");
			return "/admin/categories/create" ;
			
		}else {
		Categories entity = new Categories();
		entity.setId(categoriesModel.getId());
		entity.setName(categoriesModel.getName());		
		this.catRep.save(entity); 				
		return "redirect:/admin/categories/create";
	}}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model ,
			@PathVariable("id") Categories categories ,
			@ModelAttribute("category") CategoriesModel categoriesModel
			,@RequestParam(name = "page" ,defaultValue = "0") Integer page,
			@RequestParam(name = "size" ,defaultValue = "10") Integer size
			) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Categories> data = this.catRep.findAll(pageable);
		
		model.addAttribute("data",data);
		
		model.addAttribute("item", categories);
		
		return "admin/categories/edit";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Categories accounts , CategoriesModel model ) {
		
		try {
			Categories entity = new Categories();
			entity.setId(model.getId());
			entity.setName(model.getName());
			
			
			this.catRep.save(entity);
			
			return "redirect:/admin/categories/create";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/admin/categories/edit";
		}
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Categories categories) {
		
		this.catRep.delete(categories);
		
		
		return "redirect:/admin/categories/create";
	}
}
