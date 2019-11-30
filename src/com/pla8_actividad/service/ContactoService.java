package com.pla8_actividad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pla8_actividad.dao.IContactoDAO;
import com.pla8_actividad.entity.Contacto;

@Service
public class ContactoService implements IContactoService {

	@Autowired
	private IContactoDAO contactoDAO;
	
	@Override
	@Transactional
	public List<Contacto> getContactos() {
		return contactoDAO.getContactos();
	}
	
	@Override
	@Transactional
	public Contacto getContacto(int idcontacto) {
		return contactoDAO.getContacto(idcontacto);
	}	
		
	@Override
	@Transactional
	public void save(Contacto contacto) {
		contactoDAO.save(contacto);
	}
	
	@Override
	@Transactional
	public void delete(Contacto contacto) {
		contactoDAO.delete(contacto);
	}
	
}
