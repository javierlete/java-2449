package com.ipartek.formacion.ipartekzon.dal;

import com.ipartek.formacion.ipartekzon.modelos.Cliente;

public interface DaoCliente extends Dao<Cliente> {
	Cliente buscarPorNif(String nif);
}
