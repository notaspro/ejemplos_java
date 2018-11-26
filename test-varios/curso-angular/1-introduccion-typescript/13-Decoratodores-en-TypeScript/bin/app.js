/*
    Decoradores en TypeScript
*/
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
//decorador de Linea2D
function consola(constructor) {
    console.log(constructor);
}
var Punto2D = /** @class */ (function () {
    function Punto2D(x, y) {
        this.x = x;
        this.y = y;
    }
    //este metodo devolvera un string
    Punto2D.prototype.getPosicion = function () {
        return this.x + ", " + this.y;
    };
    return Punto2D;
}());
var Linea2D = /** @class */ (function () {
    function Linea2D(punto1, punto2) {
        this.punto1 = punto1;
        this.punto2 = punto2;
    }
    Linea2D.prototype.pintaLinea = function () {
        console.log("Punto de la linea: punto1=(" + this.punto1.getPosicion() + "), punto2=(" + this.punto2.getPosicion() + ")");
    };
    Linea2D = __decorate([
        consola
    ], Linea2D);
    return Linea2D;
}());
//let linea1:Linea2D = new Linea2D(new Punto2D(50,50), new Punto2D(70,50));
//linea1.pintaLinea(); 
