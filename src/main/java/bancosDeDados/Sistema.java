package bancosDeDados;

import java.util.Date;

import bancosDeDados.BancoDeDadosLivros.estadoVal;
import bancosDeDados.BancoDeDadosLivros.estados;
import livros.Livro;
import pessoas.Usuario;
import pessoas.UsuarioVIP;

public class Sistema {
	private BancoDeDadosLivros bl_;
	private BancoDeDadosUsuarios bu_;
	
	
	public Sistema (BancoDeDadosLivros bl, BancoDeDadosUsuarios bu){
		bl_ = bl;
		bu_ = bu;
	};
	
	public void add(Usuario u) {
		// TODO Auto-generated method stub
		bu_.add(u);
	}



	public void rm(Usuario u) {
		// TODO Auto-generated method stub
		bu_.rm(u);
	}



	public void block(Usuario u, int days, int months, int years) {
		// TODO Auto-generated method stub
		bu_.block(u, days, months, years);
	}



	public void addCommitment(Usuario u, Livro l, Date deliverDate) {
		// TODO Auto-generated method stub
		bu_.addCommitment(u, l, deliverDate);
	}



	public void regEmpr(Livro l, Usuario u, Date deliverDate) {
		// TODO Auto-generated method stub
		bl_.regEmpr(l, u, deliverDate);
	}



	public void rmCommitment(Usuario u, Livro l) {
		// TODO Auto-generated method stub
		bu_.rmCommitment(u, l);
		
	}



	public void regDev(Livro l, Usuario u) {
		// TODO Auto-generated method stub
		bl_.regDev(l, u);
	}

	public boolean login (Usuario u_) {
		// TODO Auto-generated method stub
		if (bu_.validate (u_)) {
			u_.login (this);
			
			return true;
		}
		
		return false;
	}

	public estados search(Livro l_) {
		// TODO Auto-generated method stub
		return bl_.search(l_);
	}

	public Livro[] listaLivros(UsuarioVIP usuario) {
		return bu_.getLivros(usuario);
	}

	public estadoVal[] listaEstados(UsuarioVIP usuarioVIP) {
		// TODO Auto-generated method stub
		return bu_.getEstados(usuarioVIP);
	}
	
	
}
