  
package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.demo.entity.PersonaInfo;

public abstract class PersonaRepositoryImpl implements PersonaRepository{
     
	@PersistenceContext
	private EntityManager em;
	
	public PersonaInfo getById(int id) {
		
		Query query = em.createQuery("from PersonaInfo where id :=idp");
		query.setParameter("idp", id);
		
		return (PersonaInfo) query.getSingleResult();	
	}
}