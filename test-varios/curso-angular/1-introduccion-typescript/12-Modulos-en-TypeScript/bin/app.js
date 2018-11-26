"use strict";
/*
    Importacion de clases en TypeScript
*/
Object.defineProperty(exports, "__esModule", { value: true });
/*
import {Cuadrado} from "./clases/Cuadrado"
import {Rectangulo} from "./clases/Rectangulo"
*/
var index_1 = require("./clases/index");
var miCuadrado = new index_1.Cuadrado(7);
var miRectangulo = new index_1.Rectangulo(5, 7);
console.log("Area del cuadrado: " + miCuadrado.area());
console.log("Area del Rectangulo: " + miRectangulo.area());
