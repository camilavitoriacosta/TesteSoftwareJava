package com.example.testingweb.produto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProdutoController {

	@Autowired
	private ConsultaProdutoService consultaProdutoService;
	
	@Autowired
	private AdicionaProdutoService adicionaProdutoService;
	
	@Autowired
	private RemoveProdutoService removeProdutoService;
	
	@PostMapping("/produtos")
	public ResponseEntity<ProdutoResponse> salvar(@RequestBody ProdutoRequest produtoRequest) throws ValorInvalidoException {
		HttpStatus status = HttpStatus.CREATED;
        ProdutoResponse saved = adicionaProdutoService.inserir(produtoRequest);
        return new ResponseEntity<>(saved, status);
	}

	@GetMapping("/produtos")
	public List<ProdutoResponse> getProdutos() {
		return consultaProdutoService.buscarTodos();
	}

	@GetMapping("/produtos/{id}")
	public ProdutoResponse getProdutoPeloId(@PathVariable Long id) {
		return consultaProdutoService.buscarProdutoPeloId(id);
	}

	@DeleteMapping("/produtos/{id}")
  	public void deleteProduto(@PathVariable Long id) {
    	removeProdutoService.remover(id);
  }
}
