/*
 *Codigo Javascript para la seccion Empleados
 *Author: 
 *
 *Last update:
 **/


$(document).ready(function() {
/*
    //Mostrar el menu estilo chrome


    //Crear JTable con listado de productos
    $('#tblEmpleados').jtable({
        title: 'Empleados Registrados',
        paging: true,
        pageSize: 5,
        sorting: true,
        defaultSorting: 'tx_Nombre ASC',
        actions: {
            listAction: 'include/jtable_AccionesEmpleados.php?action=list',
            deleteAction: 'include/jtable_AccionesEmpleados.php?action=delete'
        },
        fields: {
            id_Usuario: {
                title: 'ID',
                key: true,
                list: false,
                edit: false,
                width: '2%'
            },
            tx_Nombre: {
                title: 'Nombre',
                width: '23%',
                display: function(data) {
                    return "<a class=\"editarUsuario\" href=\"include/fancybox_EditarUsuario/index.php?idUsr=" + data.record.id_Usuario + "\" title=\"MODIFICAR DATOS DEL EMPLEADO\" >" + data.record.tx_Nombre + "</a>";
                }
            },
            tx_username: {
                title: 'username',
                width: '15%',
                display: function(data) {
                    return "<a class=\"editarUsuario\" href=\"include/fancybox_EditarUsuario/index.php?idUsr=" + data.record.id_Usuario + "\" title=\"MODIFICAR DATOS DEL EMPLEADO\" >" + data.record.tx_username + "</a>";
                }
            },
            tx_Email: {
                title: 'Correo electronico',
                width: '15%',
                type: 'textarea',
                display: function(data) {
                    return "<a class=\"editarUsuario\" href=\"include/fancybox_EditarUsuario/index.php?idUsr=" + data.record.id_Usuario + "\" title=\"MODIFICAR DATOS DEL EMPLEADO\" >" + data.record.tx_Email + "</a>";
                }
            },
            id_RolUsuario: {
                title: 'Rol',
                width: '10%',
                options: 'include/jtable_OptionsRolesUsuario.php',
                list: true
            },
            id_StatusUsuario: {
                title: 'Estado',
                width: '10%',
                options: 'include/jtable_OptionsEstadosUsuario.php',
                list: true
            },
            dt_FechaRegistro: {
                title: 'Fecha de registro',
                width: '15%',
                type: 'date',
                display: function(data) {
                    return "<a class=\"editarUsuario\" href=\"include/fancybox_EditarUsuario/index.php?idUsr=" + data.record.id_Usuario + "\" title=\"MODIFICAR DATOS DEL EMPLEADO\" >" + data.record.dt_FechaRegistro + "</a>";
                }
            }
        }
    });

    //Load productos list from server
    $('#tblEmpleados').jtable('load');




    //Configurar Plugin FancyBox de JQuery para editar los datos de los empleados
    $(".editarUsuario").fancybox({
        'autoScale': false,
        'transitionIn': 'elastic',
        'transitionOut': 'elastic',
        'overlayOpacity': 0.3,
        'width': 850,
        'height': 460,
        'type': 'iframe',
        afterClose: function() {
            //Al cerrar el plugin fancybox Refrescar la lista de productos en inventario
            $('#tblEmpleados').jtable('load');
            //return;
        },
        helpers: {
            overlay: {
                css: {
                    'background': 'rgba(100,100,100,0.3)'
                }
            }
        }
    });








    //Carga la hora actual del sistema; y la actualiza cada segundo
    //mostrarHora("hrActual");

    $("#frmRegistrarUsuario").validate({
        rules: {
            //A continuacion los nombres de los campos y sus reglas a cumplir 
            tx_nombre: {
                required: true, minlength: 3
            },
            tx_apPaterno: {
                required: true, minlength: 3
            },
            tx_apMaterno: {
                required: true, minlength: 3
            },
            tx_correo: {
                required: true, minlength: 5, email: true
            },
            tx_username: {
                required: true, minlength: 5
            },
            tx_password: {
                required: true, minlength: 5
            },
            tx_password2: {
                required: true, minlength: 5, equalTo: "#tx_password"
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
                minlength: jQuery.format("Su contrase�a como minimo debe tener {0} caracteres.")
            },
            tx_password2: {
                required: "Por favor, repita la contraseña anterior.",
                minlength: jQuery.format("Su contraseña como minimo debe tener {0} caracteres."),
                equalTo: "Por favor, repita la contraseña anterior.",
            }

        }

    });

    //$("#tx_nombre").focus();
    
    //Disparar evento click del enlace que tiene el fancybox
    $("#btnNuevoUsuario").click(function() {
        //$("#btnNuevoUsuario").slideToggle("fast");
        //$("#tblEmpleados").slideToggle("fast");
        $("#listadoEmpleados").slideToggle("slow");
        //alert('Test de JQuery');
        $("#frmRegistrarUsuario").slideToggle("slow");
        $("#tx_nombre").focus();
        
        return false;
    });
    //Disparar evento click del enlace que tiene el fancybox
    $("#btnCancelarAlta").click(function() {
        //$("#btnNuevoUsuario").slideToggle("fast");
        //$("#tblEmpleados").slideToggle("slow");
        $("#listadoEmpleados").slideToggle("slow");
        //alert('Test de JQuery');
        $("#frmRegistrarUsuario").slideToggle("slow");
        return false;
    });
    
*/

});    //Fin de Funcion JQuery
