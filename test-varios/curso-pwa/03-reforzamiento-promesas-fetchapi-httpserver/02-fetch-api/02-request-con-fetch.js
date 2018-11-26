/*
Uso de la api fetch
sintaxis: fetch('https://reqres.in/api/users') 
La cual devuelve una promesa con la respuesta
*/

// Petición GET
// https://reqres.in/api/users

fetch('https://reqres.in/api/users')
    .then(resp => resp.json())
    .then(respObj => {
        console.log(respObj);
        console.log(respObj.page);
        console.log(respObj.per_page);
    });

// // No hacer
// fetch( 'https://www.wikipedia.org' )
//     .then( resp => resp.text() )
//     .then( html => {

//         console.log(html);
//         // document.open();
//         // document.write( html );
//         // document.close();
//     });