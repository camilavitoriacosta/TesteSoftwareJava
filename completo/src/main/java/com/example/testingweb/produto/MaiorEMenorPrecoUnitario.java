package com.example.testingweb.produto;

import com.example.testingweb.carrinho.CarrinhoDeCompra;
import com.example.testingweb.carrinho.ItemDoCarrinho;

public class MaiorEMenorPrecoUnitario {

    private Produto menor;

    private Produto maior;

    public void encontra(CarrinhoDeCompra carrinho) throws CarrinhoVazioException {
        verificarCarrinhoVazio(carrinho);

        for (ItemDoCarrinho item : carrinho.getItensDoCarrinho()) {
            if (verificarSeEhMenor(item)) {
                menor = item.getProduto();
            }

            if (verificarSeEhMaior(item)) {
                maior = item.getProduto();
            }
        }
    }

    private boolean verificarSeEhMaior(ItemDoCarrinho item) {
        return maior == null || item.getProduto().getValorUnitario() > maior.getValorUnitario();
    }

    private boolean verificarSeEhMenor(ItemDoCarrinho item) {
        return menor == null || item.getProduto().getValorUnitario() < menor.getValorUnitario();
    }

    private void verificarCarrinhoVazio(CarrinhoDeCompra carrinho) throws CarrinhoVazioException {
        if (carrinho.getItensDoCarrinho().size() == 0) {
            throw new CarrinhoVazioException();
        }
    }

    public Produto getMenor() {
        return menor;
    }

    public Produto getMaior() {
        return maior;
    }

}
