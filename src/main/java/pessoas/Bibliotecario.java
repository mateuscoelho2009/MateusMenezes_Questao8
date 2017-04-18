package pessoas;

import java.util.Date;

import livros.Livro;
import bancosDeDados.BancoDeDadosLivros;
import bancosDeDados.BancoDeDadosUsuarios;

public class Bibliotecario {
	private String nome_;
	private BancoDeDadosLivros bl_;
	private BancoDeDadosUsuarios bu_;
	
	public Bibliotecario(BancoDeDadosUsuarios bu, BancoDeDadosLivros bl, String nome) {
		bu_ = bu;
		nome_ = nome;
		bl_ = bl;
	}

	public void addUser(Usuario u) {
		bu_.add(u);
	}

	public void rmUser(Usuario u) {
		// TODO Auto-generated method stub
		bu_.rm(u);
	}

	public void block(Usuario u, int days, int months, int years) {
		// TODO Auto-generated method stub
		bu_.block (u, days, months, years);
	}

	public void regEmpr(Usuario u, Livro l, Date deliverDate) {
		bu_.addCommitment (u, l, deliverDate);
		bl_.regEmpr (l, u, deliverDate);
	}

	public void regDev(Usuario u, Livro l) {
		bu_.rmCommitment (u, l);
		bl_.regDev (l, u);
	}
}
