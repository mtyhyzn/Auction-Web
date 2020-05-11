package miniebay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import miniebay.entity.User;
import miniebay.service.UserService;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	

	@GetMapping("/loginPage")
	public String loginPage(Model theModel) {
		
		// get user info from database/DAO
		User theUser = new User();
		
		// add the user to the model
		theModel.addAttribute("user", theUser);
		
		return "login-form";
	}

	@GetMapping("/login")
	public String login(@ModelAttribute("user") User theUser, Model model) {
		
		boolean isValidLogin = userService.isValidLogin(theUser);
		// save the user using our service
		//userService.saveUser(theUser);
		//System.out.println("userName" + theUser.getUserName());
		
		if (isValidLogin) {
			String url = "redirect:/home/mainMenu?userName=" + theUser.getUserName();
			
			return url;
		} else {
			//return "redirect:/home/mainMenu?userName=user1";
			model.addAttribute("error", "Invalid username or password.");
			return "login-form";
		}		
	}
	
	
}
