/*
 *Codigo Javascript para el registro de un nuevo usuario
 *Author: Gonzalo Silverio  gonzasilve@gmail.com
 *
 *Last update; 14-02-2012
 **/


$().ready(function() {
   
		$("#registrar_usuario").validate({
		rules: {
		//A continuacion los nombres de los campos y sus reglas a cumplir 
			tx_nombre: {
				required: true,	minlength: 3
			},
			tx_apPaterno: {
				required: true, minlength: 3
			},
			tx_apMaterno: {
				required: true,	minlength: 3
			},
			tx_correo: {
				required: true,	minlength: 5, email: true
			},
			tx_username: {
				required: true,	minlength: 5
			},
			tx_password: {
				required: true,	minlength: 5
			},
			tx_password2: {
				required: true,	minlength: 5,	equalTo: "#tx_password"
			}

		},
		//A continuacion los campos y los mensajes en caso de que no se cumplan las reglas 
		messages: {
			tx_nombre: {
				required: "Por favor, escriba su Nombre.",
				minlength: jQuery.format("Su Nombre como minimo debe tener {0} caracteres.")
			},
			tx_apPaterno: {
				required: "Por favor, escriba su Apellido Paterno.",
				minlength: jQuery.format("Su Apellido Paterno como minimo debe tener {0} caracteres.")
			},
			tx_apMaterno: {
				required: "Por favor, escriba su Apellido Materno.",
				minlength: jQuery.format("Su Apellido Materno como minimo debe tener {0} caracteres.")
			},
			tx_correo: {
				required: "Por favor, escriba una direccion de correo electronico valida.",
				minlength: jQuery.format("Por favor, escriba una direccion de correo electronico valida.")
			},
			tx_username: {
				required: "Por favor, escriba un nombre de usuario. Este dato le servira para iniciar sesion y ver el contenido.",
				minlength: jQuery.format("Su nombre de usuario como minimo debe tener {0} caracteres.")
			},
			tx_password: {
				required: "Por favor, escriba una contraseña.",
				minlength: jQuery.format("Su contraseña como minimo debe tener {0} caracteres.")
			},
			tx_password2: {
				required: "Por favor, repita la contraseña anterior.",
				minlength: jQuery.format("Su contraseña como minimo debe tener {0} caracteres."),
				equalTo: "Por favor, repita la contraseña anterior.",
			}

		}

		});

		$("#tx_nombre").focus();

      var btn_CancelarRegistro =$("#btn_CancelarRegistro");
      btn_CancelarRegistro.click(cancela_Registro);


	//Carga la hora actual del sistema; y la actualiza cada segundo
	mostrarHora("hrActual");
	

});    //Fin de Funcion JQuery

//Funcion para el evento click del boton para cancelar
   //el registro de un nuevo usuario
   function cancela_Registro() {
     location="index.php";
   }