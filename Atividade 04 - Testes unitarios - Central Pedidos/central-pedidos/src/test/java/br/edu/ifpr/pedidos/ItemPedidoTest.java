package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemPedidoTest {

    @Test
    void deveImpedirSKUNull() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(null, 500, 2, 3, 10, false)
        );

        assertEquals("SKU obrigatório", exception.getMessage());
    }

    @Test
    void deveImpedirSKUVazio() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido(" ", 500, 2, 3, 10, false)
        );

        assertEquals("SKU obrigatório", exception.getMessage());
    }

    @Test
    void deveImpedirPrecoCentavosMenorIgualAZero() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido("abc", 0, 2, 3, 10, false)
        );

        assertEquals("Preço inválido", exception.getMessage());
    }

    @Test
    void deveImpedirPrecoCentavosMaiorQueUmMilhao() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido("abc", 10000000, 2, 3, 10, false)
        );

        assertEquals("Preço inválido", exception.getMessage());
    }

    @Test
    void deveImpedirQuantidadeMenorQueZero() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido("abc", 50, -2, 3, 10, false)
        );

        assertEquals("Quantidade inválida", exception.getMessage());
    }

    @Test
    void deveImpedirQuantidadeMaiorQueCem() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido("abc", 50, 200, 3, 10, false)
        );

        assertEquals("Quantidade inválida", exception.getMessage());
    }

    @Test
    void deveImpedirEstoqueMenorQueZero() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido("abc", 50, 2, -3, 10, false)
        );

        assertEquals("Estoque inválido", exception.getMessage());
    }

    @Test
    void deveImpedirPesoMenorIgualAZero() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido("abc", 50, 2, 3, -10, false)
        );

        assertEquals("Peso inválido", exception.getMessage());
    }

    @Test
    void deveImpedirPesoMaiorQueCemMil() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ItemPedido("abc", 50, 2, 3, 1000000, false)
        );

        assertEquals("Peso inválido", exception.getMessage());
    }

    ItemPedido itemPedido = new ItemPedido("abc", 500, 2, 3, 10, false);

    @Test
    void deveCalcularTotalCentavos() {
        long resultado = itemPedido.totalCentavos();

        assertEquals(1000, resultado);
    }

    @Test
    void deveVerificarDisponivelEstoque() {
        boolean resultado = itemPedido.disponivel();

        assertEquals(true, resultado);
    }

    @Test
    void deveVerificarIndisponivelEstoque() {
        ItemPedido itemPedido2 = new ItemPedido("abc", 500, 2, 1, 10, false);
        boolean resultado = itemPedido2.disponivel();

        assertEquals(false, resultado);
    }
}