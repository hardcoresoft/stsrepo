package com.tnc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class AccessController {

	protected String username;
	protected String password;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/authen", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody String authentication(@RequestParam("j_username") String userName,
			@RequestParam("j_password") String password, HttpServletRequest request) {

		this.username = userName;
		this.password = password;

		Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
		try {

			Authentication authentication = authenticationManager.authenticate(authenticationToken);

			SecurityContext securityContext = SecurityContextHolder.getContext();

			securityContext.setAuthentication(authentication);

			HttpSession session = request.getSession();
			session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

			return "sucess";
		} catch (AuthenticationException ex) {
			return "fail " + ex.getMessage();
		}
	}

	@RequestMapping("/login")
	public String login(Model model, @RequestParam(required = false) String message) {
		model.addAttribute("message", message);
		return "access/login";
	}

	@RequestMapping(value = "/denied")
	public String denied() {
		return "access/denied";
	}

	@RequestMapping(value = "/login/failure")
	public String loginFailure() {
		String message = "Invalid Username or Password!";
		return "redirect:/login?message=" + message;
	}

	@RequestMapping(value = "/logout/success")
	public String logoutSuccess() {
		String message = "Logout Success!";
		return "redirect:/login?message=" + message;
	}
}
