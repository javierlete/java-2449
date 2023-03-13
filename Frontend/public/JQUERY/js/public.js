'use strict';

var URL = 'http://127.0.0.1:3000/productos/';
var FORMATO_EURO = new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' });

var carrito = JSON.parse(localStorage.getItem('carrito')) || [];

if (!carrito.length) {
    guardarCarrito();
}

let offcanvas, tbodyCarrito, contenedor;

$(function () {
    offcanvas = new bootstrap.Offcanvas($('.offcanvas')[0]);
    tbodyCarrito = $('.offcanvas-body tbody');

    contenedor = $('#plantilla-listado')[0].content.cloneNode(true).querySelector('div');

    mostrarListado();
});

function mostrarListado() {
    $.get(URL, function (productos) {
        $('main').empty();
        $('contenedor').empty();

        $(productos).each(function () {
            var tarjetaProducto = $('#plantilla-tarjeta')[0].content.cloneNode(true);

            $(tarjetaProducto).find('.card-title').html(this.nombre);
            $(tarjetaProducto).find('.card-text').html(this.precio);
            $(tarjetaProducto).find('.text-muted').html(this.id);
            $(tarjetaProducto).find('img')[0].src = 'https://picsum.photos/400/200?' + this.id;

            var producto = this;

            $(tarjetaProducto).find('button').on('click', function () {
                mostrarProducto(producto);
            });

            $(contenedor).append(tarjetaProducto);
        });

        $('main').append(contenedor);
    });

}

function mostrarProducto(producto) {
    $('main').empty();

    var tarjetaProducto = $('#plantilla-producto')[0].content.cloneNode(true);

    $(tarjetaProducto).find('.card-title').html(producto.nombre);
    $(tarjetaProducto).find('.card-text').html(producto.precio);
    $(tarjetaProducto).find('.text-muted').html(producto.id);
    $(tarjetaProducto).find('img')[0].src = 'https://picsum.photos/400/200?' + producto.id;

    $(tarjetaProducto).find('button').on('click', function () {
        carrito.push(producto);
        guardarCarrito();

        rellenarCarrito();

        mostrarListado();

        offcanvas.show();
    });

    $(tarjetaProducto).find('button:last-of-type').on('click', function () {
        mostrarListado();
    });

    $('main').append(tarjetaProducto);
}

function rellenarCarrito() {
    $('tbody').empty();

    var total = 0;
    $(carrito).each(function() {
        $('<tr>').html(`
                        <td>${this.nombre}</td>
                        <td class="text-end font-monospace">${FORMATO_EURO.format(this.precio)}</td>
                        <td class="text-center">
                            <a href="javascript:quitarDelCarrito(${this.id})" class="btn-close"></a>
                    `).appendTo($('tbody'));

        total += this.precio;
    });

    $('#total-carrito').html(FORMATO_EURO.format(total));
}

function vaciarCarrito() {
    carrito = [];

    guardarCarrito();

    $('tbody').empty();
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