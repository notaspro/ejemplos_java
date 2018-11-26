//Tipos de datos que soporta TypeScript

var nombre:string ="Gonzalo";
var numTarjeta:number = 6543211234567890;
var autenticado:boolean = false;
var fechaExpiracion:Date = new Date("2030-11-24");

var cliente = {
  nombre: "Pepito",
  edad: 22
};

console.log("nombre: "+nombre);
console.log("numTarjeta: "+numTarjeta);
console.log("autenticado: "+autenticado);
console.log("fechaExpiracion: "+fechaExpiracion);
for(let propiedad in cliente ) {
  console.log("cliente."+propiedad+": "+cliente[propiedad]);
}

