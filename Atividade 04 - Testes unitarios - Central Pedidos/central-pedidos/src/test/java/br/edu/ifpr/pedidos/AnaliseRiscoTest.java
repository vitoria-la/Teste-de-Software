package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnaliseRiscoTest {

    private AnaliseRisco analiseRisco = new AnaliseRisco();

    @Test
    void deveAnalisarRiscos() {
        Cliente cliente = new Cliente(false, false, 2);

        String resultado = analiseRisco.avaliar(cliente, 10, false);

        assertEquals("APROVADO", resultado);
    }

    @Test
    void deveImpedirTotalNegativo() {
        Cliente cliente = new Cliente(false, false, 2);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> analiseRisco.avaliar(cliente, -10, false)
        );

        assertEquals("Total negativo", exception.getMessage());
    }

    @Test
    void deveRecusarSeClienteBloqueado() {
        Cliente cliente = new Cliente(false, true, 2);
        String resultado = analiseRisco.avaliar(cliente, 10, false);

        assertEquals("RECUSADO", resultado);
    }

    @Test
    void deveRetornarRevisarSePrimeiraCompraEExpresso() {
        Cliente cliente = new Cliente(false, false, 0);
        String resultado = analiseRisco.avaliar(cliente, 10, true);

        assertEquals("REVISAO", resultado);
    }

    @Test
    void deveRetornarRevisarSePrimeiraCompraETotalMaiorCemMil() {
        Cliente cliente = new Cliente(false, false, 0);
        String resultado = analiseRisco.avaliar(cliente, 200000, false);

        assertEquals("REVISAO", resultado);
    }

    // O código não permite testar essa condição, já que esse caso fica parado no if anterior
    @Test
    void deveRetornarRevisarSePrimeiraCompraETotalMaiorQuinhentosMilENaoVip() {
        Cliente cliente = new Cliente(false, false, 0);
        String resultado = analiseRisco.avaliar(cliente, 700000, false);

        assertEquals("REVISAO", resultado);
    }
}
