package unitTests;

import static org.junit.Assert.*;
import livros.Livro;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import pessoas.Usuario;
import pessoas.Usuario.estadosUser;
import pessoas.UsuarioVIP;
import bancosDeDados.BancoDeDadosLivros;
import bancosDeDados.BancoDeDadosLivros.estadoVal;
import bancosDeDados.BancoDeDadosUsuarios;
import bancosDeDados.Sistema;
import bancosDeDados.BancoDeDadosLivros.estados;

public class UsuarioVIPTests {

	private Sistema s_;
	private BancoDeDadosUsuarios bu_;
	private BancoDeDadosLivros bl_;
	private UsuarioVIP u_;
	private Livro l_;

	@Before
	public void init () {
		u_ = new UsuarioVIP ("Arnaldo");
		l_ = new Livro ("Psicologia Social", "Aroldo Rodrigues", 14522);
		
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
	public void UsuarioRecebeEstadoDeLivroAoPesquisar () {
		s_.add(u_);
		Mockito.when (bu_.validate(u_)).thenReturn (true);
		
		assertTrue(s_.login (u_));
		
		Mockito.when (bl_.search (l_)).thenReturn (estados.RETIRADO);
		assertEquals(u_.search (l_), BancoDeDadosLivros.estados.RETIRADO);
		Mockito.when (bl_.search (l_)).thenReturn (estados.DISPONIVEL);
		assertEquals(u_.search (l_), BancoDeDadosLivros.estados.DISPONIVEL);
		Mockito.when (bl_.search (l_)).thenReturn (estados.ESTRAVIADO);
		assertEquals(u_.search (l_), BancoDeDadosLivros.estados.ESTRAVIADO);
		
		Mockito.verify(bl_, Mockito.times(3)).search (l_);
	}
	
	@Test
	public void UsuarioAprimoradoRecebeListaDeLivrosESeusEstadosAoSolicitar () {
		s_.add(u_);
		Mockito.when (bu_.validate(u_)).thenReturn (true);
		
		assertTrue(s_.login (u_));
		
		Livro livros[] = null;
		Livro expLivros[] = {l_};
		estadoVal e[] = null;
		estadoVal expE[] = {estadoVal.VENCIDO};
		
		Mockito.when (bu_.getLivros(u_)).thenReturn (expLivros);
		Mockito.when (bu_.getEstados(u_)).thenReturn (expE);
		
		livros = u_.listaLivros ();
		e = u_.listaEstados ();
		
		if (livros == null || e == null)
			fail ();
		
		assertEquals (livros.length, expLivros.length);
		for (int i = 0; i < livros.length; i++)
			assertEquals(livros[i], expLivros[i]);
		
		assertEquals (e.length, expE.length);
		for (int i = 0; i < e.length; i++)
			assertEquals(e[i], expE[i]);
	}
	
	@Test
	public void UsuarioAprimoradoRecebeSuaSituacaoAoSolicitar () {
		s_.add(u_);
		Mockito.when (bu_.validate(u_)).thenReturn (true);
		
		assertTrue(s_.login (u_));
		
		Mockito.when (bu_.getState(u_)).thenReturn (estadosUser.LIBERADO);
		assertEquals(u_.getState (), estadosUser.LIBERADO);
	}

}
