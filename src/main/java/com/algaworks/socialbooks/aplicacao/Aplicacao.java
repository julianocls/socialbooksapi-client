package com.algaworks.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.algaworks.socialbooks.client.LivrosClient;
import com.algaworks.socialbooks.client.domain.Livro;

public class Aplicacao {
	
	public static void main(String[] args) throws ParseException {
		
		LivrosClient client = new LivrosClient("http://localhost:8080", "algaworks", "s3nh4");
		
		
		Livro livro = new Livro();
		livro.setNome("Git passo-a-passo");
		livro.setEditora("AlgaWorks");
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("01/01/2016"));
		livro.setResumo("este livro aborda tecnicas de desenvolvimento de APIs.");
		
		String localizacao1 = client.salvar(livro);
		
		System.out.println("URI do livro salvo: " + localizacao1);
		
		System.out.println("Cadastro -------------------------------------------");
		
		
	    livro = new Livro();
		livro.setNome("Rest Aplicado");
		livro.setEditora("AlgaWorks");

		livro.setPublicacao(publicacao.parse("01/01/2016"));
		livro.setResumo("este livro aborda tecnicas de versionamento.");
		
	    String localizacao2 = client.salvar(livro);
		
		System.out.println("URI do livro salvo: " + localizacao2);
		
		
		System.out.println("Cadastro -------------------------------------------");

		
		List<Livro> listaLivros = client.listar();
		for(Livro livro2 : listaLivros) {
			System.out.println("Livro: " + livro2.getNome());
		}
		
		System.out.println("Listar -------------------------------------------");
		
		Livro livro3 = client.buscar(localizacao1);
		System.out.println("Livro: " + livro3.getNome());
		
		livro3 = client.buscar(localizacao2);
		System.out.println("Livro: " + livro3.getNome());

		
		System.out.println("Buscar -------------------------------------------");

		
		
		
	}

}
