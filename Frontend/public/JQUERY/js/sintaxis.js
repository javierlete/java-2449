'use strict';
/*
var dato = 5;
console.log(dato, typeof dato);

dato = 'Pepe';
console.log(dato, typeof dato);

dato = new Date();
console.log(dato, typeof dato);

var dato1 = parseInt(prompt('Dame un número'));
var dato2 = parseInt(prompt('Dame otro número'));

if(isNaN(dato1)) {
    console.log('No es un número');
} else {
    console.log('Es un número');
}

var suma = dato1 + dato2;
console.log(suma, typeof suma);
*/

const arr = Array(3);

arr[0] = 10;
arr[1] = 20;
arr[2] = 30;
arr[3] = 40;
arr[10] = 50;
arr[7] = 'Pepe';
arr['casa'] = 'Home';
arr.prueba = 'Test';
arr.push(new Date());

console.log(arr, typeof arr);

for(let clave in arr) {
    console.log(clave, arr[clave]);
}

for(let dato of arr) {
    console.log(dato);
}

arr.forEach(elemento => console.log(elemento));

arr.forEach((elemento, indice) => console.log(indice, elemento));

/*
console.log(variableVar);
//console.log(variableLet);

var variableVar = 'variableVar';
let variableLet = 'variableLet';

console.log('sumar', typeof sumar, sumar(5, 6));

function sumar(a, b) {
    return a + b;
}

var restar = function(a, b) { return a - b; }

console.log('restar', typeof restar, restar, restar(6, 5));

const multiplicar = (a, b) => a * b;

console.log('multiplicar', multiplicar(5, 6));

console.log('dividir', ((a,b) => a/b)(7, 2));

let calculo = sumar;

console.log('calculo', calculo(6, 7));

calculo = restar;

console.log('calculo', calculo(6, 7));

const persona = { id: 5, nombre: 'Javier' };

persona.apellido = 'Lete';
persona['profesion'] = 'Profesor';

console.log(typeof persona, persona);


function Persona(id, nombre, apellidos) {
    this.id = id;
    this.nombre = nombre;
    this.apellidos = apellidos;
}

Persona.prototype.nombreCompleto = function() {
    return `${this.nombre} ${this.apellidos}`;
}


class Persona {
    constructor(id, nombre, apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    nombreCompleto() {
        return `${this.nombre} ${this.apellidos}`;
    }
}

const persona1 = new Persona(5, 'Pepe');

persona1.apellidos = 'Pérez';

console.log(persona1.nombre);

console.log(typeof persona1, persona1);

console.log(persona1.nombreCompleto());
*/