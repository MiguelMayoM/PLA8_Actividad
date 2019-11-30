package com.pla8_actividad.dao;

import java.util.List;

import com.pla8_actividad.entity.Contacto;

public interface IContactoDAO {
	List<Contacto> getContactos();
	Contacto getContacto(int idcontacto);
	
	void save(Contacto contacto);
	void delete(Contacto contacto);
}
