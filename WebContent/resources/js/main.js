/*Todo este archivo es sólo para la página de Alta de contacto, por eso
	no compruebo que estemos en dicha página con su id respectivo */
/********************/
/* FORMATO TELÉFONO */
/********************/
/* Uso keyup para que el efecto sea inmediato */
document.querySelector('#iptTelefono').addEventListener('keyup', (e) => {
	//console.log(event.keyCode);
	if((event.keyCode == "8") || (event.keyCode == "46")){return;}
	/* Replazo todo carácter no númerico por nada. También elimina espacios.
		 Sin problema, pues los pondré aquí */
	strTelefono = e.target.value.replace(/\D/g,"");
	/* Divido el string en los trozos que me interesan: 3 + 2 + 2 + 2 */
	let trozo = "", trozos = [];
	/* substr(inicio,long) VS substring(inicio,final)*/
	trozo = strTelefono.substr(0,3); /*prefijo*/
	if(trozo.length == 3){trozo += " ";}
	trozos.push(trozo);
	
	for(let i=3; i<strTelefono.length; i += 2){
		trozo = strTelefono.substr(i,2);
		if(trozo.length == 2){trozo += " ";}
		trozos.push(trozo);
	}
	/* Y ahora los junto con espacios */
	strTelefono = trozos.join("");
	if (strTelefono.length == 13) {strTelefono = strTelefono.replace(/\s$/,"");} 
	e.target.value = strTelefono;
});

/*****************************************/
/* PERMITIR SUBMIT CON DATOS INCORRECTOS */
/*****************************************/
/* Los atributos "required" y "pattern" controlan la validación en el lado del
 * cliente, de forma que no permiten hacer un submit con datos incorrectos. Esto
 * ya estaría bien, aunque debería completarlo con los mismos mensajes de error
 * que muestro en la validación de Hibernate. Por otra parte, esta validación
 * del lado del cliente se puede deshabilitar o saltar, de forma que detrás debemos
 * tener una validación del lado de servidor, la de Hibernate. Por ello, ahora,
 * para poder comprobar como funciona, vamos a hacer el submit aunque haya datos
 * incorrectos en el formulario */
document.querySelector("input[type=submit]").addEventListener("click", (e) => {
  e.preventDefault();
  document.querySelector("form").submit();    
}, false);

/*****************************/
/* REQUERIR EMAIL O TELÉFONO */
/*****************************/
/* En la parte de validación de cliente, también implemento que se haya de
 * rellenar el email o el teléfono. Para ello, primero dispongo sendos required
 * en ambas casillas. En el momento que se rellena una de ellas, elimino el
 * required de la otra */
let camposRellenarUno = document.querySelectorAll(".soloUno");
camposRellenarUno.forEach( (ele) => {
	/* Para cada input del grupo que se modifique...*/
	ele.addEventListener("keyup", (e) => {
		/* ... si este está no vacío */
		if(e.target.value != "") {
			e.target.setAttribute("required", true);
			/* ... le quito el required a todos los demás que no estén rellenos */
			camposRellenarUno.forEach((c) => {
				if(c.value == "") {
					c.removeAttribute("required");
				}
		});
		/*Pero si lo que he hecho ha sido modificar para borrar el contenido,
			suponiendo, por ejemplo, que este fuera el único con texto y que, por
			lo tanto, fuera el único con required y todos los demás sin required ...*/
		} else if(e.target.value == "") {
			/*Miro si hay algún otro con texto ...*/
			let algunoTexto = false;
			/*Le he de quitar a este el attribute para el algoritmo que hago, y, si no
				hay ninguno más, se lo pondré otra vez, junto a todos los demás */
			e.target.removeAttribute("required");
			camposRellenarUno.forEach((c) => {
				if(c.value != "") {
					/* Si lo hubiera lo pongo a true y la flag que usaré después, también*/
					algunoTexto = true;
					c.setAttribute("required", true);
				} 
			});
			/*Si resulta que ninguno más tiene required, entonces se lo pongo a todos*/
			if(algunoTexto === false) {
				camposRellenarUno.forEach((c) => {
					c.setAttribute("required", true);
				});
			}
		}
	}, false);
});
