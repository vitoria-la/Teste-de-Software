package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProcessadorPagamentoFake implements ProcessadorPagamento {

    @Override
    public boolean autorizar(long total) {

        return true;
    }
}


class PagamentoServiceTest {
    private ProcessadorPagamentoFake processador = new ProcessadorPagamentoFake();
    private PagamentoService pagamentoService = new PagamentoService(processador);

    @Test
    void deveImpedirTotalMenorIgualZero() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> pagamentoService.pagar(-1, 0)
        );

        assertEquals("Total deve ser positivo", exception.getMessage());
    }

    @Test
    void deveImpedirTentativasMenorUm() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> pagamentoService.pagar(10, 0)
        );

        assertEquals("Use 1 a 3 tentativas", exception.getMessage());
    }

    @Test
    void deveImpedirTentativasMaiorTres() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> pagamentoService.pagar(10, 5)
        );

        assertEquals("Use 1 a 3 tentativas", exception.getMessage());
    }


}
