<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Contacto</title>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
						integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
						crossorigin="anonymous">
		</script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
						integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
						crossorigin="anonymous">
		</script>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
		<!-- IMPORTANTE: PONER NUESTRO CSS DESPUÉS PARA QUE SOBREESCRIBA AL DE BOOTSTRAP -->
		<link type="text/css" rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/style.css" />		
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js">
		</script>

</head>

<body>
	<div class="container">
	<div class="jumbotron">
		<img src="${pageContext.request.contextPath}/resources/img/task.png"
			alt="contactos" class="float-right" height="150" />
		<h1>${contacto.idcontacto==0 ? "Nuevo" : "Editar"} contacto</h1>
		<p>Mantenimiento de una agenda de contactos realizado con Spring e Hibernate.</p>		
		
	</div>
	
	<form:form id="contacto" action="savecontacto" modelAttribute="contacto" method="post">
		<p>Los campos marcados con <strong><abbr title="Obligatorio">*</abbr></strong> son obligatorios.
			 En el caso de los campos marcados con <strong><abbr class="obligatorioUno" 
			 title="obligatorio uno de los campos del grupo">**</abbr></strong>, se ha de rellenar al menos uno de ellos.
		</p>
		<form:hidden path="idcontacto" />

		<div class="form-group">
			<label for="iptNombre">Nombre (mínimo 3 caracteres):
				<strong><abbr title="obligatorio">*</abbr></strong>
			</label>
			<form:input path="nombre" id="iptNombre" name="nombre" placeholder="Nombre Apellidos" 
						 			class="form-control" type="text" maxlength="50"
						 			required="true" pattern="^.*[^\s\d]{3,}.*$" autocomplete="off" />
			<span class="validacion form-control"></span>			 						
			<form:errors path="nombre" cssClass="error" />
		</div>

		<div class="form-group">
			<label for="iptEmail">email:
				<strong><abbr class="obligatorioUno" title="Obligatorio uno de los campos del grupo">**</abbr></strong>
			</label>
			<form:input path="email" id="iptEmail" name="email" placeholder="letras.0123456789@sitio.abc"
						 class="form-control soloUno" type="text" value="" maxlength="50"
						 required="true" pattern="^[A-Za-z0-9](?!.*\.\.)[A-Za-z0-9\.]+@[A-Za-z]+\.\w{2,3}$|" autocomplete="off" />
			<span class="validacion form-control"></span>
			<form:errors path="email" cssClass="error" />
		</div>
		
		<div class="form-group">
			<label for="iptTelefono">Teléfono:
				<strong><abbr class="obligatorioUno" title="Obligatorio uno de los campos del grupo">**</abbr></strong>
			</label>
			<form:input path="telefono" id="iptTelefono" name="telefono" placeholder="987 65 43 21"
						 class="form-control soloUno" type="text" value="" maxlength="12"
						 required="true" pattern="^[6|9]{1}\d{2}\s{1}\d{2}\s{1}\d{2}\s{1}\d{2}$|" autocomplete="off" />
			<span class="validacion form-control"></span>
			<form:errors path="telefono" cssClass="error" />
		</div>
		
		<input type="submit" value="Guardar" class="btn btn-success" />
		<a href="${pageContext.request.contextPath}/agenda/contactos"
			 class="btn btn-outline-primary float-right">Volver a la agenda de contactos</a>

	</form:form>
	</div>

	<script src="${pageContext.request.contextPath}/resources/js/main.js">
	</script>
</body>
</html>