"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
//Esta clase No se puede importar por otras clases
var Circulo = /** @class */ (function () {
    function Circulo(punto, radio) {
        this.centro = punto;
        this.radio = radio;
    }
    Circulo.prototype.area = function () {
        return 3.1416 * (this.radio * this.radio);
    };
    return Circulo;
}());
