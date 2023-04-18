const URL = 'http://localhost:8080/api/v1/clientes';

let tabla;
let formulario;
let inputId;
let inputNombre;
let inputNif;

window.addEventListener('DOMContentLoaded', function() {
	refrescarTabla();

	tabla = document.querySelector('table');
	formulario = document.querySelector('#formulario');

	inputId = document.querySelector('#id');
	inputNombre = document.querySelector('#nombre');
	inputNif = document.querySelector('#nif');

	mostrarTabla();

	document.querySelector('#anadir').addEventListener('click', mostrarFormulario);
	document.querySelector('#guardar').addEventListener('click', guardar);

});

async function guardar(e) {
	e.preventDefault();
	
	const cliente = { nif: inputNif.value, nombre: inputNombre.value };
	
	let metodo = 'POST';
	let url = URL;
	
	if(inputId.value) {
		metodo = 'PUT';
		url += '/' + cliente.id;
		cliente.id = inputId.value;
	}
	
	const respuesta = await fetch(url, {
		method: metodo,
		body: JSON.stringify(cliente),
		headers: {
			'Content-Type': 'application/json'
		}
	});
	
	console.log(respuesta);
	
	refrescarTabla();
	mostrarTabla();
}

function mostrarTabla() {
	tabla.style.display = 'table';
	formulario.style.display = 'none';
}

function mostrarFormulario() {
	tabla.style.display = 'none';
	formulario.style.display = 'block';
}

async function refrescarTabla() {
	const respuesta = await fetch(URL);
	const clientes = await respuesta.json();
	const tbody = document.querySelector('tbody');

	tbody.innerHTML = '';

	let tr;
	clientes.forEach(cliente => {
		tr = document.createElement('tr');
		tr.innerHTML = `
					<th>${cliente.id}</th>
					<td>${cliente.nif}</td>
					<td>${cliente.nombre}</td>
					<td><a class="btn btn-sm btn-primary"
						href="javascript:editar(${cliente.id})">Editar</a>
						<a class="btn btn-sm btn-danger"
						href="javascript:borrar(${cliente.id})">Borrar</a>
					</td>
				`;
		tbody.appendChild(tr);
	});
}

async function editar(id) {
	const respuesta = await fetch(`${URL}/${id}`);
	const cliente = await respuesta.json();

	inputId.value = cliente.id;
	inputNif.value = cliente.nif;
	inputNombre.value = cliente.nombre;

	mostrarFormulario();
}

async function borrar(id) {
	const respuesta = await fetch(`${URL}/${id}`, { method: 'DELETE' });

	console.log(respuesta);

	refrescarTabla();
	mostrarTabla();
}