/*
Realizacion de una peticion http de la forma tradicional

Nota: primero levantar el servidor de node:
http-server -o

Api de para peticiones con respuesta JSON:
https://reqres.in/

*/
var request = new XMLHttpRequest();

request.open('GET', 'https://reqres.in/api/users', true);
request.send(null);

request.onreadystatechange = function(state) {

    if (request.readyState === 4) {

        var resp = request.response;
        var respObj = JSON.parse(resp);

        console.log("La respuesta fue: ");
        console.log(respObj);
    }

};