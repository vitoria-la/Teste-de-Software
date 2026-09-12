package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraFreteTest {
    CalculadoraFrete calculadoraFrete = new CalculadoraFrete();
    Pedido pedido = new Pedido(criarListaItens(), "UF", false, null);
    Cliente clienteNormal = new Cliente(false, false, 0);
    Cliente clienteVIP = new Cliente(true, false, 0);
    
    public List<ItemPedido> criarListaItens() {
        ItemPedido itemPedido1 = new ItemPedido("abc", 20, 2, 7, 200, false);
        ItemPedido itemPedido2 = new ItemPedido("abc123", 20, 2, 7, 200, false);
        List<ItemPedido> lista = new ArrayList<>();
        lista.add(itemPedido1);
        lista.add(itemPedido2);
        return lista;
    }

    @Test
    void deveImpedirLiquidoNegativo() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculadoraFrete.calcular(pedido, clienteNormal, -10)
        );

        assertEquals("Valor líquido negativo", exception.getMessage());
    }

    @Test
    void deveCalcularPRLiquidoMaiorTrintaMilNaoExpresso() {
        Pedido pedidoTeste = new Pedido(criarListaItens(), "PR", false, null);
        long resultado = calculadoraFrete.calcular(pedidoTeste, clienteNormal, 40000);

        assertEquals(0, resultado);
    }

    @Test
    void deveCalcularSPClienteVIP() {
        Pedido pedidoTeste = new Pedido(criarListaItens(), "SP", false, null);
        long resultado = calculadoraFrete.calcular(pedidoTeste, clienteVIP, 4000);

        assertEquals(1000, resultado);
    }

    @Test
    void deveCalcularRJExpresso() {
        Pedido pedidoTeste = new Pedido(criarListaItens(), "RJ", true, null);
        long resultado = calculadoraFrete.calcular(pedidoTeste, clienteNormal, 40000);

        assertEquals(3500, resultado);
    }

    @Test
    void deveCalcularUFDefaultTemFragil() {
        ItemPedido itemPedido3 = new ItemPedido("abc123", 20, 2, 7, 80, true);
        List<ItemPedido> lista = criarListaItens();
        lista.add(itemPedido3);
        Pedido pedidoTeste = new Pedido(lista, "UF", false, null);
        long resultado = calculadoraFrete.calcular(pedidoTeste, clienteNormal, 4000);

        assertEquals(3500, resultado);
    }

    @Test
    void deveCalcularComPesoExcedente() {
        ItemPedido itemPedido3 = new ItemPedido("abc123", 20, 2, 7, 700, true);
        List<ItemPedido> lista = criarListaItens();
        lista.add(itemPedido3);
        Pedido pedidoTeste = new Pedido(lista, "UF", false, null);
        long resultado = calculadoraFrete.calcular(pedidoTeste, clienteNormal, 4000);

        assertEquals(3800, resultado);
    }





}
