package pessoas;

import bancosDeDados.Sistema;

public class Usuario {
	private String nomeUnico_;
	private Sistema s_ = null;
	
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
}
