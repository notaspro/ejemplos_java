/*
Promise.race([])
Evalua las promesas que se le pasan, pero solo devuelve la que 
responda primero (sea con un resolve o con reject)
Se podria usar por ejemplo para comparar las lecturas de local o de internet
pues podria haber un dispositivo lento pero con una rapida conexion a internet
*/

function sumarLento(numero) {

    return new Promise(function(resolve, reject) {

        setTimeout(function() {

            resolve(numero + 1);
            // reject( 'Sumar Lento falló' );

        }, 800);

    });

}

let sumarRapido = (numero) => {

    return new Promise((resolve, reject) => {

        setTimeout(() => {

            // resolve( numero + 1 );
            reject('Error en sumar rápido');

        }, 1000);

    });

}


Promise.race([sumarLento(5), sumarRapido(10)])
    .then(respuesta => {
        console.log(respuesta);
    })
    .catch(console.log);