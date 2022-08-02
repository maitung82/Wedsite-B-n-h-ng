package IT16308_Assignment.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import IT16308_Assignment.beans.AccountsModel;
import IT16308_Assignment.entities.Accounts;
import IT16308_Assignment.repository.AccountRepository;


@Controller
@RequestMapping("/admin")
public class LoginController {
	@Autowired
	private AccountRepository accRepos ; 
	
	@Autowired
	HttpServletRequest request ;
	
	@Autowired
	HttpSession session ;
	
	
	@GetMapping("/login")
	public String getLogin(@ModelAttribute("loginForm") AccountsModel model) {
		return "Login";
	}
	
	@PostMapping("/login/form")
	public String postLogin(AccountsModel model) {
		session = request.getSession();		
		String email = model.getEmail();
		String password = model.getPassword();		
		Accounts accounts = this.accRepos.findByEmail(email);
		boolean check = IT16308_Assignment.ultils.EncryptUtil.check(password,accounts.getPassword());		
		if(check==true) {
			session.setAttribute("message","Đăng nhập thành công !");
			session.setAttribute("accounts", accounts);
			return "redirect:/admin/getHome";
		}else {
			session.setAttribute("message", "Đăng nhập thất bại !");
			return "redirect:/admin/login";
		}
		
	}
	
	
}
