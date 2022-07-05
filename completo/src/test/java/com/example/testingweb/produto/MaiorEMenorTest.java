package com.example.testingweb.produto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.testingweb.builders.CarrinhoDeCompraBuilder;
import com.example.testingweb.carrinho.CarrinhoDeCompra;

public class MaiorEMenorTest {
    private static final int UM = 1;
    private Produto geladeira;
    private Produto liquidificador;
    private Produto pratos;

    @BeforeEach
    public void inicializar() throws Exception {
        geladeira = new Produto("Geladeira", 450.0);
        liquidificador = new Produto("Liquidificador", 250.0);
        pratos = new Produto("Jogo de pratos", 70.0);
    }

    @Test
    public void deve_verificar_o_menor_em_ordem_decrescente() throws Exception {
        CarrinhoDeCompra carrinho = new CarrinhoDeCompraBuilder().emOrdemDecrescente().construir();

        MaiorEMenorPrecoUnitario algoritmo = new MaiorEMenorPrecoUnitario();
        algoritmo.encontra(carrinho);

        Assertions.assertEquals(pratos, algoritmo.getMenor());
    }

    @Test
    public void deve_verificar_o_maior_em_ordem_decrescente() throws Exception {
        CarrinhoDeCompra carrinho = new CarrinhoDeCompraBuilder().emOrdemDecrescente().construir();

        MaiorEMenorPrecoUnitario algoritmo = new MaiorEMenorPrecoUnitario();
        algoritmo.encontra(carrinho);

        Assertions.assertEquals(geladeira, algoritmo.getMaior());
    }

    @Test
    public void deve_verificar_o_maior_em_ordem_crescente() throws Exception {
        CarrinhoDeCompra carrinho = new CarrinhoDeCompraBuilder().emOrdemCrescente().construir();

        MaiorEMenorPrecoUnitario algoritmo = new MaiorEMenorPrecoUnitario();
        algoritmo.encontra(carrinho);

        Assertions.assertEquals(geladeira.getValorUnitario(), algoritmo.getMaior().getValorUnitario());
    }

    // apenas um produto

    @Test // carrinho sem produto
    public void deve_lancar_excecao_para_carrinho_sem_produtos() throws Exception {
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompraBuilder().construir();

        MaiorEMenorPrecoUnitario maiorEMenorPrecoUnitario = new MaiorEMenorPrecoUnitario();
        Assertions.assertThrows(CarrinhoVazioException.class, () -> {
            maiorEMenorPrecoUnitario.encontra(carrinhoDeCompra);
        });
    }
}