package com.example.testingweb.produto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.testingweb.TestingWebApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = TestingWebApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class ProdutoControllerTest {

	@Autowired
    private MockMvc mvc;

    @Autowired
    private ProdutoRepository repository;
	
	@AfterEach
    public void resetDb() {
        repository.deleteAll();
    }

	@Test
	public void deve_trazer_um_produto_pelo_id() throws Exception {
		
	}
	
	@Test
	public void deve_retornar_todos_os_produtos() throws Exception {
		
	//	assertTrue(5 == id);
	//	assertEquals("Geladeira", descricao);
	//	assertTrue(1200d == valorUnitario);
	}
	
	@Test
	public void deve_adicionar_um_produto() throws Exception {
		String descricaoProduto = "iPad";
		ProdutoRequest produtoRequest = new ProdutoRequest(descricaoProduto, 3000d);
        mvc.perform(post("/api/produtos").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(produtoRequest)));

        List<Produto> found = repository.findAll();
        Assertions.assertThat(found).extracting(Produto::getDescricao).containsOnly(descricaoProduto);
	}
	
	@Test
	public void deve_excluir_um_produto() throws Exception {
		
	}
	
	@Test
	public void deve_trazer_um_produto_pelo_id_json_path() throws Exception {
		
	}
}
