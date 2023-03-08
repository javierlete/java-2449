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

let numeroRegistro;
let estasSeguro;
let confirmar;
let alerta;
let mensajeAlerta;
let nivelUltimaAlerta;

window.addEventListener('DOMContentLoaded', function () {
    alerta = document.querySelector('.alert');
    mensajeAlerta = alerta.querySelector('span');
    const cierreAlerta = alerta.querySelector('button');

    tbody = document.querySelector('tbody');
    tabla = document.querySelector('table');
    form = document.querySelector('form');

    numeroRegistro = document.querySelector('#numero-registro');
    estasSeguro = new bootstrap.Modal('#estasSeguro');
    confirmar = document.querySelector('#confirmar');

    const boton = document.querySelector('form button');

    inputId = document.getElementById('id');
    inputNombre = document.getElementById('nombre');
    inputPrecio = document.getElementById('precio');
    inputGarantia = document.getElementById('garantia');

    boton.addEventListener('click', guardar);
    confirmar.addEventListener('click', borrarConfirmado);
    cierreAlerta.addEventListener('click', cerrarAlerta);

    cerrarAlerta();

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
    try {
        const respuesta = await fetch(URL);

        if(!respuesta.ok) {
            throw { message: respuesta.statusText };
        }

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

        mostrarAlerta('Se han recibido correctamente los productos', 'success');
    } catch(e) {
        console.error('No se han podido recibir los datos');
        console.error(e.message);

        //alert('Ha habido un error al pedir los datos al servidor');

        mostrarAlerta(e.message, 'danger');
    }
}

async function formulario(id) {
    mostrarFormulario();

    let producto = { id: undefined, nombre: '', precio: undefined, garantia: undefined };

    if (id) {
        const respuesta = await fetch(URL + id);
        producto = await respuesta.json();
    }

    inputId.valueAsNumber = producto.id;
    inputNombre.value = producto.nombre;
    inputPrecio.valueAsNumber = producto.precio;
    inputGarantia.value = producto.garantia;
}

async function borrar(id) {
    confirmar.dataset.id = id;
    numeroRegistro.innerHTML = id;

    estasSeguro.show();
}

async function borrarConfirmado() {
    const id = this.dataset.id;

    await fetch(URL + id, {
        method: 'DELETE'
    });

    estasSeguro.hide();

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

function mostrarAlerta(mensaje, nivel) {
    mensajeAlerta.innerHTML = mensaje;
    alerta.classList.add('alert-' + nivel);

    nivelUltimaAlerta = nivel;

    alerta.style.display = 'block';
}

function cerrarAlerta() {
    alerta.style.display = 'none';

    alerta.classList.remove('alert-' + nivelUltimaAlerta);
}
