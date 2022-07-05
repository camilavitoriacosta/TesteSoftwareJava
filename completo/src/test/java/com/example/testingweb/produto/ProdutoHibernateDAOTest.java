package com.example.testingweb.produto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.testingweb.TestingWebApplication;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestingWebApplication.class })
@DataJpaTest
public class ProdutoHibernateDAOTest {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	private Produto geladeira;
	private Produto fogao;
	private Produto microondas;
	
	@BeforeEach
	public void init() throws Exception {
		geladeira = new Produto("Geladeira", 1200d);
		produtoRepository.save(geladeira);
		fogao = new Produto("Fogão", 1000d);
		produtoRepository.save(fogao);
		microondas = new Produto("Microondas", 200d);
		produtoRepository.save(microondas);
	}
	
	@Test
	public void deve_salvar_um_produto() throws Exception {
		Produto produto = new Produto("Geladeira", 1200d);
		
		produtoRepository.save(produto);
		
		assertNotNull(produtoRepository.findById(produto.getId()));
	}
	
	@Test
	public void deve_buscar_produtos_por_faixa_de_preco() throws Exception {
		double precoMinimo = 1000d;
		double precoMaximo = 1500d;
		
		List<Produto> produtosRetornados = produtoRepository.buscarPorFaixaDePreco(precoMinimo, precoMaximo);
		
		assertThat(produtosRetornados).contains(geladeira, fogao);
	}
}
