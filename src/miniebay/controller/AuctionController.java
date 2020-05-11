package miniebay.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import miniebay.entity.BidId;
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
@RequestMapping("/auction")
public class AuctionController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BidService bidService;
	
	
	@GetMapping("/showAuctionList")
	public String showAuctionList(@RequestParam String userId,
									Model theModel) {
		
		// get user info from database/DAO
		User theUser = userService.getUser(userId);
		
		// get items listed by other users from database/DAO
		List<Item> theItems = userService.getAcutionItems(theUser.getUserName());
		
		// get open items listed by other users from database/DAO
		List<Item> theOpenItems = userService.getOpenAcutionItems(theUser.getUserName());
		
		// get closed items listed by other users from database/DAO
		List<Item> theClosedItems = userService.getClosedAcutionItems(theUser.getUserName());
		
		// add the user to the model
		theModel.addAttribute("user", theUser);
		
		// add the open items to the model
		theModel.addAttribute("openItems", theOpenItems);
		
		// add the closed items to the model
		theModel.addAttribute("closedItems", theClosedItems);
		
		// add the items to the model
		theModel.addAttribute("items", theItems);
		
		// send over to our form	
		return "auction-list-form";
	}
	
	@GetMapping("/showMyBids")
	public String showMyBids(@RequestParam String userId,
									Model theModel) {
		
		// get user info from database/DAO
		User theUser = userService.getUser(userId);
		
		// get bids info from database/DAO
		List<Bid> theBids = bidService.getBids(theUser);
		
		// add the user to the model
		theModel.addAttribute("user", theUser);
		
		// add the bids to the model
		theModel.addAttribute("bids", theBids);
		
		// send over to our form	
		return "my-bids-form";
	}
	
	@GetMapping("/bidItem")
	public String bidItem(@RequestParam String userId,
						  @RequestParam int itemId,
									Model theModel) {
		
		// get user info from database/DAO
		User theUser = userService.getUser(userId);
		
		// get item info from database/DAO
		Item theItem = userService.getItem(itemId);
		
		// get bids info from database/DAO
		List<Bid> theBids = bidService.getBids(theItem);
		
		// get the highest bid amount
		float bidAmount = 0;
		for (Bid bid : theBids) {
			bidAmount = Math.max(bidAmount, bid.getBidAmount());
		}
		
		
		// add a new bid
		Bid theBid = new Bid();
		
		// add the user to the model
		theModel.addAttribute("user", theUser);
		
		// add the item to the model
		theModel.addAttribute("item", theItem);
		
		// add the highest bid amount to the model
		theModel.addAttribute("bidAmount", bidAmount);
		
		// add the bid to the model
		theModel.addAttribute("bid", theBid);
		
		// send over to our form	
		return "bid-item-form";
	}
	
	@PostMapping("/saveBid")
	public String saveBid(@Valid @ModelAttribute("bid") Bid theBid, BindingResult theBindingResult) {
		
		LocalDateTime localTime = LocalDateTime.now();
		Timestamp dateTime = Timestamp.valueOf(localTime);
		BidId theBidId = new BidId(theBid.getBidUsername().getUserName(), theBid.getBidItem().getItemId(), dateTime);
		theBid.setId(theBidId);
		
		//System.out.println("After hit save button: The bid" + theBid);
		//System.out.println("After hit save button: The bidId" + theBid.getId());
		
		if (theBindingResult.hasErrors()) {
			return "bid-item-form";
		} else {
			
			// save the user using our service
			bidService.saveBid(theBid);
			
			String url = "redirect:/auction/showMyBids?userId=" + theBid.getBidUsername().getUserName();
			
			return url;
		}
	}


}
