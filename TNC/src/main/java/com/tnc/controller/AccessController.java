package com.tnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class AccessController {

//	private String username;
//	private String password;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@RequestMapping(value = "/login", method = { RequestMethod.POST })
//	public @ResponseBody String authentication(@RequestParam("login") String userName,
//			@RequestParam("password") String password, HttpServletRequest request) {
//
//		this.username = userName;
//		this.password = password;
//
//		Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
//		try {
//
//			Authentication authentication = authenticationManager.authenticate(authenticationToken);
//
//			SecurityContext securityContext = SecurityContextHolder.getContext();
//
//			securityContext.setAuthentication(authentication);
//
//			HttpSession session = request.getSession(true);
//			session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
//
//			return "sucess";
//		} catch (AuthenticationException ex) {
//			return "fail " + ex.getMessage();
//		} finally {
//
//		}
//	}

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
