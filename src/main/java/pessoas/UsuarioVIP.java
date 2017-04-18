package pessoas;

import bancosDeDados.BancoDeDadosLivros.estadoVal;
import livros.Livro;

public class UsuarioVIP extends Usuario {

	public UsuarioVIP(String nome) {
		super(nome);
	}

	public Livro[] listaLivros() {
		// TODO Auto-generated method stub
		return s_.listaLivros(this);
	}

	public estadoVal[] listaEstados() {
		// TODO Auto-generated method stub
		return s_.listaEstados(this);
	}
	
	
	
}
