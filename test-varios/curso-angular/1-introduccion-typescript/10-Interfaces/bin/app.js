/*
    Interfaces en TypeScript
*/
var usuario1 = {
    userId: 1,
    username: "pepito",
    password: "12345"
    //,esAdministrador:boolean
};
function hacerLogin(usuario) {
    console.log("El usuario " + usuario.username + " esta haciendo login...");
}
hacerLogin(usuario1);
console.log("Terminado.");
