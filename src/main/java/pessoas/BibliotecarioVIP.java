package pessoas;

import livros.Livro;
import bancosDeDados.BancoDeDadosLivros.estados;
import bancosDeDados.Sistema;

public class BibliotecarioVIP extends Bibliotecario {

	public BibliotecarioVIP(Sistema s, String nome) {
		super(s, nome);
		// TODO Auto-generated constructor stub
	}

	public void blockExtravio(Usuario u, Livro l) {
		// TODO Auto-generated method stub
		s_.blockExtravio (u, l);
	}

	public estados search(Livro l) {
		// TODO Auto-generated method stub
		return s_.search(l);
	}

}
