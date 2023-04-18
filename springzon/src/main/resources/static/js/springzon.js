const URL = 'http://localhost:8080/api/v1/clientes';

window.addEventListener('DOMContentLoaded', async function() {
	refrescarTabla();
});

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
						href="#">Editar</a>
						<a class="btn btn-sm btn-danger"
						href="#">Borrar</a>
					</td>
				`;
		tbody.appendChild(tr);
	});
}
