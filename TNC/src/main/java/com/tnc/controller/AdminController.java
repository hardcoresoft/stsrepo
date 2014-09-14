package com.tnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles and retrieves the common or admin page depending on the URI template.
 * A user must be log-in first he can access these pages. Only the admin can see
 * the adminpage, however.
 */
@Controller
@RequestMapping("/")
public class AdminController {

	/**
	 * Handles and retrieves the common JSP page that everyone can see
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/common", method = RequestMethod.GET)
	public String getCommonPage() {

		// Do your work here. Whatever you like
		// i.e call a custom service to do your business
		// Prepare a model to be used by the JSP page

		// This will resolve to /WEB-INF/jsp/commonpage.jsp
		return "access/commonpage";
	}

	/**
	 * Handles and retrieves the admin JSP page that only admins can see
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminPage() {

		// Do your work here. Whatever you like
		// i.e call a custom service to do your business
		// Prepare a model to be used by the JSP page

		// This will resolve to /WEB-INF/jsp/adminpage.jsp
		return "access/adminpage";
	}
}