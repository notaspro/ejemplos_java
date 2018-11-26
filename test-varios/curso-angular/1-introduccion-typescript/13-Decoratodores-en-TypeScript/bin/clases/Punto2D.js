"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Punto2D = /** @class */ (function () {
    function Punto2D(x, y) {
        this.x = x;
        this.y = y;
    }
    Punto2D.prototype.pintaPosicion = function () {
        console.log("" + (this.x, this.y));
    };
    return Punto2D;
}());
exports.Punto2D = Punto2D;
