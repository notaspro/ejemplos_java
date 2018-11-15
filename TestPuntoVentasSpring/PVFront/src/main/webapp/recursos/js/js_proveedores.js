/*
 *Codigo Javascript para la seccion Proveedores
 *Author: 
 *
 *Last update:
 **/
$().ready(function() {
   //Carga la hora actual del sistema; y la actualiza cada segundo
	mostrarHora("hrActual");


    //Prepare jTable
    $('#tblProveedores').jtable({
        title: 'Proveedores',
        paging: true,
        pageSize: 5,
        sorting: true,
        defaultSorting: 'tx_Nombre ASC',
        actions: {
            listAction: 'include/jtable_AccionesProveedores.php?action=list',
            createAction: 'include/jtable_AccionesProveedores.php?action=create',
            updateAction: 'include/jtable_AccionesProveedores.php?action=update',
            deleteAction: 'include/jtable_AccionesProveedores.php?action=delete'
        },
        fields: {
            id_Proveedor: {
                title: 'ID',
                key: true,
                create: false,
                edit: false,
                list: false
            },
            tx_Nombre: {
                title: 'Nombre'
            },
            tx_RFC: {
                title: 'RFC'
            },
            tx_Telefono: {
                title: 'Telefono'
            },
            tx_Contacto: {
                title: 'Contacto'
            },
            tx_Direccion: {
                title: 'Direccion'                
            },
            dt_FechaRegistro: {
                title: 'Fecha de registro',
                type: 'date',
                create: false,
                edit: false
            }
        }
    });

    //Load person list from server
    $('#tblProveedores').jtable('load');

});    //Fin de Funcion JQuery
