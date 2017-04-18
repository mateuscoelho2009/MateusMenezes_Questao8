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
	
	private Usuario u_;
	
	@Before
	public void init () {
		u_ = new Usuario ("Arnaldo");
		
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
		b_.addUser(u_);
		b_.rmUser(u_);
		
		Mockito.verify(bu_, Mockito.times(1)).rm(u_);
	}
	
	@Test
	public void AoBloquearUsuarioInativo () {
		b_.addUser(u_);
		
		b_.block (u_, 0, 1, 0);
		
		Mockito.verify(bu_, Mockito.times(1)).block(u_, 0, 1, 0);
	}
	
	@Test
	public void AoRegistrarEmprestimoModificarStatusNoBancoDeDados () {
		fail ("Não implementados");
	}
	
	@Test
	public void AoRegistrarDevolucaoModificarStatusNoBancoDeDados () {
		fail ("Não implementados");
	}
}
