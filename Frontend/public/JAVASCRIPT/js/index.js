const CLIENTES = [
    { id: 1, nombre: 'Pepe' },
    { id: 2, nombre: 'Juan' }
];

window.addEventListener('DOMContentLoaded', function() {
    console.log('DOMContentLoaded');

    const h1 = document.querySelector('h1');
    
    console.log(h1.innerHTML);

    h1.innerHTML = 'Modificado desde JavaScript';

    const inputNombre = document.querySelector('#nombre');
    const btnSaludar = document.querySelector('#btn-saludar');
    const spanResultado = document.querySelector('#resultado');

    btnSaludar.addEventListener('click', function() {
        const nombre = inputNombre.value;
        spanResultado.innerHTML = `Hola ${nombre}, qué tal estás.`;
    });

    const ul = document.querySelector('#clientes');
    let li;

    for(let cliente of CLIENTES) {
        li = document.createElement('li');
        li.innerHTML = `${cliente.id} ${cliente.nombre}`;

        ul.appendChild(li);
    }
});