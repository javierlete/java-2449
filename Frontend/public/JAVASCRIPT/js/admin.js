'use strict';

const productos = [
    { id: 1, nombre: 'Portátil', precio: 1234.12, garantia: new Date() },
    { id: 2, nombre: 'Monitor', precio: 123.12, garantia: new Date() },
    { id: 3, nombre: 'Ratón', precio: 12.12, garantia: new Date() },
];

window.addEventListener('DOMContentLoaded', function() {
    const tbody = document.querySelector('tbody');

    let tr;
    
    productos.forEach(producto => {
        tr = document.createElement('tr');
        tr.innerHTML = `
            <th>${producto.id}</th>
            <td>${producto.nombre}</td>
            <td>${producto.precio}</td>
            <td>${producto.garantia.toLocaleDateString()}</td>
            <td></td>`;
        
        tbody.appendChild(tr);
    });
});