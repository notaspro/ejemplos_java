//Tipos de datos que soporta TypeScript
var nombre = "Gonzalo";
var numTarjeta = 6543211234567890;
var autenticado = false;
var fechaExpiracion = new Date("2030-11-24");
var cliente = {
    nombre: "Pepito",
    edad: 22
};
console.log("nombre: " + nombre);
console.log("numTarjeta: " + numTarjeta);
console.log("autenticado: " + autenticado);
console.log("fechaExpiracion: " + fechaExpiracion);
for (var propiedad in cliente) {
    console.log("cliente." + propiedad + ": " + cliente[propiedad]);
}
