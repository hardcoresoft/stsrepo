package com.tnc.dao;

import java.util.List;

import com.tnc.domain.Document;


public interface DocumentDao {

	public void save(Document document);
	
	public List<Document> list();
	
	public Document get(Integer id);
	
	public void remove(Integer id);
}
