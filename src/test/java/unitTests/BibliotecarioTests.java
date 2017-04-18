package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import pessoas.Bibliotecario;
import pessoas.Usuario;
import bancosDeDados.BancoDeDadosUsuarios;

public class BibliotecarioTests {
	
	private BancoDeDadosUsuarios bu_;
	
	private Bibliotecario b_;
	
	@Before
	public void init () {
		bu_ = Mockito.mock(BancoDeDadosUsuarios.class);
		
		b_ = new Bibliotecario(bu_, "Juliana");
	}

	@Test
	public void AoInserirNovoUsuarioEleEhInseridoNoBancoDeDados () {
		Usuario u = new Usuario("Arnaldo");
		
		b_.addUser(u);
		
		Mockito.verify(bu_, Mockito.times(1)).add(u);
	}
	
	@Test
	public void AoExcluirUsuarioEleEhExcluidoDoBancoDeDados () {
		Usuario u = new Usuario ("Arnaldo");
		
		b_.addUser(u);
		b_.rmUser(u);
		
		Mockito.verify(bu_, Mockito.times(1)).rm(u);
	}
	
	@Test
	public void AoBloquearUsuarioInativo () {
		fail ("Not yet implemented");
	}
}
