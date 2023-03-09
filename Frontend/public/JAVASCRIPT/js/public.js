'use strict';

const URL = 'http://127.0.0.1:3000/productos/';

window.addEventListener('DOMContentLoaded', async function () {
    const contenedor = document.querySelector('main > div');
    const plantilla = document.querySelector('#plantilla-tarjeta');

    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

    productos.forEach(producto => {
        const tarjeta = plantilla.content.cloneNode(true);

        tarjeta.querySelector('.card-title').innerHTML = producto.nombre;
        tarjeta.querySelector('.card-text').innerHTML = producto.precio;
        tarjeta.querySelector('.card-footer > .text-muted').innerHTML = producto.id;
        tarjeta.querySelector('img').src = 'https://picsum.photos/400/200?'+ producto.id;

        contenedor.appendChild(tarjeta);
    });
});