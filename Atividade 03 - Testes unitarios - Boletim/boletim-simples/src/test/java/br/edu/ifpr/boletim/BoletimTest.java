package br.edu.ifpr.boletim;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoletimTest {
    Boletim boletim = new Boletim();

    @Test
    void deveAprovarAlunoComMediaOito() {
        // Preparar: criar o objeto que será testado.

        // Executar: chamar um único método com uma entrada conhecida.
        String resultado = boletim.verificarSituacao(8);

        // Verificar: comparar o resultado esperado com o resultado obtido.
        assertEquals("APROVADO", resultado);
    }

    @Test
    void deveIrRecuperacaoAlunoComMediaMaiorIgualQuatro() {
        String resultado = boletim.verificarSituacao(5);

        assertEquals("RECUPERACAO", resultado);
    }

    @Test
    void deveReprovarAlunoComMediaMenorQuatro() {
        String resultado = boletim.verificarSituacao(1);

        assertEquals("REPROVADO", resultado);
    }

    @Test
    void deveCalcularMedia() {
        double resultado = boletim.calcularMedia(4, 6);

        assertEquals(5, resultado);
    }

    @Test
    void deveContarAlunosAprovados() {
        double[] lista = new double[5];
        lista[0] = 8.0;
        lista[1] = 9.0;
        lista[2] = 7.0;
        lista[3] = 3.0;
        lista[4] = 1.0;
        int resultado = boletim.contarAprovados(lista);

        assertEquals(3, resultado);
    }


}
