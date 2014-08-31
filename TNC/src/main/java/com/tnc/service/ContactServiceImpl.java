package com.tnc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tnc.dao.ContactDao;
import com.tnc.domain.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDAO;

	@Transactional
	public void addContact(Contact contact) {
		contactDAO.save(contact);
	}

	@Transactional
	public List<Contact> listContact() {

		return contactDAO.getAll();
	}

	@Transactional
	public void removeContact(Integer id) {
		contactDAO.delete(id);
	}
}
