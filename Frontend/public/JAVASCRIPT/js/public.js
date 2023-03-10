'use strict';

const URL = 'http://127.0.0.1:3000/productos/';
let carrito = JSON.parse(localStorage.getItem('carrito'));

if(!carrito) {
    localStorage.setItem('carrito', '[]');
}

window.addEventListener('DOMContentLoaded', async function () {
    const main = document.querySelector('main');
    const contenedor = document.querySelector('main > div');
    const plantillaListado = document.querySelector('#plantilla-tarjeta');
    const plantillaProducto = document.querySelector('#plantilla-producto');

    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

    productos.forEach(producto => {
        const tarjetaProducto = plantillaListado.content.cloneNode(true);

        tarjetaProducto.querySelector('.card-title').innerHTML = producto.nombre;
        tarjetaProducto.querySelector('.card-text').innerHTML = producto.precio;
        tarjetaProducto.querySelector('.text-muted').innerHTML = producto.id;
        tarjetaProducto.querySelector('img').src = 'https://picsum.photos/400/200?' + producto.id;

        tarjetaProducto.querySelector('button').addEventListener('click', function () {
            main.innerHTML = '';

            const tarjetaProducto = plantillaProducto.content.cloneNode(true);

            tarjetaProducto.querySelector('.card-title').innerHTML = producto.nombre;
            tarjetaProducto.querySelector('.card-text').innerHTML = producto.precio;
            tarjetaProducto.querySelector('.text-muted').innerHTML = producto.id;
            tarjetaProducto.querySelector('img').src = 'https://picsum.photos/400/400?' + producto.id;

            tarjetaProducto.querySelector('button').addEventListener('click', function() {
                carrito.push(producto);
                localStorage.setItem('carrito', JSON.stringify(carrito));
            });

            main.appendChild(tarjetaProducto);
        });

        contenedor.appendChild(tarjetaProducto);
    });
});