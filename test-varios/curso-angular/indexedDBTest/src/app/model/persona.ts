
export class Persona {
    nombre: string;
    edad: number;
    casado: boolean;

    /* Este metodo devolvera un string */
    toString(): string {
        return `Persona = {nombre=${this.nombre},edad=${this.edad},casado=${this.casado} }`;
    }
}
