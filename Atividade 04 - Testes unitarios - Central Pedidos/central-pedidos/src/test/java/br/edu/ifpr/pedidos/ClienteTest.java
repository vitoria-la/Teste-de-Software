package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void deveDarErroSeComprasAnterioresForZero() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cliente(false, false, -1)
        );

        assertEquals("Histórico inválido", exception.getMessage());
    }

}
