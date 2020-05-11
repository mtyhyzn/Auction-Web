package miniebay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniebay.entity.Item;
import miniebay.entity.User;
import miniebay.service.UserService;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserService userService;
	

	@GetMapping("/mainMenu")
	public String mainMenu(@RequestParam String userName,
						Model theModel) {
		
		// Note: hard code userName
		//String userName = "user1";
		
		// get user info from database/DAO
		User theUser = userService.getUser(userName);
		
		// get item info from database/DAO
		List<Item> theItems = userService.getItems(userName);
		
		// add the user to the model
		theModel.addAttribute("user", theUser);
		
		// add the items to the model
		theModel.addAttribute("items", theItems);
		
		return "main-menu";
	}

	
	@GetMapping("/editProfile")
	public String editProfile(@RequestParam String userId, Model theModel) {
		
		// get user info from database/DAO
		User theUser = userService.getUser(userId);
		
		// add the user to the model
		theModel.addAttribute("user", theUser);
		
		// send over to our form	
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {
		
		// save the user using our service
		userService.saveUser(theUser);
		
		String url = "redirect:/home/mainMenu?userName=" + theUser.getUserName();
		
		return url;
		
		//return "redirect:/home/mainMenu";
	}
	
	
}
