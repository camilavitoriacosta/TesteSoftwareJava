package com.example.testingweb.produto;

import com.example.testingweb.carrinho.CarrinhoDeCompra;
import com.example.testingweb.carrinho.ItemDoCarrinho;

public class TestaMaiorEMenor {
    public static void main(String[] args) throws ValorInvalidoException, CarrinhoVazioException {
        Produto liquidificador = new Produto("Liquidificador", 250.0);
        Produto geladeira = new Produto("Geladeira", 450.0);
        Produto pratos = new Produto("Jogo de pratos", 70.0);

        CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
        carrinho.adicionar(new ItemDoCarrinho(liquidificador, 1));
        carrinho.adicionar(new ItemDoCarrinho(geladeira, 1));
        carrinho.adicionar(new ItemDoCarrinho(pratos, 1));

        MaiorEMenorPrecoUnitario algoritmo = new MaiorEMenorPrecoUnitario();
        algoritmo.encontra(carrinho);

        System.out.println("O menor produto: " +
                algoritmo.getMenor().getDescricao());
        System.out.println("O maior produto: " +
                algoritmo.getMaior().getDescricao());
    }
}