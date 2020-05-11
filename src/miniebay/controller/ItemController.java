package miniebay.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import miniebay.entity.Bid;
import miniebay.entity.Item;
import miniebay.entity.User;
import miniebay.service.BidService;
import miniebay.service.UserService;


/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BidService bidService;
	
	
	@GetMapping("/showFormForList")
	public String showFormForList(@RequestParam String userId, Model theModel) {
		
		// get user info from database/DAO
		User theUser = userService.getUser(userId);
		
		// add the user to the model
		theModel.addAttribute("user", theUser);
		
		// create model attribute to bind form data
		Item theItem = new Item();
		
		theModel.addAttribute("item", theItem);
		
		return "item-form";
	}
	
	@PostMapping("/saveItem")
	public String saveItem(@Valid @ModelAttribute("item") Item theItem, BindingResult theBindingResult) {

		LocalDateTime localTime = LocalDateTime.now();
		Timestamp dateTime = Timestamp.valueOf(localTime);
		ZonedDateTime zonedDateTime = dateTime.toInstant().atZone(ZoneId.of("UTC"));
		
		// add 14 days
		Timestamp auctionEndsTime = Timestamp.from(zonedDateTime.plus(14, ChronoUnit.DAYS).toInstant());

		theItem.setAuctionEndsTime(auctionEndsTime);		
		
		if (theBindingResult.hasErrors()) {
			
			//return "item-form";
			return "redirect:/item/showFormForList?userId=" + theItem.getOwnerUsername().getUserName();
		} else {
			
			// save the user using our service
			userService.saveItem(theItem);
			
			String url = "redirect:/home/mainMenu?userName=" + theItem.getOwnerUsername().getUserName();
			return url;
			//return "redirect:/home/mainMenu";
		}
		
	}
	
	
	@GetMapping("/showItemDetail")
	public String showItemDetail(@RequestParam("itemId") int theId,
								@RequestParam("userName") String userId,
									Model theModel) {
		
		// get user info from database/DAO
		User theUser = userService.getUser(userId);
		
		// add the user to the model
		theModel.addAttribute("user", theUser);
		
		// get item from the our service
		Item theItem = userService.getItem(theId);
		
		// get bid info from database/DAO
		List<Bid> theBids = bidService.getBids(theItem);
		
		// set item as a model attribute to pre-polulate the form
		theModel.addAttribute("item", theItem);
		
		// add the bids to the model
		theModel.addAttribute("bids", theBids);
		
		// send over to our form	
		return "item-detail-form";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("itemId") int theId,
									Model theModel) {
		
		// save the user using our service
		userService.deleteItem(theId);
		
		// send over to our form	
		return "item-detail-form";
	}
}
