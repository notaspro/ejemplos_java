//Uso de la palabra const para declarar constantes
//por convension se usan letras MAYUSCULAR
//por convension se deben inicializar al declararlas

let NUM_PI = 3.1416;

//La constante dentro se elimina al terminar el bloque {}
if(true) {
  let NUM_PI = 3.14159;
}
console.log(NUM_PI);
