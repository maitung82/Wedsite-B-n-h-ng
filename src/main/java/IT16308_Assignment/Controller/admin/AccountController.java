package IT16308_Assignment.Controller.admin;


import javax.validation.Valid;

import org.hibernate.loader.custom.EntityFetchReturn;
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

import IT16308_Assignment.beans.AccountsModel;
import IT16308_Assignment.entities.Accounts;
import IT16308_Assignment.repository.AccountRepository;


@Controller
@RequestMapping("/admin/accounts")
public class AccountController {
	@Autowired
	private AccountRepository accRep ;	
	@GetMapping("/create")
	public String create(Model model , 
			@ModelAttribute("account") AccountsModel account,
			@RequestParam(name = "page" ,defaultValue = "0") Integer page,
			@RequestParam(name = "size" ,defaultValue = "10") Integer size
			) {
		Pageable pageable = PageRequest.of(page, size); 		
		Page<Accounts> data = this.accRep.findAll(pageable);
		model.addAttribute("data",data);		
		return "admin/accounts/create";
	}
	
	@PostMapping("/store")
	public String store( Model model ,
			AccountsModel accountsModel , 
			@Valid	@ModelAttribute("account") AccountsModel account ,
			BindingResult result) {
		if (result.hasErrors() == true) {
			model.addAttribute("message","form chưa hợp lệ");
			return "/admin/accounts/create" ;
			
		}else {
			Accounts entity = new Accounts();
			String encrypted = IT16308_Assignment.ultils.EncryptUtil.encrypted(account.getPassword());			
			entity.setId(accountsModel.getId());
			entity.setFullname(accountsModel.getFullname());
			entity.setPassword(encrypted);
			entity.setUsername(accountsModel.getUsername());
			entity.setEmail(accountsModel.getEmail());
			entity.setPhoto(accountsModel.getPhoto());
			entity.setActivated(accountsModel.getActivated());
			entity.setAdmin(accountsModel.getAdmin());
			this.accRep.save(entity);		
		return "redirect:/admin/accounts/create";
		}
	}
	@GetMapping("/edit/{id}")
	public String edit(Model model ,
			@PathVariable("id") Accounts accounts ,
			@ModelAttribute("account") AccountsModel accountsModel
			,@RequestParam(name = "page" ,defaultValue = "0") Integer page,
			@RequestParam(name = "size" ,defaultValue = "10") Integer size
			) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Accounts> data = this.accRep.findAll(pageable);
		
		model.addAttribute("data",data);
		
		model.addAttribute("item", accounts);
		
		return "admin/accounts/edit";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Accounts accounts , AccountsModel model ) {
		
		try {
			
			Accounts entity = new Accounts();
			
			String encrypted = IT16308_Assignment.ultils.EncryptUtil.encrypted(model.getPassword());
			entity.setId(model.getId());
			entity.setFullname(model.getFullname());
			entity.setPassword(encrypted);
			entity.setUsername(model.getUsername());
			entity.setEmail(model.getEmail());
			entity.setPhoto(model.getPhoto());
			entity.setActivated(model.getActivated());
			entity.setAdmin(model.getAdmin());
			
			this.accRep.save(entity);
			
			return "redirect:/admin/accounts/create";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/admin/accounts/edit";
		}
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Accounts accounts) {
		
		this.accRep.delete(accounts);
		
	
		return "redirect:/admin/accounts/create";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
