package pessoas;

import java.util.Date;

import livros.Livro;
import bancosDeDados.Sistema;

public class Bibliotecario {
	private String nome_;
	private Sistema s_;
	
	public Bibliotecario(Sistema s, String nome) {
		nome_ = nome;
		s_ = s;
	}

	public void addUser(Usuario u) {
		s_.add(u);
	}

	public void rmUser(Usuario u) {
		// TODO Auto-generated method stub
		s_.rm(u);
	}

	public void block(Usuario u, int days, int months, int years) {
		// TODO Auto-generated method stub
		s_.block (u, days, months, years);
	}

	public void regEmpr(Usuario u, Livro l, Date deliverDate) {
		s_.addCommitment (u, l, deliverDate);
		s_.regEmpr (l, u, deliverDate);
	}

	public void regDev(Usuario u, Livro l) {
		s_.rmCommitment (u, l);
		s_.regDev (l, u);
	}
}
