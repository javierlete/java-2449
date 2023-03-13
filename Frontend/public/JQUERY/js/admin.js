'use strict';

var URL = 'http://localhost:3000/productos/';

var productos;

var estasSeguro;
var nivelUltimaAlerta;

var datatable;

$(function () {
    estasSeguro = new bootstrap.Modal('#estasSeguro');

    $('form button').on('click', guardar);
    $('#confirmar').on('click', borrarConfirmado);
    $('.alert button').on('click', cerrarAlerta);

    cerrarAlerta();

    mostrarTabla();
});

async function guardar() {
    try {
        if (!$('form')[0].checkValidity()) {
            $('form').addClass('was-validated');
            mostrarAlerta('Hay datos incorrectos en el formulario', 'danger');
            return;
        }

        var producto = {
            id: $('#id')[0].valueAsNumber,
            nombre: $('#nombre')[0].value,
            precio: $('#precio')[0].valueAsNumber,
            garantia: $('#garantia')[0].value,
        };

        var respuesta;

        if (producto.id) {
            $.ajax(URL + producto.id, {
                method: 'PUT',
                data: JSON.stringify(producto),
                contentType: 'application/json'
            }).done(function (data, textStatus, jqXHR) {
                mostrarTabla();

                mostrarAlerta('Registro guardado correctamente', 'success');
            }).fail(function (jqXHR, textStatus, errorThrown) {
                throw { message: textStatus };
            });
        } else {
            $.ajax(URL, {
                method: 'POST',
                data: JSON.stringify(producto),
                contentType: 'application/json'
            }).done(function (data, textStatus, jqXHR) {
                mostrarTabla();

                mostrarAlerta('Registro guardado correctamente', 'success');
            }).fail(function (jqXHR, textStatus, errorThrown) {
                throw { message: textStatus };
            });
        }
    } catch (error) {
        mostrarAlerta('No se ha podido guardar el registro: ' + error.message, 'danger');
    }
}

function rellenarTabla() {
    datatable.ajax.reload();
}

function formulario(id) {
    try {
        mostrarFormulario();

        var producto = { id: undefined, nombre: '', precio: undefined, garantia: undefined };

        $('#id')[0].valueAsNumber = producto.id;
        $('#nombre')[0].value = producto.nombre;
        $('#precio')[0].valueAsNumber = producto.precio;
        $('#garantia')[0].value = producto.garantia;

        if (id) {
            $.get(URL + id, function (producto) {
                $('#id')[0].valueAsNumber = producto.id;
                $('#nombre')[0].value = producto.nombre;
                $('#precio')[0].valueAsNumber = producto.precio;
                $('#garantia')[0].value = producto.garantia;

                mostrarAlerta('Datos mostrados correctamente', 'success');
            }).fail(function (jqXHR, textStatus, errorThrown) {
                throw { message: textStatus };
            });
        }

    } catch (error) {
        mostrarAlerta('No se han podido mostrar los datos en el formulario: ' + error.message, 'danger');
    }
}

function borrar(id) {
    $('#confirmar')[0].dataset.id = id;
    $('#numero-registro').html(id);

    estasSeguro.show();
}

function borrarConfirmado() {
    try {
        var id = this.dataset.id;

        $.ajax(URL + id, {
            method: 'DELETE'
        }).done(function() {
            estasSeguro.hide();

            rellenarTabla();
    
            mostrarAlerta('Registro borrado correctamente', 'success');
        }).fail(function (jqXHR, textStatus, errorThrown) {
            throw { message: textStatus };
        });
    } catch (error) {
        mostrarAlerta('No se ha podido borrar el registro: ' + error.message, 'danger');
    }
}

function mostrarFormulario() {
    $('table').hide();
    $('form').show();
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

    $('table').show();
    $('form').hide();
}

function mostrarAlerta(mensaje, nivel) {
    cerrarAlerta();

    $('.alert span').html(mensaje);
    $('.alert').addClass('alert-' + nivel);

    nivelUltimaAlerta = nivel;

    $('.alert').show();
}

function cerrarAlerta() {
    $('.alert').hide();

    $('.alert').removeClass('alert-' + nivelUltimaAlerta);
}
