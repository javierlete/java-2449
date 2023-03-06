'use strict';

let productos = [
    { id: 1, nombre: 'Portátil', precio: 1234.12, garantia: new Date() },
    { id: 3, nombre: 'Ratón', precio: 12.12, garantia: new Date() },
    { id: 2, nombre: 'Monitor', precio: 123.12, garantia: new Date() },
];

let tbody;
let tabla;
let form;

let inputId;
let inputNombre;
let inputPrecio;
let inputGarantia;

window.addEventListener('DOMContentLoaded', function() {
    tbody = document.querySelector('tbody');
    tabla = document.querySelector('table');
    form = document.querySelector('form');

    inputId = document.getElementById('id');
    inputNombre = document.getElementById('nombre');
    inputPrecio = document.getElementById('precio');
    inputGarantia = document.getElementById('garantia');

    form.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const producto = {
            id: inputId.valueAsNumber,
            nombre: inputNombre.value,
            precio: inputPrecio.valueAsNumber,
            garantia: inputGarantia.valueAsDate,
        };

        if(producto.id) {
            const indiceProductoOriginal = productos.findIndex(p => p.id === producto.id);
            productos[indiceProductoOriginal] = producto;
        } else {
            producto.id = Math.max(...productos.map(producto => producto.id)) + 1;
            // producto.id = productos.reduce((acumulado, producto) => (producto.id > acumulado ? producto.id : acumulado), 0) + 1;
            productos.push(producto);
        }

        mostrarTabla();
    });

    mostrarTabla();
});

function rellenarTabla() {
    tbody.innerHTML = '';

    let tr;

    productos.forEach(producto => {
        tr = document.createElement('tr');
        tr.innerHTML = `
        <th>${producto.id}</th>
        <td>${producto.nombre}</td>
        <td>${producto.precio}</td>
        <td>${producto.garantia.toLocaleDateString()}</td>
        <td>
            <a href="javascript:formulario(${producto.id})">Editar</a>
            <a href="javascript:borrar(${producto.id})">Borrar</a>
        </td>`;

        tbody.appendChild(tr);
    });
}

function formulario(id) {
    mostrarFormulario();

    let producto = { id: undefined, nombre: '', precio: undefined, garantia: undefined };

    if(id) {
        producto = productos.filter(producto => producto.id === id)[0];
    }

    inputId.valueAsNumber = producto.id;
    inputNombre.value = producto.nombre;
    inputPrecio.valueAsNumber = producto.precio;
    inputGarantia.valueAsDate = producto.garantia;
}

function borrar(id) {
    productos = productos.filter(producto => producto.id !== id);

    rellenarTabla();
}

function mostrarFormulario() {
    tabla.style.display = 'none';
    form.style.display = 'block';
}

function mostrarTabla() {
    rellenarTabla();

    tabla.style.display = 'table';
    form.style.display = 'none';
}