/*
    Interfaces en TypeScript
*/

interface Usuario {
    userId:number;
    username:string;
    password:string;
}


let usuario1:Usuario = {
    userId:1,
    username:"pepito",
    password:"12345"
    //,esAdministrador:boolean
}

function hacerLogin(usuario:Usuario) {
    console.log(`El usuario ${usuario.username} esta haciendo login...`);
}

hacerLogin(usuario1);
console.log("Terminado.");