"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Rectangulo = /** @class */ (function () {
    function Rectangulo(ancho, largo) {
        this.ancho = ancho;
        this.largo = largo;
    }
    Rectangulo.prototype.area = function () {
        return this.ancho * this.largo;
    };
    return Rectangulo;
}());
exports.Rectangulo = Rectangulo;
