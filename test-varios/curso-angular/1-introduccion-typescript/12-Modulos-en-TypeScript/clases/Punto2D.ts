
export class Punto2D {

    x:number;
    y:number;

    constructor(x:number,y:number) {
        this.x = x;
        this.y = y;
    }

    pintaPosicion() {
        console.log(`${this.x, this.y}`)
    }
    
}