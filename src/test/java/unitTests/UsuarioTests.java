package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import pessoas.Usuario;
import bancosDeDados.BancoDeDadosLivros;
import bancosDeDados.BancoDeDadosUsuarios;
import bancosDeDados.Sistema;

public class UsuarioTests {
	
	private Sistema s_;
	private BancoDeDadosUsuarios bu_;
	private BancoDeDadosLivros bl_;
	private Usuario u_;

	@Before
	public void init () {
		u_ = new Usuario ("Arnaldo");
		
		bu_ = Mockito.mock(BancoDeDadosUsuarios.class);
		bl_ = Mockito.mock(BancoDeDadosLivros.class);
		
		s_ = new Sistema(bl_, bu_);
		
		Mockito.when (bu_.validate(u_)).thenReturn (false);
	}
	
	@Test
	public void UsuarioAcessaOSistemaSeCadastrado () {
		assertFalse(s_.login (u_));
		
		s_.add(u_);
		Mockito.when (bu_.validate(u_)).thenReturn (true);
		
		assertTrue(s_.login (u_));
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
