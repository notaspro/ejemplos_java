/*
    Promesas en el ECMA Script 6.
    En un request asincrono las promesas permiten ejecutar un codigo si
    todo sale bien o otro codigo si algo sale mal.
*/

let promesa1 = new Promise(function (resolve, reject) {
    console.log("Inicio de promesa1...");
    setTimeout(function() {
        //Codigo si todo sale bien
        resolve();
    
        //Codigo si algo sale mal
        //reject();
    }, 1500);
});

promesa1.then(function(){
    console.log("Todo salio OK!");
}, function(){
    console.log("Ooops! algo salio mal, intenta nuevamente");
});

//forma 2 de consumirla
promesa1.then(function() {
    console.log("Muy bien, todo salio OK!");
}).catch(function() {
    console.log("Ooops! algo salio muy mal");
});



console.log("Encadenamiento de promesas...\n\n");

let promesa1InicioTX = new Promise(function(resolve, reject) {
    console.log("Inicio de la transaccion...");
    setTimeout(function() {
        //Codigo si todo sale bien
        resolve("Inicio");
        //Codigo si algo sale mal
        //reject();
    }, 1500);
});

promesa1InicioTX.then(function(resultadoInicioTX) {
    console.log("Finalizo OK la fase de INICIO!");
    console.log("resultadoInicioTX: "+resultadoInicioTX);
    
    return resultadoInicioTX+"--> Procesamiento";
}).then(function(resultadoProcesamientoTX) {
    console.log("Finalizo OK la fase de PROCESO de la transaccion!");
    console.log("resultadoProcesamientoTX: "+resultadoProcesamientoTX);
    
    return resultadoProcesamientoTX+"--> Cierre";
}).then(function(resultadoCierreTX) {
    console.log("Finalizo OK la fase de CIERRE de la transaccion!");
    console.log("resultadoCierreTX: "+resultadoCierreTX);
    
    //return resultadoCierreTX;
}).catch(function() {
    console.log("Ooops! algo salio mal en alguna fase de la transaccion!");
});
