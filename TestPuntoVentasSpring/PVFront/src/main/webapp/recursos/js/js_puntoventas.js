/*
 *Codigo Javascript para la seccion del Punto de Ventas
 *Author: 
 *
 *Last update:
 **/


$().ready(function() {

    //Carga la hora actual del sistema; y la actualiza cada segundo
    //mostrarHora("hrActual");


    //Obtener la fecha actual del programa cliente
    var f = new Date();
    //Configurar Control calendario de JQuery
    $.datepicker.regional['es'] = {
        closeText: 'Cerrar',
        prevText: '&#x3c;Ant',
        nextText: 'Sig&#x3e;',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Jue', 'Vie', 'S&aacute;b'],
        dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'S&aacute;'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        yearRange: '1910:2050',
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
    };
    $.datepicker.setDefaults($.datepicker.regional['es']);
    

    //Crear tabs con JQuery
    $("#fichas").tabs({
        load: function(event, ui) {
            //$("#tx_nota").focus();
            //Inicializar el evento click del boton Guardar
            //var botonGuardar = $("#btn_GuardarNota");
            //botonGuardar.click(guardarNota);

        },
        activate: function(event, ui) {
            var active = $("#fichas").tabs("option", "active");
            //alert($("#fichas ul>li a").eq(active).attr('href')); 
            //alert("ficha activa: "+active);
            if (active == 1) {
                $("#tx_NombreCliente").focus();
            }
            if (active == 2) {
                //$("#tx_BCodigoBarras").focus();
            }

        }

    });



    //No permitir cambiar el nombre del empleado que esta vendiendo
    $("#tx_NombreEmpleado").keypress(function() {
        return false;
    });

    //No permitir cambiar la fecha de registro de la venta
    $("#dt_FechaRegistro").keypress(function() {
        return false;
    });

    //No permitir cambiar el numero de factura
    $("#txNumeroFactura").keypress(function() {
        return false;
    });

    var miTabla = $('#tblProductosVender').dataTable({
        "bJQueryUI": true,
        "sPaginationType": "full_numbers",
        "oLanguage": {
            "sUrl": "ajax/json_datatables_esMX.txt"
        },
        "bFilter": false
    });


    //Accion al pulsar en el boton Buscar (Buscar producto)
    $("#btnBuscarProducto").click(function() {
        $('#tx_CantidadStock').val('');
        $('#tx_NombreProducto').val('');
        $("#tx_CantidadProducto").val('');

        if ($.trim($('#tx_CodigoBarraProducto').val()) == '') {
            alert("Escriba el codigo de barras del producto que desea buscar.");
            $('#tx_CodigoBarraProducto').focus();
            return false;
        }

        //Obtener el precio de venta en base al codigo de barras
        var parametros = {tx_CodigoBarraProducto: $("#tx_CodigoBarraProducto").val()};
        $.ajax({
            type: "POST",
            url: "ajax/ajax_GetProductoByCodigoBarras2.php",
            data: parametros,
            async: true,
            success: function(datos) {
                var dataJson = eval(datos);


                if (dataJson[0].producto[0] == null) {
                    alert("El codigo de barras  no coincide con ningun producto registrado.");
                    $('#tx_CodigoBarraProducto').focus();
                    return;
                }
                //Actualizar los datos del producto buscado
                $('#tx_NombreProducto').val(dataJson[0].producto[0].tx_nombre);
                $('#tx_CantidadStock').val(dataJson[0].producto[0].cantidad);
                //Mostrar la vista previa del producto
                $('#vistaPreviaProducto').html(dataJson[1].vistaPreviaProducto);
                //var opcion = 'Caja';
                var idopcion = dataJson[0].producto[0].tx_TipoVentaProducto;
                //$("#id_TipoVentaProducto option:contains('"+opcion+"')").val();
                $("select#id_TipoVentaProducto option").each(function() {
                    this.selected = (this.text == idopcion);
                });

            },
            error: function(obj, error, objError) {
                //avisar que ocurrió un error
                alert('No se pudo buscar el producto por el nombre!\n Intente de nuevo mas tarde');
            }
        });

        return false;
    });

    //Restringir a que no se pueda vender mas del producto que hay en stock
    $("#tx_CantidadProducto").keyup(function() {
        //alert('Prueba ');
        var stock = parseInt($("#tx_CantidadStock").val());
        var cantVender = parseInt($("#tx_CantidadProducto").val());
        var nombre = $("#tx_NombreProducto").val();

        if (cantVender > stock) {
            alert('No hay suficiente producto en Stock.\nComo maximo puede vender ' + stock + ' unidades de ' + nombre);
            $("#tx_CantidadProducto").val(stock);
            $("#tx_CantidadProducto").focus();
        }

    });

    //Al escribir el nombre del producto borrar los datos de algun producto buscado previamente
    $("#tx_CodigoBarraProducto").keyup(function() {

        $('#tx_CantidadStock').val('');
        $('#tx_NombreProducto').val('');
        $("#tx_CantidadProducto").val('');

    });


    //Configurar el click del boton Agregar
    $("#btnAgregar").click(function() {


        if ($('#tx_NombreCliente').val() == '') {
            alert("Escriba el nombre del cliente.");
            $('#tx_NombreCliente').focus();
            return false;
        }

        if ($('#tx_CodigoBarraProducto').val() == '') {
            alert("Especifique el producto que el cliente desea comprar");
            $('#tx_CodigoBarraProducto').focus();
            return false;
        }

        if ($('#tx_NombreProducto').val() == '' && $('#tx_CodigoBarraProducto').val() != '') {
            //alert("Especifique el precio unitario del producto.");
            $("#btnBuscarProducto").trigger('click');
            //$('#tx_CodigoBarraProducto').focus();
            return false;
        }

        if ($('#id_TipoVentaProducto').val() == 0) {
            alert("Especifique el tipo de unidad a vender de este producto.");
            $('#id_TipoVentaProducto').focus();
            return false;
        }

        if ($('#tx_CantidadProducto').val() == '') {
            alert("Especifique la cantidad de producto a vender");
            $('#tx_CantidadProducto').focus();
            return false;
        }


        //Obtener el precio de venta en base al codigo de barras
        var parametros = {txNumeroFactura: $('#txNumeroFactura').val(), tx_NombreCliente: $('#tx_NombreCliente').val(), tx_NombreProducto: $('#tx_NombreProducto').val(), tx_CodigoBarraProducto: $('#tx_CodigoBarraProducto').val(), id_TipoVentaProducto: $('#id_TipoVentaProducto').val(), tx_CantidadProducto: $('#tx_CantidadProducto').val(), tx_ClaveVenta: $('#tx_ClaveVenta').val()};
        $.ajax({
            type: "POST",
            url: "ajax/ajax_GuardaProductoVenta.php",
            data: parametros,
            async: true,
            success: function(datos) {
                var dataJson = eval(datos);
                //Redireccionar al usuario a la lista de productos
                if (dataJson[0].status == 'ERROR') {
                    alert(dataJson[1].errorDesc)
                }

                if (dataJson[0].status == 'OK') {
                    //alert(dataJson[1].query);
                    location = "index.php?page=puntoventas&vid=" + $('#tx_ClaveVenta').val();
                }


            },
            error: function(obj, error, objError) {
                //avisar que ocurrió un error
                alert('No se pudo agregar este producto al ticket actual!\n Verifique los datos e intente nuevamente');
            }
        });

        return false;
    });

    $("#txImporte").forzarSoloNumeros();
    //Convertir a flotante el importe total y agregar 2 cifras decimales
    if (parseFloat($('#txTotalAPagar').val()) > 0) {
        $('#txTotalAPagar').val(parseFloat($('#txTotalAPagar').val()).toFixed(2));
    }
    //Calcular el cambio a devolver al escribir el dinero recibido por el cliente
    $("#txImporte").keyup(function() {
        var total = 0.0;
        var cambio = 0.0;
        var importe = 0.0;

        total = parseFloat($('#txTotalAPagar').val());
        importe = parseFloat($('#txImporte').val());

        if (importe > 0 && total > 0) {
            if (importe < total) {
                $('#txCambio').val('$ insuficiente');
            }

            if (importe >= total) {
                cambio = importe - total;
                $('#txCambio').val(cambio.toFixed(2));
            }

        }

    });

    //No permitir teclear total a Pagar (calculado en automatico)
    $("#txTotalAPagar").keypress(function() {
        return false;
    });

    //No permitir teclear el cambio a devolver al cliente (calculado en automatico)
    $("#txCambio").keypress(function() {
        return false;
    });




    //Accion al pulsar en el boton Cancelar venta
    $("#btnCancelarVenta").click(function() {

        if ($('#txTotalAPagar').val() == '') {
            return false;
        }
        //Confirmar si se desea eliminar
        var pregunta = confirm("Confirma que desea cancelar esta venta?");
        if (!pregunta)
            return false;   //No continuar


        //Obtener el precio de venta en base al codigo de barras
        var parametros = {tx_ClaveVenta: $('#tx_ClaveVenta').val()};
        $.ajax({
            type: "POST",
            url: "ajax/ajax_CancelarVenta.php",
            data: parametros,
            async: true,
            success: function(datos) {
                var dataJson = eval(datos);

                location = "index.php?page=puntoventas";

            },
            error: function(obj, error, objError) {
                //avisar que ocurrió un error
                alert('No se pudo buscar el producto por el nombre!\n Intente de nuevo mas tarde');
            }
        });

        return false;
    });


    //Programar el boton Pagar
    $("#btnVender").click(function() {

        if ($('#tx_NombreCliente').val() == '') {
            alert("Escriba el nombre del cliente.");
            $('#tx_NombreCliente').focus();
            return false;
        }

        if ($('#txNumeroFactura').val() == '') {
            alert("Hay un problema con el numero de factura. Contacte con el administrador.");
            $('#txNumeroFactura').focus();
            return false;
        }

        var totalPagar = $('#txTotalAPagar').val();
        if (totalPagar == '') {
            alert('Cero productos en esta venta');
            return false;
        }

        var importe = $('#txImporte').val();
        if (importe == '') {
            alert('No ha especificado cuanto efectivo recibio del cliente.\nPor favor capture el importe.');
            $('#txImporte').focus();
            return false;
        }

        importe = 0.0;
        importe = parseFloat($('#txImporte').val());
        if (importe <= 0) {
            alert('Importe no valido, por favor corrija el importe.');
            $('#txImporte').focus();
            return false;
        }

        totalPagar = parseFloat($('#txTotalAPagar').val());
        if (importe < totalPagar) {
            alert('Importe no suficiente para realizar la compra.');
            $('#txImporte').focus();
            return false;
        }


        var parametros = {txNumeroFactura: $('#txNumeroFactura').val(), tx_NombreCliente: $('#tx_NombreCliente').val(), txTotalAPagar: $('#txTotalAPagar').val(), txImporte: $('#txImporte').val(), txCambio: $('#txCambio').val(), tx_ClaveVenta: $('#tx_ClaveVenta').val()};
        $.ajax({
            type: "POST",
            url: "ajax/ajax_GuardarVenta.php",
            data: parametros,
            async: true,
            success: function(datos) {
                var dataJson = eval(datos);
                //Si es un mensaje de error mostrarlo tambien
                if (dataJson[0].status == 'ERROR') {
                    alert(dataJson[1].errorDesc);
                    return;
                }
                if (dataJson[0].status == 'OK') {
                    
                    //alert(dataJson[1].statusDesc+" "+dataJson[2].tx_ClaveVenta);
                    
                    //Genera el PDF del ticket y los muestra por pantalla                    
                    window.open ("resources/mostrarTicket.php?claveTicket="+dataJson[2].tx_ClaveVenta,"Imprimir Ticket","menubar=1,resizable=1,width=450,height=540");

                    //Redireccionar para hacer una nueva venta
                    location = "index.php?page=puntoventas";
                    
                }

            },
            error: function(obj, error, objError) {
                //avisar que ocurrió un error
                alert('No se pudo registrar la compra!\n Intente mas tarde, si continua el problema contacte con el administrador.');
            }
        });
        return false;
    });



    //Configurar Plugin FancyBox de JQuery para mostrar la ventas pendientes
    $(".verVentasPendientes").fancybox({
        'autoScale': false,
        'transitionIn': 'elastic',
        'transitionOut': 'elastic',
        'overlayOpacity': 0.3,
        'width': 650,
        'height': 300,
        'type': 'iframe',
        afterClose: function() {
            //Al cerrar el plugin fancybox Refrescar la lista de productos en inventario
            //$('#tblProductos').jtable('load');
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
    
    //Enfocar caja de nombre del cliente
    $("#tx_NombreCliente").focus();
    
    //En la caja del producto solo se permiten numeros
    $("#tx_CodigoBarraProducto").forzarSoloNumeros();
    
    
    
    
    
    
    
    //Javascript para los controles del corte de caja
//Configurar caja de limite inferior del reporte
    $("#dt_ReporteDesde").datepicker({
        minDate: new Date(f.getFullYear() - 100, 1 - 1, 1),
        maxDate: new Date(f.getFullYear(), f.getMonth(), f.getDate()),
        dateFormat: 'yy/mm/dd',
        changeMonth: true,
        changeYear: true
    });


//Configurar caja de limite superior del reporte
    $("#dt_ReporteHasta").datepicker({
        minDate: new Date(f.getFullYear() - 100, 1 - 1, 1),
        maxDate: new Date(f.getFullYear(), f.getMonth(), f.getDate()),
        dateFormat: 'yy/mm/dd',
        changeMonth: true,
        changeYear: true
    });
    

    //Programar el boton Vista Previa (del reporte de corte de caja)
    $("#btnVistaPreviaReporte").click(function() {
        
        //recoger el ambito del reporte
        var ambitoReporte = $('#id_AmbitoReporte').val();
        
        //recoger las fechas del rango
        var fechaDesde = $('#dt_ReporteDesde').val();
        var fechaHasta = $('#dt_ReporteHasta').val();
        
        var scriptReporte = "";
        if ($('#id_AmbitoReporte').val() == 0) {
            //Sino selecciono opcion 1 entonces Revisar que haya indicado un rango            
            if (fechaDesde == '') {
                alert('Por Indique desde que fecha desea ver el reporte');
                $('#dt_ReporteDesde').focus();
                return false;
            }
            
            if (fechaHasta == '') {
                alert('Por Indique hasta que fecha desea ver el reporte');
                $('#dt_ReporteHasta').focus();
                return false;
            }            
            scriptReporte = "ajax/ajax_CorteCajaReporteGral.php";
            //return false;
        }
        
        //Si eligio algo del primer ambito
        if ($('#id_AmbitoReporte').val() != 0) {
             $('#dt_ReporteDesde').val('');
             $('#dt_ReporteHasta').val('');
             scriptReporte = "ajax/ajax_CorteCajaReporteGral.php";
        }
        
        if ( $("#TipoReporte2").is(":checked") == true ) {
            //alert('Script de detalle debe ejecutarse');
            scriptReporte = "ajax/ajax_CorteCajaReporteDetalle.php";
        }

        $('#vistaPreviaReporte').html('');
        var objPreviaReporte = $('#vistaPreviaReporte');
        objPreviaReporte.load(''+scriptReporte+'?dt_ReporteDesde='+fechaDesde+'&dt_ReporteHasta='+fechaHasta+"&id_AmbitoReporte="+ambitoReporte);

        return false;

    }); //Fin de Click del boton de Vista Previa
    
    

    //Programar el boton Imprimir (del reporte de corte de caja)
    $("#btnImprimirReporte").click(function() {
        
        //recoger el ambito del reporte
        var ambitoReporte = $('#id_AmbitoReporte').val();
        
        //recoger las fechas del rango
        var fechaDesde = $('#dt_ReporteDesde').val();
        var fechaHasta = $('#dt_ReporteHasta').val();
        var scriptReporte = "resources/imprimirReporteGral.php";
        
        if ($('#id_AmbitoReporte').val() == 0) {
            //Sino selecciono opcion 1 entonces Revisar que haya indicado un rango            
            if (fechaDesde == '') {
                alert('Por Indique desde que fecha desea imprimir el reporte');
                $('#dt_ReporteDesde').focus();
                return false;
            }
            
            if (fechaHasta == '') {
                alert('Por Indique hasta que fecha desea imprimir el reporte');
                $('#dt_ReporteHasta').focus();
                return false;
            }

        }
        
        //Si eligio algo del primer ambito
        if ($('#id_AmbitoReporte').val() != 0) {
             $('#dt_ReporteDesde').val('');
             $('#dt_ReporteHasta').val('');
        }
        
        //Si esta marcado el radio de reporte detallado, cambiar el script
        if ( $("#TipoReporte2").is(":checked") == true ) {
            //alert('Script de detalle debe ejecutarse');
            scriptReporte = "resources/imprimirReporteDetalle.php";
        }


        if($('#id_AmbitoReporte').val()==0) {
            var urlReporte = scriptReporte+"?dt_ReporteDesde="+fechaDesde+"&dt_ReporteHasta="+fechaHasta;
            window.open (urlReporte,"Imprimir Reporte","menubar=1,resizable=1,width=800,height=800");
        } else {
            var urlReporte = scriptReporte+"?id_AmbitoReporte="+ambitoReporte;
            window.open (urlReporte,"Imprimir Reporte","menubar=1,resizable=1,width=800,height=800");
        }


        return false;

    }); //Fin de Click del boton de Imprimir
    
    
});    //Fin de Funcion JQuery



//Funcion para eliminar un producto que ya ha sido vendido
function eliminarProductoVendido(codigoBarras, claveVenta) {

    //Confirmar si se desea eliminar
    var pregunta = confirm("Confirma que desea quitar este producto?");
    if (!pregunta)
        return false;   //No continuar


    //Obtener el precio de venta en base al codigo de barras
    var parametros = {codigoBarras: codigoBarras, claveVenta: claveVenta};
    $.ajax({
        type: "POST",
        url: "ajax/ajax_EliminarProductoVenta.php",
        data: parametros,
        async: true,
        success: function(datos) {
            //var dataJson = eval(datos);
            //Recargar los datos y mandar la clave de la sesion de compra
            location = "index.php?page=puntoventas&vid=" + claveVenta;


        },
        error: function(obj, error, objError) {
            //avisar que ocurrió un error
            alert('No se pudo eliminar el producto');
        }
    });


}



//Funcion para Ocultar la vista previa del reporte y mostrar los botones por default nuevamente
function ocultarVistaPreviaReporte() {
    $('#vistaPreviaReporte').html('');
    var objPreviaReporte = $('#vistaPreviaReporte');
    objPreviaReporte.load('ajax/ajax_CorteCajaBotonesDefault.php');
    return false;
}

// Forzar a que solo se permita introducir numero
jQuery.fn.forzarSoloNumeros =
        function()
        {
            return this.each(function()
            {
                $(this).keydown(function(e)
                {
                    var key = e.charCode || e.keyCode || 0;
                    // allow backspace, tab, delete, arrows, numbers and keypad numbers ONLY
                    // home, end, period, and numpad decimal
                    return (
                            key == 8 ||
                            key == 9 ||
                            key == 46 ||
                            key == 110 ||
                            key == 190 ||
                            (key >= 35 && key <= 40) ||
                            (key >= 48 && key <= 57) ||
                            (key >= 96 && key <= 105));
                });
            });
        };