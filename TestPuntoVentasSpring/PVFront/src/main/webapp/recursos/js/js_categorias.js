/*
 *Codigo Javascript para la seccion Categorias
 *Author: 
 *
 *Last update:
 **/
$().ready(function() {
   //Carga la hora actual del sistema; y la actualiza cada segundo
    mostrarHora("hrActual");


    //Prepare jTable
    $('#tblCategorias').jtable({
        title: 'Categorias',
        paging: true,
        pageSize: 5,
        sorting: true,
        defaultSorting: 'tx_Nombre ASC',
        actions: {
            listAction: 'include/jtable_AccionesCategorias.php?action=list',
            createAction: 'include/jtable_AccionesCategorias.php?action=create',
            updateAction: 'include/jtable_AccionesCategorias.php?action=update',
            deleteAction: 'include/jtable_AccionesCategorias.php?action=delete'
        },
        fields: {
            id_Categoria: {
                title: 'ID',
                key: true,
                create: false,
                edit: false,
                list: false
            },
            tx_Nombre: {
                title: 'Nombre'
            },
            porcentajeGanancia: {
                title: 'Ganancia (%)'
            },
            tx_CarpetaCategoria: {
                title: 'Carpeta Imagenes Productos'
            },
            dt_FechaRegistro: {
                title: 'Fecha de registro',
                type: 'date',
                create: false,
                edit: false
            }
        }
    });

    //Load Categorias list from server
    $('#tblCategorias').jtable('load');

});    //Fin de Funcion JQuery
