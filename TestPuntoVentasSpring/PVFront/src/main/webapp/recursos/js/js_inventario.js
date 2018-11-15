/*
 *Codigo Javascript para la seccion Inventario
 *Author: 
 *
 *Last update:
 **/
$().ready(function() {
    //Carga la hora actual del sistema; y la actualiza cada segundo
    mostrarHora("hrActual");

    //Configurar boton para que al dar click en el boton Registrar aparezca el paso 2
    var btnRegistrar = $('#btnRegistrar');
    //Asignar funcion controladora a evento click del enlace 1
    btnRegistrar.click(muestraPaso2);

    //Configurar el boton cancelar
    var btnLimpiar = $('#btnLimpiar');
    btnLimpiar.click(function() {
        //Limpiar campos del formulario
        $('#frm')[0].reset();
    });


    //Configurar boton para que al dar click en el boton Volver (en paso 2) aparezca el paso 1
    var btnVolver = $('#btnVolver');
    //Asignar funcion controladora a evento click del enlace 1
    btnVolver.click(muestraPaso1);




    //Crear JTable con listado de productos
    $('#tblProductos').jtable({
        title: 'Productos en inventario',
        paging: true,
        pageSize: 5,
        sorting: true,
        defaultSorting: 'tx_nombre ASC',
        actions: {
            listAction: 'include/jtable_AccionesProductos.php?action=list',
            deleteAction: 'include/jtable_AccionesProductos.php?action=delete'
        },
        fields: {
            id_Producto: {
                title: 'ID',
                key: true,
                list: true,
                edit: false,
                width: '2%'
            },
            tx_CodigoBarras: {
                title: 'Codigo de barras',
                display: function(data) {
                    return "<a class=\"editarProducto\" href=\"include/fancybox_EditarProducto/index.php?idProd=" + data.record.id_Producto + "\" title=\"Modificar\" >" + data.record.tx_CodigoBarras + "</a>";
                }
            },
            tx_nombre: {
                title: 'Nombre',
                display: function(data) {
                    return "<a class=\"editarProducto\" href=\"include/fancybox_EditarProducto/index.php?idProd=" + data.record.id_Producto + "\" title=\"Modificar\" >" + data.record.tx_nombre + "</a>";
                }
            },
            tx_descripcion: {
                title: 'Descripcion',
                width: '23%',
                type: 'textarea',
                display: function(data) {
                    return "<a class=\"editarProducto\" href=\"include/fancybox_EditarProducto/index.php?idProd=" + data.record.id_Producto + "\" title=\"Modificar\" >" + data.record.tx_descripcion + "</a>";
                }
            },
            precioCompra: {
                title: 'Precio de compra',
                display: function(data) {
                    return "<a class=\"editarProducto\" href=\"include/fancybox_EditarProducto/index.php?idProd=" + data.record.id_Producto + "\" title=\"Modificar\" >" + data.record.precioCompra + "</a>";
                }
            },
            id_Categoria: {
                title: 'Categoria',
                options: 'include/jtable_OptionsCategorias.php',
                list: true
            },
            dt_FechaRegistro: {
                title: 'Fecha de registro',
                type: 'date',
                edit: false
            }
        }
    });

    //Load productos list from server
    $('#tblProductos').jtable('load');




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
                $("#tx_CodigoBarras").focus();
            }
            if (active == 2) {
                $("#tx_BCodigoBarras").focus();
            }

        }

    });





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

    //Configurar Plugin FancyBox de JQuery para editar los productos
    $(".editarProducto").fancybox({
        'autoScale': false,
        'transitionIn': 'elastic',
        'transitionOut': 'elastic',
        'overlayOpacity': 0.3,
        'width': 850,
        'height': 460,
        'type': 'iframe',
        afterClose: function() {
            //Al cerrar el plugin fancybox Refrescar la lista de productos en inventario
            $('#tblProductos').jtable('load');
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



//Configurar la fecha de caducidad
    $("#fechaCaducidad").datepicker({
        minDate: new Date(f.getFullYear(), f.getMonth(), f.getDate()),
        dateFormat: 'yy/mm/dd',
        changeMonth: true,
        changeYear: true
    });






    //Configurar Plugin FancyBox de JQuery
    $("#buscarProveedor").fancybox({
        'autoScale': false,
        'transitionIn': 'elastic',
        'transitionOut': 'elastic',
        'overlayOpacity': 0.3,
        'width': 650,
        'height': 460,
        'type': 'iframe',
        afterClose: function() {
            //Al cerrar el plugin fancybox Refrescar la lista de productos en inventario
            //$('#tblProductos').jtable('load');
            return;
        },
        helpers: {
            overlay: {
                css: {
                    'background': 'rgba(100,100,100,0.3)'
                }
            }
        }
    });

    //Disparar evento click del enlace que tiene el fancybox
    $("#btnBuscarProveedor").click(function() {
        $("#buscarProveedor").trigger('click');
        return false;
    });


    //Configurar Plugin FancyBox de JQuery para mostrarlo al Pulsar el Boton 'Buscar en Catalogo'
    $("#buscarProducto").fancybox({
        'autoScale': false,
        'transitionIn': 'elastic',
        'transitionOut': 'elastic',
        'overlayOpacity': 0.3,
        'width': 650,
        'height': 460,
        'type': 'iframe',
        afterClose: function() {
            //Al cerrar el plugin fancybox Refrescar la lista de productos en inventario
            //$('#tblProductos').jtable('load');
            return;
        },
        helpers: {
            overlay: {
                css: {
                    'background': 'rgba(100,100,100,0.3)'
                }
            }
        }
    });

    //Disparar evento click del enlace que tiene el fancybox
    $("#btnBuscarPorCatalogo").click(function() {
        $("#buscarProducto").trigger('click');
        return false;
    });



    //Configurar Plugin FancyBox de JQuery para mostrarlo al Pulsar el Boton 'Buscar en Catalogo'
    $("#programarPagos").fancybox({
        'autoScale': false,
        'transitionIn': 'elastic',
        'transitionOut': 'elastic',
        'overlayOpacity': 0.3,
        'width': 700,
        'height': 400,
        'type': 'iframe',
        afterClose: function() {
            //Al cerrar el plugin fancybox Refrescar la lista de productos en inventario
            //$('#tblProductos').jtable('load');
            return;
        },
        helpers: {
            overlay: {
                css: {
                    'background': 'rgba(100,100,100,0.3)'
                }
            }
        }
    });

    //Disparar evento click del enlace que tiene el fancybox
    $("#btnAbonar").click(function() {
        $("#programarPagos").trigger('click');
        return false;
    });


    /*Al elegir el check de codigo de barras enfocar la caja de texto */
    $("#buscarPorCodigo").click(function() {
        $("#f_buscarPorCatalogo").hide();
        $("#f_buscarPorCodigo").slideDown("fast");
        $('#tx_BCodigoBarras').focus();
    });

    /*Al elegir el check de codigo de barras enfocar la caja de texto */
    $("#buscarPorCatalogo").click(function() {
        $("#f_buscarPorCodigo").hide();
        $("#f_buscarPorCatalogo").slideDown("fast");


    });

    $("#f_buscarPorCodigo").slideDown("fast");


    var miTabla = $('#tblProductosComprar').dataTable({
        "bJQueryUI": true,
        "sPaginationType": "full_numbers",
        "oLanguage": {
            "sUrl": "ajax/json_datatables_esMX.txt"
        },
        "bFilter": false
    });


    //Configurar el click del boton Agregar
    $("#btnBuscarCodigoBarras").click(function() {

        //Obtener el precio de venta en base al codigo de barras
        var parametros = {tx_BCodigoBarras: $('#tx_BCodigoBarras').val()};
        $.ajax({
            type: "POST",
            url: "ajax/ajax_GetProductoByCodigoBarras.php",
            data: parametros,
            async: true,
            success: function(datos) {
                var dataJson = eval(datos);

                if (dataJson[0] == null) {
                    alert("El codigo de barras  no coincide con ningun producto registrado.");
                    $('#tx_BCodigoBarras').focus();
                    return;
                }
                //Actualizar los datos del producto buscado
                $('#tx_NombreProducto').val(dataJson[0].tx_nombre);

            },
            error: function(obj, error, objError) {
                //avisar que ocurrió un error
                alert('No se pudo calcular el Precio al publico!\n Verifique que a elegido una categoria');
            }
        });

        return false;
    });


    //Configurar el click del boton Agregar
    $("#btnAgregarProducto").click(function() {


        if ($('#tx_NombreProveedor').val() == '') {
            alert("Especifique a que proveedor esta comprando.");
            //$('#btnBuscarProveedor').focus();
            return false;
        }

        if ($('#tx_NombreProducto').val() == '') {
            alert("Especifique el producto que desea comprar");
            $('#tx_BCodigoBarras').focus();
            return false;
        }

        if ($('#tx_CantidadProducto').val() == '') {
            alert("Especifique la cantidad de producto que desea comprar");
            $('#tx_CantidadProducto').focus();
            return false;
        }

        if ($('#tx_CaducidadProducto').val() == '') {
            alert("Especifique la caducidad del producto.");
            $('#tx_CaducidadProducto').focus();
            return false;
        }

        if ($('#tx_PrecioCompra2').val() == '') {
            alert("Especifique el precio unitario del producto.");
            $('#tx_PrecioCompra2').focus();
            return false;
        }


        //Obtener el precio de venta en base al codigo de barras
        var parametros = {id_Proveedor: $('#id_Proveedor2').val(), tx_BCodigoBarras: $('#tx_BCodigoBarras').val(), tx_NombreProducto: $('#tx_NombreProducto').val(), tx_CantidadProducto: $('#tx_CantidadProducto').val(), tx_CaducidadProducto: $('#tx_CaducidadProducto').val(), tx_PrecioCompra2: $('#tx_PrecioCompra2').val(), tx_ClaveCompra: $('#tx_ClaveCompra').val()};
        $.ajax({
            type: "POST",
            url: "ajax/ajax_GuardaProductoCompra.php",
            data: parametros,
            async: true,
            success: function(datos) {
                var dataJson = eval(datos);
                //Redireccionar al usuario a la lista de productos
                if (dataJson[0].status == 'ERROR')
                    alert(dataJson[1].errorDesc)

                if (dataJson[0].status == 'OK') {
                    //alert(dataJson[1].query);
                    location = "index.php?page=inventario&cid=" + $('#tx_ClaveCompra').val();

                }


            },
            error: function(obj, error, objError) {
                //avisar que ocurrió un error
                alert('No se pudo calcular el Precio al publico!\n Verifique que a elegido una categoria');
            }
        });

        return false;
    });


    $("#tx_CaducidadProducto").datepicker({
        minDate: new Date(f.getFullYear(), f.getMonth(), f.getDate()),
        dateFormat: 'yy/mm/dd',
        changeMonth: true,
        changeYear: true
    });

    //validar solo numeros en la cantidad (funcion definida en js_default.js
    $("#tx_CantidadProducto").forzarSoloNumeros();

    //validar solo numeros en el precio de compra con el proveedor
    $("#tx_PrecioCompra2").forzarSoloNumeros();
    //Solo numeros en el descuento
    $("#descuentoCompra").forzarSoloNumeros();

    //Recalcular el total al cambiar el descuento
    $("#descuentoCompra").keyup(function() {
        var descuento = 0.0;
        var tmp = 0;

        var subtotal = parseFloat($('#subtotalCompra').val());
        tmp = parseInt($('#descuentoCompra').val());
        descuento = tmp / 100;
        var descNeto = subtotal * descuento;
        var total = (subtotal - descNeto);
        $('#totalAPagar').val(total.toFixed(2));


        //return false;
    });

    //Programar el boton Pagar
    $("#btnPagar").click(function() {
        //alert('Se intento pagar.');

        var proveedor = $('#id_Proveedor2').val();
        if (proveedor == '') {
            alert('Por favor seleccione el proveedor al que esta comprando');
            return false;
        }

        var descuentoCompra = $('#descuentoCompra').val();
        if (descuentoCompra == '') {
            $('#descuentoCompra').val('0');
        }

        var idFormaPago = $('#id_FormaPago').val();
        if (idFormaPago == 0) {
            alert('Por favor seleccione una forma de pago');
            return false;
        }


        var parametros = {id_Proveedor2: $('#id_Proveedor2').val(), txNumeroFactura: $('#txNumeroFactura').val(), tx_ClaveCompra: $('#tx_ClaveCompra').val(), descuentoCompra: $('#descuentoCompra').val(), id_FormaPago: $('#id_FormaPago').val()};
        $.ajax({
            type: "POST",
            url: "ajax/ajax_GuardarCompra.php",
            data: parametros,
            async: true,
            success: function(datos) {
                var dataJson = eval(datos);

                if (dataJson[0].status == 'ERROR') {
                    alert(dataJson[1].errorDesc);
                    return;
                }
                if (dataJson[0].status == 'OK') {
                    alert(dataJson[1].statusDesc);
                    //Redireccionar al inventario
                    location = "index.php?page=inventario";

                }



            },
            error: function(obj, error, objError) {
                //avisar que ocurrió un error
                alert('No se pudo registrar la compra!\n Intente mas tarde, si continua el problema contacte con el administrador.');
            }
        });
        return false;
    });

});    //Fin de Funcion JQuery





//Muestra Los campos del paso 1
function muestraPaso1() {
    $('#frmAltaProducto').show();
    //Ocultar campos del paso 2
    $('#frmPaso2').hide("fast");

}



//Muestra los campos del paso 2
function muestraPaso2() {

    //Validaciones previas para poder calcular el precio al publico
    if ($('#id_Categoria').val() == 0) {
        //alert("Por favor seleccione una Categoria ");
        $('#id_Categoria').focus();
        return;
    }

    if ($('#id_Proveedor').val() == 0) {
        //alert("Por favor seleccione un Proveedor");
        $('#id_Proveedor').focus();
        return;
    }

    if ($('#precioCompra').val() == 0) {
        //alert("Por favor escriba el precio de compra con el proveedor");
        return;
    }



    $('#frmAltaProducto').hide();
    //Copiar el codigo de barras
    $('#tx_CodigoBarras2').val($('#tx_CodigoBarras').val());

    //Obtener el precio de venta en base al codigo de barras
    var parametros = {id_Categoria: $('#id_Categoria').val(), precioCompra: $('#precioCompra').val()};
    $.ajax({
        type: "POST",
        url: "ajax/ajax_GetPrecioProducto.php",
        data: parametros,
        async: true,
        success: function(datos) {
            var dataJson = eval(datos);

            //if( dataJson[0].precioPublico > 0) {
            //alert('Precio al publico: '+dataJson[0].precioPublico);
            $('#precioVenta').val(dataJson[0].precioPublico);
            //}

        },
        error: function(obj, error, objError) {
            //avisar que ocurrió un error
            alert('No se pudo calcular el Precio al publico!\n Verifique que a elegido una categoria');
        }
    });

    //Mostrar los campos del paso 2
    $('#frmPaso2').show("fast");

    //Enfocar campo de cantidad
    $('#txCantidad').focus();

    //Cancelar en envio del formilario
    return false;
}


//Muestra Los detalles de un producto para editarlo
function editarProducto(id_Prod) {
    alert("Id del producto a editar: " + id_Prod);

}

//Funcion para eliminar un producto en la ficha de actualizar inventario
function eliminarProductoComprado(codigoBarras, claveCompra) {

    //Confirmar si se desea eliminar
    var pregunta = confirm("Confirma que desea quitar este producto?");
    if (!pregunta)
        return false;   //No continuar


    //Obtener el precio de venta en base al codigo de barras
    var parametros = {codigoBarras: codigoBarras, claveCompra: claveCompra};
    $.ajax({
        type: "POST",
        url: "ajax/ajax_EliminarProductoCompra.php",
        data: parametros,
        async: true,
        success: function(datos) {
            //var dataJson = eval(datos);
            //Recargar los datos y mandar la clave de la sesion de compra
            location = "index.php?page=inventario&cid=" + claveCompra;


        },
        error: function(obj, error, objError) {
            //avisar que ocurrió un error
            alert('No se pudo eliminar el producto');
        }
    });


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