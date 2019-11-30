package com.pla8_actividad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.pla8_actividad.validation.RellenarUnCampo;

/* Vamos a realizar una "cross field validation creando una anotación a nivel de
 * clase. La regla será que se habrá de rellenar uno de los campos "email" o
 * "telefono". Otra opción, descrita al final de este archivo, es usar @AssertTrue,
 * la cual coloca el mensaje de error en una tag específica para el método que
 * evalúa la condición. En este caso podría usar ambas, pero la primera resulta
 * más potente y por ello la voy a explorar. Por ejemplo, si quisiera adaptar los
 * mensajes de error en función de ciertas condiciones, no podría hacerlo a nivel
 * de campo con unas etiquetas estáticas e independientes de las demás...*/
@Entity
@Table(name = "contactos") /* De la BD agendamiguel */
@RellenarUnCampo(campo1 = "email", campo2 = "telefono", mensaje = "Debe rellenar uno de los campos marcados con **.")
public class Contacto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcontacto")
	public int getIdcontacto() {return idcontacto;}
	public void setIdcontacto(int idcontacto) {this.idcontacto = idcontacto;}	
	private int idcontacto;

	@Column(name = "nombre")
	@Pattern(regexp = "^.*[^\\s]{3,}.*$", message = "El nombre ha de contener como mínimo 3 letras seguidas.")
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	private String nombre;

	@Column(name = "email")
	@Pattern(regexp = "^[A-Za-z0-9](?!.*\\.\\.)[A-Za-z0-9\\.]+\\@[A-Za-z]+\\.\\w{2,3}$|", 
					 message = "Formato requerido: números, letras(no la ñ) y puntos (puntos no seguidos) @ letras.aaa")	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	private String email;
	
	@Column(name = "telefono")
	@Pattern(regexp = "^\\d{3}\\s{1}\\d{2}\\s{1}\\d{2}\\s{1}\\d{2}$|", message = "Formato requerido: 987 65 43 21. ")
	@Pattern(regexp = "^[6|9]{1}.*$|", message = "El teléfono ha de comenzar con 6 o 9.")
	public String getTelefono() {return telefono;}
	public void setTelefono(String telefono) {this.telefono = telefono;}
	private String telefono;
	
	public Contacto() {}
	public Contacto(String nombre, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}
	
	/* De esta forma ya funciona, pero quisiera que, cuando los dos campos estén
	 * vacíos, se haga hincapié sobre este hecho, prescindiendo de los errores
	 * de cada campo dados por el @pattern */
  //@AssertTrue(message = "Ha de rellenar el email o el teléfono.")
  /* La función de comprobación ha de comenzar con "is" */
  //public boolean isUnoDeDos() {return ((email != "") || (telefono != ""));}
	/* Y en la vista, en el .jsp hay que poner la tag: */
	// <form:errors path="unoDeDos" cssClass="error" />
}
