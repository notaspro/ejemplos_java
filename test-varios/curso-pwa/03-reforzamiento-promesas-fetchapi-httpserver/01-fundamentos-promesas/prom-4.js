/*
Uso de  Promise.all(valor1, valor2, valorn])
Si alguna de las promesas que se le pasa en el arreglo falla , todo falla
*/
function retornaTrue() {
    return true;
}


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

        setTimeout(() => resolve(numero + 1), 300);

    });

}


//se resuelven todas de una sola vez 
Promise.all([sumarLento(5), sumarRapido(10)])
    .then(respuestas => {
        console.log(respuestas);
    })
    .catch(console.log);


let cosas = [sumarLento(5), sumarRapido(10), true, 'hola mundo', retornaTrue()];

//No importa que valores se le manden
Promise.all(cosas)
    .then(respuestas => {
        console.log(respuestas);
    })
    .catch(console.log);

//rdtsd promesas se resuelven una tras de otra
// sumarRapido( 10 ).then(  console.log );
// sumarLento( 5 ).then(  console.log );