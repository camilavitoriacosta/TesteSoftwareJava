package com.example.testingweb.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdicionaProdutoService {
	private ProdutoRepository produtoRepository;

	@Autowired
	public AdicionaProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoResponse inserir(ProdutoRequest produtoRequest) throws ValorInvalidoException {
		Produto produto = new Produto(produtoRequest.getDescricao(), produtoRequest.getValorUnitario());
		produtoRepository.save(produto);
		return new ProdutoResponse(produto.getId(), produto.getDescricao(), produto.getValorUnitario());
	}
}
