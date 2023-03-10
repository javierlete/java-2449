'use strict';

const URL = 'http://127.0.0.1:3000/productos/';

let carrito = JSON.parse(localStorage.getItem('carrito')) || [];

if(!carrito.length) {
    guardarCarrito();
}

let tbodyCarrito;

window.addEventListener('DOMContentLoaded', async function () {
    const offcanvas = new bootstrap.Offcanvas(document.querySelector('.offcanvas'));
    tbodyCarrito = document.querySelector('.offcanvas-body tbody');

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
                guardarCarrito();

                rellenarCarrito();

                offcanvas.show();
            });

            main.appendChild(tarjetaProducto);
        });

        contenedor.appendChild(tarjetaProducto);
    });
});

function rellenarCarrito() {
    tbodyCarrito.innerHTML = '';

    let tr;
    carrito.forEach(p => {
        tr = document.createElement('tr');
        tr.innerHTML = `
                        <td>${p.nombre}</td>
                        <td>${p.precio} €</td>
                        <td>
                            <a href="javascript:quitarDelCarrito(${p.id})" class="btn-close"></a>
                    `;
        tbodyCarrito.appendChild(tr);
    });
}

function vaciarCarrito() {
    carrito = [];

    guardarCarrito();

    tbodyCarrito.innerHTML = '';
}

function quitarDelCarrito(id) {
    carrito = carrito.filter(p => p.id !== id);

    guardarCarrito();

    rellenarCarrito();
}

function guardarCarrito() {
    localStorage.setItem('carrito', JSON.stringify(carrito));
}
