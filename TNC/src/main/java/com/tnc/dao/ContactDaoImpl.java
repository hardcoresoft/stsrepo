package com.tnc.dao;

import org.springframework.stereotype.Repository;

import com.tnc.domain.Contact;

@Repository
public class ContactDaoImpl extends BaseDaoImpl<Contact, Integer> implements ContactDao {

//	public void addContact(Contact contact) {
//		this.sessionFactory.getCurrentSession().save(contact);
//	}
	
	
	// public List<Contact> listContact() {
	// return sessionFactory.getCurrentSession().createQuery("from Contact")
	// .list();
	// }
	//
	// public void removeContact(Integer id) {
	// Contact contact = (Contact) sessionFactory.getCurrentSession().load(
	// Contact.class, id);
	// if (null != contact) {
	// sessionFactory.getCurrentSession().delete(contact);
	// }
	//
	// }
}
