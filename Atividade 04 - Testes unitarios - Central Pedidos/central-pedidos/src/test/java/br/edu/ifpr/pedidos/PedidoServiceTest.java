package br.edu.ifpr.pedidos;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {
    Pedido pedido = new Pedido(criarListaItens(), "UF", false, null);


    public List<ItemPedido> criarListaItens() {
        ItemPedido itemPedido1 = new ItemPedido("abc", 20, 2, 7, 200, false);
        ItemPedido itemPedido2 = new ItemPedido("abc123", 20, 2, 7, 200, false);
        List<ItemPedido> lista = new ArrayList<>();
        lista.add(itemPedido1);
        lista.add(itemPedido2);
        return lista;
    }

    @Test
    void deveImpedirClienteBloqueado() {
        List<Long> cobrancas = new ArrayList<>();
        PedidoService service = new PedidoService(total -> {
            cobrancas.add(total);
            return true;
        });
        Cliente clienteNormal = new Cliente(false, true, 0);

        ResultadoPedido resultado = service.fechar(pedido, clienteNormal);

        assertEquals("BLOQUEADO", resultado.status());
    }

//    @Test
//    void deveImpedirSubtotalZero() {
//        ItemPedido itemPedido2 = new ItemPedido("abc123", 0, 2, 7, 200, false);
//        List<ItemPedido> lista = new ArrayList<>();
//        lista.add(itemPedido2);
//        Pedido pedido = new Pedido(lista, "UF", false, null);
//
//        List<Long> cobrancas = new ArrayList<>();
//        PedidoService service = new PedidoService(total -> {
//            cobrancas.add(total);
//            return true;
//        });
//
//        Cliente clienteNormal = new Cliente(false, false, 0);
//
//        IllegalArgumentException exception = assertThrows(
//                IllegalArgumentException.class,
//                () -> service.fechar(pedido, clienteNormal)
//        );
//
//        assertEquals("Pedido sem itens ativos", exception.getMessage());
//    }

    @Test
    void deveImpedirPedidoItemSemEstoqueSuficiente() {
        ItemPedido itemPedido2 = new ItemPedido("abc123", 10, 2, 1, 200, false);
        List<ItemPedido> lista = new ArrayList<>();
        lista.add(itemPedido2);
        Pedido pedido = new Pedido(lista, "UF", false, null);

        List<Long> cobrancas = new ArrayList<>();
        PedidoService service = new PedidoService(total -> {
            cobrancas.add(total);
            return true;
        });

        Cliente clienteNormal = new Cliente(false, false, 0);

        ResultadoPedido resultado = service.fechar(pedido, clienteNormal);

        assertEquals("SEM_ESTOQUE", resultado.status());
    }

    @Test
    void deveImpedirAnaliseNaoAprovada() {
        ItemPedido itemPedido2 = new ItemPedido("abc123", 10, 2, 10, 200, false);
        List<ItemPedido> lista = new ArrayList<>();
        lista.add(itemPedido2);
        Pedido pedido = new Pedido(lista, "UF", true, null);

        List<Long> cobrancas = new ArrayList<>();
        PedidoService service = new PedidoService(total -> {
            cobrancas.add(total);
            return true;
        });

        Cliente clienteNormal = new Cliente(false, false, 0);

        ResultadoPedido resultado = service.fechar(pedido, clienteNormal);
        ResultadoPedido resultadoEsperado = new ResultadoPedido("REVISAO", 20, 0, 4500, 4520);

        assertEquals(resultadoEsperado, resultado);
    }

    /*

        long subtotal = pedido.subtotalCentavos();
        if (subtotal == 0) throw new IllegalArgumentException("Pedido sem itens ativos");

        if (!pedido.estoqueSuficiente()) return semCobranca("SEM_ESTOQUE");

        long desconto = descontos.calcular(cliente, subtotal, pedido.cupom()); 0
        long liquido = subtotal - desconto; 10
        long frete = fretes.calcular(pedido, cliente, liquido);
        long total = liquido + frete;
        String analise = risco.avaliar(cliente, total, pedido.expresso());

        if (!analise.equals("APROVADO")) { REVISAO, 10, 0, 3000, 3010
            return new ResultadoPedido(analise, subtotal, desconto, frete, total);
        }

     */



    @Test
    void deveFecharPedidoDeClienteComumComFreteDoParanaEPagamentoAprovado() {
        // 1. Preparar: cliente comum, uma compra anterior e item disponível de R$ 100,00.
        Cliente clienteTeste = new Cliente(false, false, 1);
        ItemPedido itemTeste = new ItemPedido("LIVRO-JAVA", 10_000, 1, 5, 1_000, false);
        Pedido pedidoTeste = new Pedido(List.of(itemTeste), "PR", false, null);

        // Simula o pagamento e registra as cobranças, sem banco ou serviço externo.
        List<Long> cobrancas = new ArrayList<>();
        PedidoService service = new PedidoService(total -> {
            cobrancas.add(total);
            return true;
        });

        // 2. Executar: percorrer um caminho completo do fechamento.
        ResultadoPedido resultado = service.fechar(pedidoTeste, clienteTeste);

        // 3. Verificar: sem desconto; frete de R$ 12,00; total de R$ 112,00.
        assertAll(
            () -> assertEquals("PAGO", resultado.status()),
            () -> assertEquals(10_000L, resultado.subtotalCentavos()),
            () -> assertEquals(0L, resultado.descontoCentavos()),
            () -> assertEquals(1_200L, resultado.freteCentavos()),
            () -> assertEquals(11_200L, resultado.totalCentavos()),
            // A lista comprova uma única cobrança, com o valor correto.
            () -> assertEquals(List.of(11_200L), cobrancas)
        );
    }

    // TODO: acrescente testes para outros caminhos e resultados do fechamento.
}
