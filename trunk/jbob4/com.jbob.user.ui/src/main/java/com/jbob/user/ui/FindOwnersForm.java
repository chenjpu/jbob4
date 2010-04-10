package com.jbob.user.ui;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jbob.user.User;
import com.jbob.user.dao.UserDao;

/**
 * JavaBean Form controller that is used to search for <code>Owner</code>s by
 * last name.
 *
 * @author Juergen Hoeller
 * @author Ken Krebs
 */
@Controller
@RequestMapping("/findOwners.do")
public class FindOwnersForm {

	private UserDao userDao;
	
    @Autowired
	public FindOwnersForm(UserDao userDao) {
		this.userDao = userDao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public  String setupForm(Model model) {
		userDao.insert(new User());
		model.addAttribute("owner", new HashMap());
		return "findOwners";
	}
	/*@RequestMapping(method = RequestMethod.POST)
	public  String processSubmit(Owner owner, BindingResult result, Model model) {
		// find owners by last name
		Collection<Owner> results = this.clinic.findOwners(owner.getLastName());
		if (results.size() < 1) {
			// no owners found
			result.rejectValue("lastName", "notFound", "not found");
			return "findOwners";
		}
		if (results.size() > 1) {
			// multiple owners found
			model.addAttribute("selections", results);
			return "owners";
		}
		else {
			// 1 owner found
			owner = results.iterator().next();
			return "redirect:owner.do?ownerId=" + owner.getId();
		}
	}*/

}
