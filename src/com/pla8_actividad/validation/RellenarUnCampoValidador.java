package com.pla8_actividad.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import com.pla8_actividad.entity.Contacto;

public class RellenarUnCampoValidador 
						 implements ConstraintValidator<RellenarUnCampo, Contacto> {

	private String campo1;
	private String campo2;
	private String mensaje;

	@Override
	public void initialize(RellenarUnCampo anotacionRestriccion) {
		campo1 = anotacionRestriccion.campo1();
		campo2 = anotacionRestriccion.campo2();
		mensaje = anotacionRestriccion.mensaje();
	}

	@Override
	public boolean isValid(Contacto contacto, 
												 ConstraintValidatorContext contextoRestriccion) {
		boolean valido = false;
		try {
			String strCampo1 = new BeanWrapperImpl(contacto).getPropertyValue(campo1).toString();
			String strCampo2 = new BeanWrapperImpl(contacto).getPropertyValue(campo2).toString();
			/* En otros sitios también usan: */
			//BeanUtils.getProperty(contacto, campo1);
			
			/* Será válido si uno de los dos no es vacío */
			valido = ((strCampo1 != "") || (strCampo2 != ""));
			
    } catch (Exception e) {
      System.out.println(e.toString());
    }
		
		if(valido == false) {
			/* Pongo el mensaje en la tag de error del campo1, que se encuentra entre
			 * ambos campos y se ve bien */
			contextoRestriccion.disableDefaultConstraintViolation();
			contextoRestriccion.buildConstraintViolationWithTemplate(mensaje)
				.addPropertyNode(campo1).addConstraintViolation();
		}
		return valido;
	}
}
