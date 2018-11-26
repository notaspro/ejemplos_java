/*
    Decoradores en TypeScript
*/

//decorador de Linea2D
function consola( constructor:Function) {
    console.log(constructor);
    
}

class Punto2D {

    x:number;
    y:number;

    constructor(x:number,y:number) {
        this.x = x;
        this.y = y;
    }

    //este metodo devolvera un string
    getPosicion():string {
        return `${this.x}, ${this.y}`;
    }
    
}

@consola
class Linea2D {
    
    constructor(public punto1:Punto2D, public punto2:Punto2D) {

    }

    pintaLinea() {
        console.log(`Punto de la linea: punto1=(${this.punto1.getPosicion()}), punto2=(${this.punto2.getPosicion()})`);
    }
}

//let linea1:Linea2D = new Linea2D(new Punto2D(50,50), new Punto2D(70,50));

//linea1.pintaLinea(); 
