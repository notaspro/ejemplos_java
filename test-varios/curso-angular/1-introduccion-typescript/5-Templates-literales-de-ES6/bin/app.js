/*Templates literales del Ecma Script 6
Permite embeber variables dentro de cadenas de texto, incluso se puede
llamar a funciones
*/
function getEdad(anioNacimiento) {
    var edad = new Date().getFullYear() - anioNacimiento;
    return edad;
}
var cliente = "Pepito";
var apellidos = "lechuga";
var anioNacimiento = 2001;
//concatenacion normal
var saludo = "Hola, " + cliente + " " + apellidos + " tienes " + getEdad(anioNacimiento) + " años";
//concatenacion usando templates literales
var saludos = "Hola, " + cliente + " " + apellidos + " tienes " + getEdad(anioNacimiento) + " a\u00F1os";
console.log(saludo);
console.log(saludos);
