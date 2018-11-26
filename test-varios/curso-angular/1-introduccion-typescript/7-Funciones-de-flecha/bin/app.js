/*
Funciones de Flecha
Una de las utilidades de las funciones flecha es que el this no es afectado
 cuando se ejecuta dentro de otra funcion.

*/
//#### EJEMPLO 1 ####
//Funcion normal de Javascript
var funcion1 = function (a) {
    return a;
};
//Funcion de flecha de TypeScript
var funcion1Flecha = function (a) { return a; };
//#### EJEMPLO 2 ####
//Funcion normal de Javascript
var funcion2 = function (num1, num2) {
    return num1 + num2;
};
//Funcion de flecha de TypeScript
var funcion2Flecha = function (num1, num2) { return num1 + num2; };
//#### EJEMPLO 3 ####
//Funcion normal de Javascript
var funcion3 = function (nombre) {
    nombre = nombre.toUpperCase();
    return "hola " + nombre;
};
//Funcion de flecha de TypeScript
var funcion3Flecha = function (nombre) {
    nombre = nombre.toUpperCase();
    return "hola " + nombre;
};
console.log("funcion1Flecha: " + funcion1Flecha("Funciones Flecha"));
console.log("funcion2Flecha: " + funcion2Flecha(2, 5));
console.log("funcion1Flecha: " + funcion3Flecha("Carlos"));
//Ejemplo de uso de this
//#### EJEMPLO 4 ####
//implementacion con funcion normal con ES6
var recarga = {
    companiaId: 1,
    compania: "Acme",
    recargasDisponibles: [30, 50, 100, 200],
    abonarTiempoAire: function (saldoId) {
        setTimeout(function () {
            try {
                //this apunta al objeto global window
                console.log("La recarga por $" + this.recargasDisponibles[saldoId] + " se realizo con exito!");
            }
            catch (err) {
                console.log("Ocurrio un error: " + err);
            }
        }, 1500);
    }
};
recarga.abonarTiempoAire(2);
//implementacion con funcion de Flecha
var recarga2 = {
    companiaId: 1,
    compania: "Acme",
    recargasDisponibles: [30, 50, 100, 200],
    abonarTiempoAire: function (saldoId) {
        var _this = this;
        setTimeout(
        //this apunta al mismo objeto
        function () { return console.log("La recarga por $" + _this.recargasDisponibles[saldoId] + " se realizo con exito!"); }, 1500);
    }
};
recarga2.abonarTiempoAire(1);
