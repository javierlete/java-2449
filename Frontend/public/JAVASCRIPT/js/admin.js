'use strict';

const URL = 'http://localhost:3000/productos/';

let productos;

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
    const boton = document.querySelector('form button');

    inputId = document.getElementById('id');
    inputNombre = document.getElementById('nombre');
    inputPrecio = document.getElementById('precio');
    inputGarantia = document.getElementById('garantia');

    boton.addEventListener('click', guardar);

    mostrarTabla();
});

async function guardar() {
    const producto = {
        id: inputId.valueAsNumber,
        nombre: inputNombre.value,
        precio: inputPrecio.valueAsNumber,
        garantia: inputGarantia.value,
    };

    if (producto.id) {
        await fetch(URL + producto.id, {
            method: 'PUT',
            body: JSON.stringify(producto),
            headers: {
                "Content-Type": "application/json"
            }
        });
    } else {
        await fetch(URL, {
            method: 'POST',
            body: JSON.stringify(producto),
            headers: {
                "Content-Type": "application/json"
            }
        });
    }

    mostrarTabla();
}

async function rellenarTabla() {
    const respuesta = await fetch(URL);
    productos = await respuesta.json();

    tbody.innerHTML = '';

    let tr;

    productos.forEach(producto => {
        tr = document.createElement('tr');
        tr.innerHTML = `
        <th>${producto.id}</th>
        <td>${producto.nombre}</td>
        <td>${producto.precio}</td>
        <td>${producto.garantia}</td>
        <td>
            <a class="btn btn-sm btn-primary" href="javascript:formulario(${producto.id})">Editar</a>
            <a class="btn btn-sm btn-danger" href="javascript:borrar(${producto.id})">Borrar</a>
        </td>`;

        tbody.appendChild(tr);
    });
}

async function formulario(id) {
    mostrarFormulario();

    let producto = { id: undefined, nombre: '', precio: undefined, garantia: undefined };

    if(id) {
        const respuesta = await fetch(URL + id);
        producto = await respuesta.json();
    }

    inputId.valueAsNumber = producto.id;
    inputNombre.value = producto.nombre;
    inputPrecio.valueAsNumber = producto.precio;
    inputGarantia.value = producto.garantia;
}

async function borrar(id) {
    if(!confirm('¿Estás seguro de que quieres borrar el elemento ' + id + '?')) {
        return;
    }
    
    await fetch(URL + id, {
        method: 'DELETE'
    });

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