package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.dominio.servico.Avaliador;

public class TesteDoAvaliador {
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		
	Usuario joao = new Usuario("jooao");
	Usuario jose = new Usuario("jose");
	Usuario maria = new Usuario("maria");
	
	Leilao leilao = new  Leilao("playstation 3 novo");

    leilao.propoe(new Lance(joao, 300.0));
    leilao.propoe(new Lance(jose, 400.0));
    leilao.propoe(new Lance(maria, 250.0));

    Avaliador leiloeiro = new Avaliador();
    leiloeiro.avalia(leilao);
    double maiorEsperado = 400;
    double menorEsperado = 250;
		/*
		 * System.out.println(leiloeiro.getMaiorLance()); // imprime 400.0
		 * System.out.println(leiloeiro.getMenorLance()); // imprime 250
		 * 
		 * assertEquals(esperado, calculado)
		 */	
    
	
    assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 400);
    assertEquals(menorEsperado, leiloeiro.getMenorLance(), 250);
	
	}
	
	 @Test
	    public void testaMediaDeZeroLance(){

	        // cenario
	        Usuario ewertom = new Usuario("Ewertom");

	        // acao
	        Leilao leilao = new Leilao("Iphone 7");

	        Avaliador avaliador = new Avaliador();
	        avaliador.avalia(leilao);

	        //validacao
	        assertEquals(0, avaliador.getMedia(), 0.0001);

	    }
	 
	  @Test
	    public void deveEntenderLeilaoComApenasUmLance1() {
	        Usuario joao = new Usuario("Jo�o"); 
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao, 1000.0));

	        Avaliador leiloeiro = new Avaliador();
	        leiloeiro.avalia(leilao);

	        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.0001);
	       assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
	    }
	  
	  

	    @Test
	    public void deveEncontrarOsTresMaioresLances() {
	        Usuario joao = new Usuario("Jo�o");
	        Usuario maria = new Usuario("Maria");
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao, 100.0));
	        leilao.propoe(new Lance(maria, 200.0));
	        leilao.propoe(new Lance(joao, 300.0));
	        leilao.propoe(new Lance(maria, 400.0));

	        Avaliador leiloeiro = new Avaliador();
	        leiloeiro.avalia(leilao);

	        List<Lance> maiores = leiloeiro.getTresMaiores();

	        assertEquals(3, maiores.size());
	    }
}
