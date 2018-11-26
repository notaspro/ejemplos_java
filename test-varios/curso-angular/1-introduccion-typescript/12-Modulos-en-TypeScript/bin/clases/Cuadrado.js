"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Cuadrado = /** @class */ (function () {
    function Cuadrado(lado) {
        this.lado = lado;
    }
    Cuadrado.prototype.area = function () {
        return this.lado * this.lado;
    };
    return Cuadrado;
}());
exports.Cuadrado = Cuadrado;
