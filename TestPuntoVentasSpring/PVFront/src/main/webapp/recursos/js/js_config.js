/*
 *Codigo Javascript para la seccion de configuracion
 *Author: 
 *
 *Last update:
 **/


$().ready(function() {
    //Carga la hora actual del sistema; y la actualiza cada segundo
    //mostrarHora("hrActual");
    
    muestraParametros(1);
});    //Fin de Funcion JQuery

function muestraParametros(idSeccion) {
    
    switch (idSeccion) {
        case 1:
            //alert('home');
            var contentDiv = $("#contenidoParametros");
            contentDiv.load("ajax/ajax_configHome.php");
            break;
        case 2:
            //alert('Datos empresa');
            var contentDiv = $("#contenidoParametros");
            contentDiv.load("ajax/ajax_configDatosEmpresa.php");
            break;
        case 3:
            //alert('Datos App');
            var contentDiv = $("#contenidoParametros");
            contentDiv.load("ajax/ajax_configDatosAplicacion.php");
            break;
        case 4:
            //alert('Datos Logs de acceso');
            var contentDiv = $("#contenidoParametros");
            contentDiv.load("ajax/ajax_configLogsAccesos.php");
            break;
        case 5:
            //alert('Actualizar catalogos');
            var contentDiv = $("#contenidoParametros");
            contentDiv.load("ajax/ajax_configActualizarCatalogos.php");
            break;

    }
    
    //quitar a todos los items la clase active y asignarselo a la seccion que llega
    var i=0;
    for(i=1; i<=6; i++) {
        $("#lnkSeccion"+i).removeClass("active");
        //$("div").("important");
    }
    $("#lnkSeccion"+idSeccion).addClass("active");
    

}

/*
 * @param {type} username
 * @returns {undefined}
 * 
 */
function muestraDetalleLogsUsuario(username) {
    var contentDiv = $("#contenidoReporteLogs");
    contentDiv.slideUp('slow');
    contentDiv.load("ajax/ajax_configMuestraLogsAccesosUsuario.php?tx_username="+username);
    contentDiv.slideDown('fast');
}
