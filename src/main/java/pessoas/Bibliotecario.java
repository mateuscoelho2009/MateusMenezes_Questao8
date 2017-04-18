package pessoas;

//import bancosDeDados.BancoDeDadosLivros;
import bancosDeDados.BancoDeDadosUsuarios;

public class Bibliotecario {
	private String nome_;
	//private BancoDeDadosLivros bl_;
	private BancoDeDadosUsuarios bu_;
	
	public Bibliotecario(BancoDeDadosUsuarios bu, String nome) {
		bu_ = bu;
		nome_ = nome;
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
}
