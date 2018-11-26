
export class Rectangulo {

    ancho:number;
    largo:number;

    constructor(ancho:number, largo:number) {
        this.ancho = ancho;
        this.largo = largo;
    }
    
    area() {
        return this.ancho*this.largo;
    }

}

