/*
    Importacion de clases en TypeScript
*/

/*
import {Cuadrado} from "./clases/Cuadrado"
import {Rectangulo} from "./clases/Rectangulo"
*/
import {Cuadrado, Rectangulo} from "./clases/index"

let miCuadrado:Cuadrado = new Cuadrado(7);
let miRectangulo:Rectangulo = new Rectangulo(5,7);

console.log("Area del cuadrado: "+miCuadrado.area());
console.log("Area del Rectangulo: "+miRectangulo.area());

