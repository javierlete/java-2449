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

let datatable;

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
    try {
        if (!form.checkValidity()) {
            form.classList.add('was-validated');
            mostrarAlerta('Hay datos incorrectos en el formulario', 'danger');
            return;
        }

        const producto = {
            id: inputId.valueAsNumber,
            nombre: inputNombre.value,
            precio: inputPrecio.valueAsNumber,
            garantia: inputGarantia.value,
        };

        let respuesta;

        if (producto.id) {
            respuesta = await fetch(URL + producto.id, {
                method: 'PUT',
                body: JSON.stringify(producto),
                headers: {
                    "Content-Type": "application/json"
                }
            });
        } else {
            respuesta = await fetch(URL, {
                method: 'POST',
                body: JSON.stringify(producto),
                headers: {
                    "Content-Type": "application/json"
                }
            });
        }

        if (!respuesta.ok) {
            throw { message: respuesta.statusText };
        }

        mostrarTabla();

        mostrarAlerta('Registro guardado correctamente', 'success');
    } catch (error) {
        mostrarAlerta('No se ha podido guardar el registro: ' + error.message, 'danger');
    }
}

function rellenarTabla() {
    datatable.ajax.reload();
}

async function formulario(id) {
    try {
        mostrarFormulario();

        let producto = { id: undefined, nombre: '', precio: undefined, garantia: undefined };

        if (id) {
            const respuesta = await fetch(URL + id);

            if (!respuesta.ok) {
                throw { message: respuesta.statusText };
            }

            producto = await respuesta.json();
        }

        inputId.valueAsNumber = producto.id;
        inputNombre.value = producto.nombre;
        inputPrecio.valueAsNumber = producto.precio;
        inputGarantia.value = producto.garantia;

        mostrarAlerta('Datos mostrados correctamente', 'success');
    } catch (error) {
        mostrarAlerta('No se han podido mostrar los datos en el formulario: ' + error.message, 'danger');
    }
}

async function borrar(id) {
    confirmar.dataset.id = id;
    numeroRegistro.innerHTML = id;

    estasSeguro.show();
}

async function borrarConfirmado() {
    try {
        const id = this.dataset.id;

        const respuesta = await fetch(URL + id, {
            method: 'DELETE'
        });

        if (!respuesta.ok) {
            throw { message: respuesta.statusText };
        }

        estasSeguro.hide();

        rellenarTabla();

        mostrarAlerta('Registro borrado correctamente', 'success');
    } catch (error) {
        mostrarAlerta('No se ha podido borrar el registro: ' + error.message, 'danger');
    }
}

function mostrarFormulario() {
    tabla.style.display = 'none';
    form.style.display = 'block';
}

function mostrarTabla() {
    if (datatable) {
        rellenarTabla();
    } else {

        datatable = $('table').DataTable({
            ajax: {
                url: URL,
                dataSrc: '',
            },
            language: {
                url: '//cdn.datatables.net/plug-ins/1.13.3/i18n/es-ES.json',
            }, 
            columns: [
                { data: 'id' },
                { data: 'nombre' },
                { data: 'precio' },
                { data: 'garantia' },
                { data: null }
            ],
            columnDefs: [
                {
                    targets: -1,
                    data: id,
                    render: function (data, type, row, meta) {
                        return `
                            <a class="btn btn-sm btn-primary" href="javascript:formulario(${data.id})">Editar</a>
                            <a class="btn btn-sm btn-danger" href="javascript:borrar(${data.id})">Borrar</a>`;
                    }
                },
            ],
        });
    }

    tabla.style.display = 'table';
    form.style.display = 'none';
}

function mostrarAlerta(mensaje, nivel) {
    cerrarAlerta();

    mensajeAlerta.innerHTML = mensaje;
    alerta.classList.add('alert-' + nivel);

    nivelUltimaAlerta = nivel;

    alerta.style.display = 'block';
}

function cerrarAlerta() {
    alerta.style.display = 'none';

    alerta.classList.remove('alert-' + nivelUltimaAlerta);
}
