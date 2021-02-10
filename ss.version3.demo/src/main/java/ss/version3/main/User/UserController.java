package ss.version3.main.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("")
	public String viewHomePage()
	{
		return "index";
	}

	@GetMapping("/register")
	//@ResponseBody -> add this if you want to see string when you use return, instead of template
	public String viewRegPage(Model model)
	{	
		model.addAttribute("user", new User());
		return "signupForm";
		
	}
	
	@GetMapping("/index")
	public String viewLoginPage()
	{
		return "index";	
	}
	
	@PostMapping("/registerUser")
	public String registerUser(User user)
	{
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 String encodedPassword = passwordEncoder.encode(user.getPassword());
		 
		 /**BCryptPasswordEncoder to encode the user’s password so the pwd itself it not stored in DB (for better security) 
		  * – only the hash value of the password is stored. */
		 
		 user.setPassword(encodedPassword);    
		 repo.save(user);
		     
		 return "registerSuccess";
	}
	
	@GetMapping("/userHome")
	public String viewUserHome()
	{
		return "userHome";	
	}
		
}
