/*Templates literales del Ecma Script 6
Permite embeber variables dentro de cadenas de texto, incluso se puede
llamar a funciones. Tambien se puede saltar de linea
*/

function getEdad(anioNacimiento:number) {
    let edad:number = new Date().getFullYear()-anioNacimiento;
    return edad;
}

let cliente:string = "Pepito";
let apellidos:string = "lechuga";
let anioNacimiento:number = 2001;

//concatenacion normal
let saludo:string = "Hola, "+cliente+" "+apellidos+ " tienes "+getEdad(anioNacimiento)+" años";
//concatenacion usando templates literales
let saludos:string = `Hola, 
${cliente} ${apellidos} tienes ${getEdad(anioNacimiento)} años`;

console.log(saludo);
console.log(saludos);
