package com.ipartek.formacion.clientes.accesodatos;

import com.ipartek.formacion.clientes.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario obtenerPorIdentificativo(String identificativo);
}
