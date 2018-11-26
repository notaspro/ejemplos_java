//uso de promesas encadenadas y uso de funciones de Flecha

function sumarUno(numero) {

    var promesa = new Promise(function(resolve, reject) {

        setTimeout(function() {
            resolve(numero + 1);
        }, 800);

    });

    return promesa;
}


sumarUno(5).then(nuevoNumero => {
    console.log(nuevoNumero);
    return sumarUno(nuevoNumero);
}).then(nuevoNumero => {
    console.log(nuevoNumero);
    return sumarUno(nuevoNumero);
}).then(nuevoNumero => {
    console.log(nuevoNumero);
    //return sumarUno(nuevoNumero);
});


/*
sumarUno( 5 )
    .then( sumarUno )
    .then( sumarUno )
    .then( sumarUno )
    .then( sumarUno )
    .then( sumarUno )
    .then( nuevoNumero => {
        console.log(nuevoNumero);
    })
    .catch( error => {
        console.log('ERROR EN PROMESA');
        console.log(error);
    });

*/