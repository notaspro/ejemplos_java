<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Maven + Spring MVC | ${message}</title>
		
		<spring:url value="/resources/css/home.css" var="coreCss" />
		<link href="${coreCss}" rel="stylesheet" />
	</head>
	
	<body>
	
		<h2>${message}</h2>
		<p>Bienvenido ${usuario.nombre}</p>
				
		<p>La URL Home del proyecto es: <span class="cssURLs">${urlHome}</span></p>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<spring:url value="/resources/js/home.js" var="coreJs" />
		<script src="${coreJs}"></script>
	
	</body>
</html>