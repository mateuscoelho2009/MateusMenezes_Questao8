package unitTests;

import static org.junit.Assert.*;

import java.util.Date;

import livros.Livro;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import pessoas.Bibliotecario;
import pessoas.Usuario;
import bancosDeDados.BancoDeDadosLivros;
import bancosDeDados.BancoDeDadosUsuarios;
import bancosDeDados.Sistema;

public class BibliotecarioTests {
	
	private BancoDeDadosUsuarios bu_;
	private BancoDeDadosLivros bl_;
	private Bibliotecario b_;
	private Usuario u_;
	private Livro l_;
	private Sistema s_;
	
	@Before
	public void init () {
		u_ = new Usuario ("Arnaldo");
		l_ = new Livro ("Psicologia Social", "Aroldo Rodrigues", 14522);
		
		bu_ = Mockito.mock(BancoDeDadosUsuarios.class);
		bl_ = Mockito.mock(BancoDeDadosLivros.class);
		
		s_ = new Sistema(bl_, bu_);
		
		b_ = new Bibliotecario(s_, "Juliana");
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
		Date d = Mockito.mock(Date.class);
		
		b_.regEmpr (u_, l_, d);
		
		Mockito.verify(bu_, Mockito.times(1)).addCommitment(u_, l_, d);
		Mockito.verify(bl_, Mockito.times(1)).regEmpr(l_, u_, d);
	}
	
	@Test
	public void AoRegistrarDevolucaoModificarStatusNoBancoDeDados () {
		b_.regDev (u_, l_);
		
		Mockito.verify(bu_, Mockito.times(1)).rmCommitment(u_, l_);
		Mockito.verify(bl_, Mockito.times(1)).regDev(l_, u_);
	}
}
