/*
 *Codigo Javascript para la seccion Proveedores
 *Author: 
 *
 *Last update:
 **/


$().ready(function() {
    var f = new Date();

    //Carga la hora actual del sistema; y la actualiza cada segundo
    //mostrarHora("hrActual");


    //Configurar el calendario de JQuery UI
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

    $("#txVentasDe").datepicker({
        minDate: new Date(f.getFullYear() - 100, 1 - 1, 1),
        maxDate: new Date(f.getFullYear(), f.getMonth(), f.getDate()),
        dateFormat: 'dd/mm/yy',
        changeMonth: true,
        changeYear: true
    });

    $("#txVentasA").datepicker({
        minDate: new Date(f.getFullYear() - 100, 1 - 1, 1),
        dateFormat: 'dd/mm/yy',
        maxDate: new Date(f.getFullYear(), f.getMonth(), f.getDate()),
        dateFormat: 'dd/mm/yy',
                changeMonth: true,
        changeYear: true
                //showOn: 'button',
                //buttonImageOnly: true,
                //buttonImage: 'cal.gif'
    });

    $('#reporte1,#reporte2,#reporte3,#reporte4,#reporte5, #reporte6').click(function() {
        //alert($(this).attr("href")+' URL del reporte: '+$(this).attr("urlReporte"));
        var contentDiv = $($(this).attr("href"));
        contentDiv.load($(this).attr("urlReporte"));
    });


    $('#lnkReporte1, #lnkReporte2, #lnkReporte3, #lnkReporte4, #lnkReporte5, #lnkReporte6').click(function() {
        var contentDiv = $($(this).attr("href"));
        contentDiv.load($(this).attr("urlReporte"));
        contentDiv.css("display", "block");
        $("#lnksReportes").css("display", "none");
        $("#msgBienvenida").css("display", "none");
    });



});    //Fin de Funcion JQuery


//Muestra el detalle de ventas de todos los proveedores por mes y año
function ocultarReporte() {
    var contentDiv = $("#contenidoReporte");    
    contentDiv.css("display", "none");
    contentDiv.html('');
    $("#lnksReportes").css("display", "block");
    $("#msgBienvenida").css("display", "block");
}


//Muestra el detalle de ventas de todos los proveedores por mes y año
function reporteXProveedores() {
    var contentDiv = $("#contenidoReporte");
    contentDiv.load("ajax/ajax_ReporteXProveedoresGral.php");
}

//Muestra el detalle de ventas dado un Id de proveedor, mes y año
function detalleReporteXProveedor(anio,mes,prov) {
    var contentDiv = $("#contenidoReporte");
    contentDiv.load("ajax/ajax_ReporteXProveedoresDetalle.php?anio="+anio+"&mes="+mes+"&idProv="+prov);
}

//Muestra el detalle de ventas de todos las categorias por mes y año
function reporteXCategorias() {
    var contentDiv = $("#contenidoReporte");
    contentDiv.load("ajax/ajax_ReporteXCategoriasGral.php");
}

//Muestra el detalle de ventas dado un Id de categoria, mes y año
function detalleReporteXCategoria(anio,mes,cat) {
    var contentDiv = $("#contenidoReporte");
    contentDiv.load("ajax/ajax_ReporteXCategoriasDetalle.php?anio="+anio+"&mes="+mes+"&idCat="+cat);
}


//Muestra el detalle de ventas de todos las categorias por mes y año
function reporteXFechas() {
    var contentDiv = $("#contenidoReporte");
    contentDiv.load("ajax/ajax_ReporteXFechasContenido.php");
}

//Muestra el detalle de ventas dado un Id de categoria, mes y año
function detalleReporteXFecha(diaInicio,diaFin,anio,mes,prod) {
    var contentDiv = $("#contenidoReporteFechas");
    contentDiv.load("ajax/ajax_ReporteXFechasContenidoDetalle.php?anio="+anio+"&mes="+mes+"&idProd="+prod+"&diaInicio="+diaInicio+"&diaFin="+diaFin);
}


//Muestra el detalle de ventas de todos los empleados por mes y año
function reporteXEmpleados() {
    var contentDiv = $("#contenidoReporte");
    contentDiv.load("ajax/ajax_ReporteXEmpleadosGral.php");
}

//Muestra el detalle de ventas dado un Id de empleado, mes y año
function detalleReporteXEmpleado(anio,mes,usr) {
    var contentDiv = $("#contenidoReporte");
    contentDiv.load("ajax/ajax_ReporteXEmpleadosDetalle.php?anio="+anio+"&mes="+mes+"&idUsr="+usr);
}


//Muestra el detalle de ventas de todos los Productos por mes y año
function reporteXProductos() {
    var contentDiv = $("#contenidoReporte");
    contentDiv.load("ajax/ajax_ReporteXProductosGral.php");
}

//Muestra el detalle de ventas dado un Id de Producto, mes y año
function detalleReporteXProducto(anio,mes,prod) {
    var contentDiv = $("#contenidoReporte");
    contentDiv.load("ajax/ajax_ReporteXProductosDetalle.php?anio="+anio+"&mes="+mes+"&idProd="+prod);
}

//Muestra el detalle de ventas canceladas dado un  mes y año
function detalle1ReporteXVentaCanceladas(anio,mes) {
    var contentDiv = $("#detalle1VentasCanceladas");
    contentDiv.load("ajax/ajax_ReporteXVentasCanceladasDetalle1.php?anio="+anio+"&mes="+mes);
}

//Muestra el detalle de ventas canceladas dado un  dia, mes y año
function detalle2ReporteXVentaCanceladas(anio,mes, dia) {
    //alert('test js');
    var contentDiv = $("#detalle2VentasCanceladas");
    contentDiv.load("ajax/ajax_ReporteXVentasCanceladasDetalle2.php?anio="+anio+"&mes="+mes+"&dia="+dia);
}



