/*
Funciones de Flecha
Una de las utilidades de las funciones flecha es que el this no es afectado
 cuando se ejecuta dentro de otra funcion.

*/

//#### EJEMPLO 1 ####
//Funcion normal de Javascript
let funcion1 = function(a) {
    return a;
}
//Funcion de flecha de TypeScript
let funcion1Flecha = (a) =>  a;

//#### EJEMPLO 2 ####
//Funcion normal de Javascript
let funcion2 = function(num1:number, num2:number) {
    return num1+num2;
}
//Funcion de flecha de TypeScript
let funcion2Flecha = (num1:number, num2:number) =>  num1 + num2;

//#### EJEMPLO 3 ####
//Funcion normal de Javascript
let funcion3 = function(nombre:string) {
    nombre = nombre.toUpperCase();
    return `hola ${nombre}`;
}
//Funcion de flecha de TypeScript
let funcion3Flecha = (nombre:string) => {
    nombre = nombre.toUpperCase();
    return `hola ${nombre}`;
}

console.log("funcion1Flecha: "+funcion1Flecha("Funciones Flecha"));

console.log("funcion2Flecha: "+funcion2Flecha(2,5));

console.log("funcion1Flecha: "+funcion3Flecha("Carlos"));



//Ejemplo de uso de this

//#### EJEMPLO 4 ####

//implementacion con funcion normal con ES6
var recarga = {
    companiaId: 1,
    compania: "Acme",
    recargasDisponibles: [30,50,100,200],
    abonarTiempoAire(saldoId:number) {
        setTimeout(
            function() {
                try {
                    //this apunta al objeto global window
                    console.log(`La recarga por $${this.recargasDisponibles[saldoId]} se realizo con exito!`);
                } catch(err) {
                    console.log("Ocurrio un error: "+err);
                }
                
            }, 1500);
    }
}
recarga.abonarTiempoAire(2);

//implementacion con funcion de Flecha
var recarga2 = {
    companiaId: 1,
    compania: "Acme",
    recargasDisponibles: [30,50,100,200],
    abonarTiempoAire(saldoId:number) {
        setTimeout(
            //this apunta al mismo objeto
            () => console.log(`La recarga por $${this.recargasDisponibles[saldoId]} se realizo con exito!`), 1500);
    }
}
recarga2.abonarTiempoAire(1);