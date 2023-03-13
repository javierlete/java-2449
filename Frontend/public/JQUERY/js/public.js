'use strict';

const URL = 'http://127.0.0.1:3000/productos/';
const FORMATO_EURO = new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' });

let carrito = JSON.parse(localStorage.getItem('carrito')) || [];

if(!carrito.length) {
    guardarCarrito();
}

let main, plantillaListado, plantillaTarjeta, plantillaProducto, tbodyCarrito, offcanvas, contenedor;

window.addEventListener('DOMContentLoaded', async function () {
    offcanvas = new bootstrap.Offcanvas(document.querySelector('.offcanvas'));
    tbodyCarrito = document.querySelector('.offcanvas-body tbody');

    main = document.querySelector('main');
    plantillaTarjeta = document.querySelector('#plantilla-tarjeta');
    plantillaProducto = document.querySelector('#plantilla-producto');
    plantillaListado = document.querySelector('#plantilla-listado');
    contenedor = plantillaListado.content.cloneNode(true).querySelector('div');

    mostrarListado();
});

async function mostrarListado() {
    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

    main.innerHTML = '';
    contenedor.innerHTML = '';

    productos.forEach(producto => {
        const tarjetaProducto = plantillaTarjeta.content.cloneNode(true);

        tarjetaProducto.querySelector('.card-title').innerHTML = producto.nombre;
        tarjetaProducto.querySelector('.card-text').innerHTML = producto.precio;
        tarjetaProducto.querySelector('.text-muted').innerHTML = producto.id;
        tarjetaProducto.querySelector('img').src = 'https://picsum.photos/400/200?' + producto.id;

        tarjetaProducto.querySelector('button').addEventListener('click', function () {
            mostrarProducto(producto);
        });

        contenedor.appendChild(tarjetaProducto);
    });

    main.appendChild(contenedor);
}

function mostrarProducto(producto) {
    main.innerHTML = '';

    const tarjetaProducto = plantillaProducto.content.cloneNode(true);

    tarjetaProducto.querySelector('.card-title').innerHTML = producto.nombre;
    tarjetaProducto.querySelector('.card-text').innerHTML = producto.precio;
    tarjetaProducto.querySelector('.text-muted').innerHTML = producto.id;
    tarjetaProducto.querySelector('img').src = 'https://picsum.photos/400/400?' + producto.id;

    tarjetaProducto.querySelector('button').addEventListener('click', function () {
        carrito.push(producto);
        guardarCarrito();

        rellenarCarrito();

        mostrarListado();

        offcanvas.show();
    });

    tarjetaProducto.querySelector('button:last-of-type').addEventListener('click', function() {
        mostrarListado();
    });

    main.appendChild(tarjetaProducto);
}

function rellenarCarrito() {
    tbodyCarrito.innerHTML = '';

    let total = 0;
    let tr;
    carrito.forEach(p => {
        tr = document.createElement('tr');
        tr.innerHTML = `
                        <td>${p.nombre}</td>
                        <td class="text-end font-monospace">${FORMATO_EURO.format(p.precio)}</td>
                        <td class="text-center">
                            <a href="javascript:quitarDelCarrito(${p.id})" class="btn-close"></a>
                    `;
        tbodyCarrito.appendChild(tr);

        total += p.precio;
    });

    document.querySelector('#total-carrito').innerHTML = FORMATO_EURO.format(total);
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

function verCarrito() {
    rellenarCarrito();
    offcanvas.show();
}