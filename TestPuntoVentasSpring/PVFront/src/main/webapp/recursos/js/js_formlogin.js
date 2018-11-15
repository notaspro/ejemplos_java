/*
 *Codigo Javascript para el registro de un nuevo usuario
 *Author: Gonzalo Silverio  gonzasilve@gmail.com
 *
 *Last update; 14-02-2012
 **/


$().ready(function() {

    $("#frmlogin").validate({
        rules: {
            //A continuacion los nombres de los campos y sus reglas a cumplir 

            usuario: {
                required: true, minlength: 5
            },
            password: {
                required: true, minlength: 5
            }

        },
        //A continuacion los campos y los mensajes en caso de que no se cumplan las reglas 
        messages: {
            usuario: {
                required: "Por favor, escriba el nombre de usuario. .",
                minlength: jQuery.format("Su nombre de usuario como minimo debe tener {0} caracteres.")
            },
            password: {
                required: "Por favor, escriba la contraseña.",
                minlength: jQuery.format("Su contraseña como minimo debe tener {0} caracteres.")
            }

        }

    });



});    //Fin de Funcion JQuery

