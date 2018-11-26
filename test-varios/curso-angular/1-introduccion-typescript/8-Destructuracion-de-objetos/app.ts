/*
    Destructuracion de Objetos.
    Permite obtener las propiedades de los objetos en variables separadas

*/

var transaccion = {
    transaccionId: 7454367563,
    producto: "Pasta dental 150gr",
    fasesLogs: ["inicio","envio"," en pasarela","aprobada"]
}
/*
    let transaccionId = transaccion.transaccionId;
    let producto = transaccion.producto;
    let fasesLogs = transaccion.fasesLogs;
*/
//Destructuracion de objetos
let {transaccionId,producto, fasesLogs} = transaccion;
console.log(transaccion); 
console.log(`${transaccionId}, ${producto}, ${fasesLogs}`);

//Destructuracion de arreglos
let [faseInicio,faseEnvio, fasePasarela] = transaccion.fasesLogs;
let [, , , faseAprobada] = transaccion.fasesLogs;
console.log(`\n${faseInicio}, ${faseEnvio}, ${fasePasarela}`);
console.log(`${faseAprobada}`);

