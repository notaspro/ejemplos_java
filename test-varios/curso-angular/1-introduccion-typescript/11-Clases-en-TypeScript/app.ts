/*
    Clases en TypeScript
*/

class Laptop {
    
    marca:string = "ACME";
    numProcesadores:number;
    pulgadas:number;
    cantidadRAM:string;
    touch:boolean;
    
    constructor(marca:string, numProcesadores:number, pulgadas:number, cantidadRAM:string, touch:boolean) {
        this.marca = marca;
        this.numProcesadores = numProcesadores;
        this.pulgadas = pulgadas;
        this.cantidadRAM = cantidadRAM;
        this.touch = touch;
    }

    /* Este metodo devolvera un string */
    toString():string {
        return `Laptop = {marca=${this.marca},numProcesadores=${this.numProcesadores},pulgadas=${this.pulgadas},
            cantidadRAM=${this.cantidadRAM},touch=${this.touch} }`;
    }
}

class DiscoDuro {

    /*  
        Colocarle el public es lo mismo que declarar las variables 
        e inicializarlas dentro del constructor
    */
    constructor(public marca:string, public capacidad:number) {

    }
}

/*
let lap0:Laptop = new Laptop();
console.log(lap0);
*/

let lap1:Laptop = new Laptop("HP",4,15,"12 GB",true);
console.log(lap1.toString());

let hd1:DiscoDuro = new DiscoDuro("Seagate",500);
console.log(hd1);
