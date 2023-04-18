const URL = 'http://localhost:8080/api/v1/clientes';

let tabla;
let formulario;

window.addEventListener('DOMContentLoaded', function() {
	refrescarTabla();

	tabla = document.querySelector('table');
	formulario = document.querySelector('#formulario');

	mostrarTabla();

	const anadir = document.querySelector('#anadir');

	anadir.addEventListener('click', mostrarFormulario);

	const guardar = document.querySelector('#guardar');

	guardar.addEventListener('click', function(e) {
		e.preventDefault();
		mostrarTabla();
	});

});

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

function editar(id) {
	
}

async function borrar(id) {
	const respuesta = await fetch(`${URL}/${id}`, { method: 'DELETE' });
	
	console.log(respuesta);
	
	refrescarTabla();
	mostrarTabla();
}