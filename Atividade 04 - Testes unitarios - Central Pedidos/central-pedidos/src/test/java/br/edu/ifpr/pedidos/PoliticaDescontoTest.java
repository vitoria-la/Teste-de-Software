package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PoliticaDescontoTest {
    private PoliticaDesconto politicaDesconto = new PoliticaDesconto();
    private Cliente clienteVIP = new Cliente(true, false, 0);
    private Cliente clienteNormal = new Cliente(false, false, 0);
    private Cliente clienteAntigo = new Cliente(false, false, 100);

    @Test
    void deveImpedirSubtotalNegativo() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> politicaDesconto.calcular(clienteNormal, -1, "frete grátis")
        );

        assertEquals("Subtotal negativo", exception.getMessage());
    }

    @Test
    void deveCalcularDescontoClienteVIPSemCumpom() {
        long resultado = politicaDesconto.calcular(clienteVIP, 100, null);

        assertEquals(10, resultado);
    }

    @Test
    void deveCalcularDescontoClienteNormalSubtotalMaiorCinquentaMilSemCumpom() {
        long resultado = politicaDesconto.calcular(clienteNormal, 50000, " ");

        assertEquals(2500, resultado);
    }

    @Test
    void deveCalcularDescontoClienteNormalSubtotalMenorCinquentaMilSemCumpom() {
        long resultado = politicaDesconto.calcular(clienteNormal, 500, " ");

        assertEquals(0, resultado);
    }

    @Test
    void deveCalcularDescontoSubtotalMaiorIgualDezMilCupomBemVindo() {
        long resultado = politicaDesconto.calcular(clienteNormal, 20000, "BEMVINDO");

        assertEquals(2000, resultado);
    }

    @Test
    void naoDeveCalcularDescontoSubtotalMenorDezMilCupomBemVindo() {
        long resultado = politicaDesconto.calcular(clienteNormal, 200, "BEMVINDO");

        assertEquals(0, resultado);
    }

    @Test
    void naoDeveCalcularDescontoSubtotalMaiorIgualDezMilCupomBemVindoClienteAntigo() {
        long resultado = politicaDesconto.calcular(clienteAntigo, 20000, "BEMVINDO");

        assertEquals(0, resultado);
    }

    @Test
    void deveCalcularDescontoSubtotalMaiorIgualVinteMilCupomExtra10() {
        long resultado = politicaDesconto.calcular(clienteAntigo, 20000, "EXTRA10");

        assertEquals(2000, resultado);
    }

    @Test
    void naoDeveCalcularDescontoSubtotalMenorVinteMilCupomExtra10() {
        long resultado = politicaDesconto.calcular(clienteAntigo, 2000, "EXTRA10");

        assertEquals(0, resultado);
    }


    @Test
    void deveImpedirCupomDesconhecido() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> politicaDesconto.calcular(clienteNormal, 20000, "frete grátis")
        );

        assertEquals("Cupom desconhecido", exception.getMessage());
    }

    @Test
    void deveRetornarTetoAoInvesDesconto() {
        long resultado = politicaDesconto.calcular(clienteVIP, 10000, "BEMVINDO");

        assertEquals(2000, resultado);
    }
}
