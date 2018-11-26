/*
Parametros abligatorios, por defecto y obligatorios en TypeScript
function myfunction(paramObligatorio1:number, paramPorDefecto:number=7, paramOpcional?:string) {}
El primer parametro siempre es obligatorio
*/

function activarTarjeta(numTarjeta:number, token:number=777, nombreCliente?:string) {
    
    var mensajeCliente:string = "";
    if(token == 777 && nombreCliente == undefined) {
        mensajeCliente = `Estimado cliente se activo exitosamente su tarjeta ${numTarjeta} con el token por defecto.`;
    } else if(token != 777 && nombreCliente == undefined) {
        mensajeCliente = `Estimado cliente, se activo exitosamente su tarjeta ${numTarjeta} con el token ${token}`;
    } else {
        mensajeCliente = `Estimado cliente ${nombreCliente}, se activo exitosamente su tarjeta ${numTarjeta} con el token ${token}`;
    }

    console.log(mensajeCliente);
}

//se envia solo parametro obligarorio
activarTarjeta(456789987654321);

//se envia parametro obligarorio el por defecto
activarTarjeta(456789987654321,11565623333);

//se envia parametro obligarorio el por defecto y el opcional
activarTarjeta(456789987654321,11112223333, "Pepito");
