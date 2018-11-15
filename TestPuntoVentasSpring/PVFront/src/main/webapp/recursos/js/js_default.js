/*
 *Script  que se incluye en todas las secciones del micrositio
 *
 *Author: Gonzalo Silverio - gonzasilve@hotmail.com 
 *
 *Last update: 22-09-2014
 **/

$(document).ready(function() {

    //Mostrar de forma animada el contenido de la seccion 
    mostrar_capa(seccion, animacion, velocidad);

    
});    //Fin de Funcion JQuery

function mostrar_capa(nom_capa, animacion, velocidad) {

    //alert(nom_capa);
    switch (animacion) {
        case "slideToggle":
            $("#capa_" + nom_capa).slideToggle(velocidad);
            break;
        case "fadeToggle":
            $("#capa_" + nom_capa).fadeToggle(velocidad);
            break;
        case "fadeIn":
            $("#capa_" + nom_capa).fadeIn(velocidad);
            break;
        case "fadeOut":
            $("#capa_" + nom_capa).fadeOut(velocidad);
            break;
        case "slideDown":
            $("#capa_" + nom_capa).slideDown(velocidad);
            break;
        case "slideUp":
            $("#capa_" + nom_capa).slideUp(velocidad);
            break;
            //alert(nom_capa+" "+animacion+" "+velocidad );
    }


}

//Muestra la hora actual en una etiqueta especificada (un id de span o div)
//Fuente: http://www.efectosjavascript.com/reloj3.html
function mostrarHora(idEtiqueta) {
    var Digital = new Date();
    var hours = Digital.getHours();
    var minutes = Digital.getMinutes();
    var seconds = Digital.getSeconds();
    var dn = "A.M.";
    if (hours > 12) {
        dn = "P.M.";
        hours = hours - 12;
    }
    if (hours == 0)
        hours = 12;
    if (minutes <= 9)
        minutes = "0" + minutes;
    if (seconds <= 9)
        seconds = "0" + seconds;

    var hrActual = hours + ":" + minutes + ":" + seconds + " " + dn;
    $('#' + idEtiqueta).html(hrActual);
    setTimeout("mostrarHora('" + idEtiqueta + "')", 1000);
}

