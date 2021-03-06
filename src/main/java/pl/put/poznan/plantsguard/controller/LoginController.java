package pl.put.poznan.plantsguard.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.put.poznan.plantsguard.model.User;
import pl.put.poznan.plantsguard.service.SecurityUtils;

@Controller
public class LoginController {

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}

	@GetMapping(value= {"/login","/"})
	public String login(Model model, String err, String logout) {
		if(SecurityUtils.isUserLoggedIn()) return "redirect:/dashboard";
		if(err!=null) model.addAttribute("error", "Błędny login lub hasło");
		if(logout!=null) model.addAttribute("logout", "Nastąpiło poprawne wylogowanie");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model) {
		System.out.println("Controller");
			return "redirect:/dashboard";
	}
}
