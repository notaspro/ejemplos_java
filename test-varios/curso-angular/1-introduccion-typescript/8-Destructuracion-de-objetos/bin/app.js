/*
    Destructuracion de Objetos.
    Permite obtener las propiedades de los objetos en variables separadas

*/
var transaccion = {
    transaccionId: 7454367563,
    producto: "Pasta dental 150gr",
    fasesLogs: ["inicio", "envio", " en pasarela", "aprobada"]
};
/*
    let transaccionId = transaccion.transaccionId;
    let producto = transaccion.producto;
    let fasesLogs = transaccion.fasesLogs;
*/
//Destructuracion de objetos
var transaccionId = transaccion.transaccionId, producto = transaccion.producto, fasesLogs = transaccion.fasesLogs;
console.log(transaccion);
console.log(transaccionId + ", " + producto + ", " + fasesLogs);
//Destructuracion de arreglos
var _a = transaccion.fasesLogs, faseInicio = _a[0], faseEnvio = _a[1], fasePasarela = _a[2];
var _b = transaccion.fasesLogs, faseAprobada = _b[3];
console.log("\n" + faseInicio + ", " + faseEnvio + ", " + fasePasarela);
console.log("" + faseAprobada);
