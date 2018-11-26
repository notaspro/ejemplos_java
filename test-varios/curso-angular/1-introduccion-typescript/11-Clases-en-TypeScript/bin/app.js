/*
    Clases en TypeScript
*/
var Laptop = /** @class */ (function () {
    function Laptop(marca, numProcesadores, pulgadas, cantidadRAM, touch) {
        this.marca = "ACME";
        this.marca = marca;
        this.numProcesadores = numProcesadores;
        this.pulgadas = pulgadas;
        this.cantidadRAM = cantidadRAM;
        this.touch = touch;
    }
    /* Este metodo devolvera un string */
    Laptop.prototype.toString = function () {
        return "Laptop= {marca=" + this.marca + ",numProcesadores=" + this.numProcesadores + ",pulgadas=" + this.pulgadas + ",\n            cantidadRAM=" + this.cantidadRAM + ",touch=" + this.touch + " }";
    };
    return Laptop;
}());
var DiscoDuro = /** @class */ (function () {
    /*
        Colocarle el public es lo mismo que declarar las variables
        e inicializarlas dentro del constructor
    */
    function DiscoDuro(marca, capacidad) {
        this.marca = marca;
        this.capacidad = capacidad;
    }
    return DiscoDuro;
}());
/*
let lap0:Laptop = new Laptop();
console.log(lap0);
*/
var lap1 = new Laptop("HP", 4, 15, "12 GB", true);
console.log(lap1.toString());
var hd1 = new DiscoDuro("Seagate", 500);
console.log(hd1);
