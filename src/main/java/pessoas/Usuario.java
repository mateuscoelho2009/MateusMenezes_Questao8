package pessoas;

import livros.Livro;
import bancosDeDados.BancoDeDadosLivros;
import bancosDeDados.BancoDeDadosLivros.estadoVal;
import bancosDeDados.Sistema;

public class Usuario {
	private String nomeUnico_;
	protected Sistema s_ = null;
	public enum estadosUser {BLOQUEADO_POR_ATRASO, BLOQUEADO_POR_COBRANCA, LIBERADO, BLOQUEADO_POR_EXTRAVIO};
	
	public Usuario(String nome) {
		nomeUnico_ = nome;
	}
	
	public String getNome () {
		return nomeUnico_;
	}

	public void login(Sistema sistema) {
		// TODO Auto-generated method stub
		s_ = sistema;
	}

	public BancoDeDadosLivros.estados search(Livro l_) {
		// TODO Auto-generated method stub
		return s_.search (l_);
	}
}
