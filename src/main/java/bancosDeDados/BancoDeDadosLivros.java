package bancosDeDados;

import java.util.Date;

import bancosDeDados.BancoDeDadosLivros.estados;
import livros.Livro;
import pessoas.Usuario;

public class BancoDeDadosLivros {

	public enum estados {RETIRADO, DISPONIVEL, ESTRAVIADO};
	public enum estadoVal {PRAZO, VENCIDO};
	
	public void regEmpr(Livro l_, Usuario u_, Date deliverDate) {
		
	}

	public void regDev(Livro l, Usuario u) {
		
	}

	public estados search(Livro l) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
