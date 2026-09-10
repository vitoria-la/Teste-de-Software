package br.edu.ifpr.boletim;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipacaoTest {
    Participacao participacao = new Participacao();

    public int calcularPontos(boolean entregouAtividade, boolean participouDaAula) {
        int pontos = 0;
        if (entregouAtividade) {
            pontos = pontos + 2;
        }
        if (participouDaAula) {
            pontos = pontos + 1;
        }
        return pontos;
    }

    @Test
    void deveCalcularPontosComAtividadeComParticipacao() {

        // Executar: chamar um único método com uma entrada conhecida.
        int resultado = participacao.calcularPontos(true, true);

        // Verificar: comparar o resultado esperado com o resultado obtido.
        assertEquals(3, resultado);
    }

    @Test
    void deveCalcularPontosSemAtividadeSemParticipacao() {

        // Executar: chamar um único método com uma entrada conhecida.
        int resultado = participacao.calcularPontos(false, false);

        // Verificar: comparar o resultado esperado com o resultado obtido.
        assertEquals(0, resultado);
    }
}
