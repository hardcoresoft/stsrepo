package com.tnc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tnc.domain.Contact;
import com.tnc.service.ContactService;
 
@Controller
@RequestMapping("/contact")
public class ContactController {
 
    @Autowired
    private ContactService contactService;
 
    @RequestMapping("/index")
    public ModelAndView listContacts(Map<String, Object> map) {
    	
    	ModelAndView modelAndView = new ModelAndView("contact/contact");
    	modelAndView.addObject("contact", new Contact());
    	modelAndView.addObject("contactList", contactService.listContact());
 
//        map.put("contact", new Contact());
//        map.put("contactList", contactService.listContact());
 
        return modelAndView;
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact")
    Contact contact, BindingResult result) {
 
        contactService.addContact(contact);
 
        return "redirect:/contact/index";
    }
 
    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId")
    Integer contactId) {
 
        contactService.removeContact(contactId);
 
        return "redirect:/contact/index";
    }
}