package com.example.testingweb.builders;

import java.util.ArrayList;
import java.util.List;

import com.example.testingweb.carrinho.CarrinhoDeCompra;
import com.example.testingweb.carrinho.ItemDoCarrinho;
import com.example.testingweb.produto.Produto;
import com.example.testingweb.produto.ValorInvalidoException;

public class CarrinhoDeCompraBuilder {
    private static final int UMA_UNIDADE = 1;
    private Produto geladeira;
    private Produto liquidificador;
    private Produto pratos;
    private List<ItemDoCarrinho> itens = new ArrayList<>();

    public CarrinhoDeCompraBuilder() throws ValorInvalidoException {
        geladeira = new Produto("Geladeira", 450.0);
        liquidificador = new Produto("Liquidificador", 250.0);
        pratos = new Produto("Jogo de pratos", 70.0);
    }

    public CarrinhoDeCompra construir() {
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();
        for (ItemDoCarrinho item : itens) {
            carrinhoDeCompra.adicionar(item);
        }
        return carrinhoDeCompra;
    }

    public CarrinhoDeCompraBuilder emOrdemCrescente() {
        itens.add(new ItemDoCarrinho(pratos, UMA_UNIDADE));
        itens.add(new ItemDoCarrinho(liquidificador, UMA_UNIDADE));
        itens.add(new ItemDoCarrinho(geladeira, UMA_UNIDADE));
        return this;
    }

    public CarrinhoDeCompraBuilder emOrdemDecrescente() {
        itens.add(new ItemDoCarrinho(geladeira, UMA_UNIDADE));
        itens.add(new ItemDoCarrinho(liquidificador, UMA_UNIDADE));
        itens.add(new ItemDoCarrinho(pratos, UMA_UNIDADE));
        return this;
    }

    public CarrinhoDeCompraBuilder comItemDoCarrinho(ItemDoCarrinho itemDoCarrinho) {
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();
        carrinhoDeCompra.adicionar(itemDoCarrinho);
        return this;
    }
}
