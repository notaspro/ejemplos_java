import {Punto2D} from "./Punto2D"

//Esta clase No se puede importar por otras clases

class Circulo {
    
    centro:Punto2D;
    radio:number;
    
    constructor(punto:Punto2D, radio:number) {
        this.centro = punto;
        this.radio = radio;
    }

    area() {
        return 3.1416*(this.radio*this.radio);
    }
}