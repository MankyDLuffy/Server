package server;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
	List<Usuario> usuarios = new ArrayList<>();
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	
	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

}
