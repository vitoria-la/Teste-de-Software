package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    public List<ItemPedido> criarListaItens() {
        ItemPedido itemPedido1 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido2 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        List<ItemPedido> lista = new ArrayList<>();
        lista.add(itemPedido1);
        lista.add(itemPedido2);
        return lista;
    }

    @Test
    void deveImpedirPedidoItemsNull() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Pedido(null, "UF", false, "frete grátis")
        );

        assertEquals("Lista inválida", exception.getMessage());
    }

    @Test
    void deveImpedirPedidoMaisCemItens() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Pedido(criarListaCemItens(), "UF", false, "frete grátis")
        );

        assertEquals("Lista inválida", exception.getMessage());
    }

    @Test
    void deveImpedirUFNull() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Pedido(criarListaItens(), null, false, "frete grátis")
        );

        assertEquals("UF inválida", exception.getMessage());
    }

    @Test
    void deveImpedirUFErrada() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Pedido(criarListaItens(), "123", false, "frete grátis")
        );

        assertEquals("UF inválida", exception.getMessage());
    }


    @Test
    void deveCalcularSubtotalCentavos() {
        Pedido pedido = new Pedido(criarListaItens(), "UF", false, "frete grátis");

        long resultado = pedido.subtotalCentavos();

        assertEquals(80, resultado);
    }

    @Test
    void deveCalcularPesoPedido() {
        Pedido pedido = new Pedido(criarListaItens(), "UF", false, "frete grátis");

        int resultado = pedido.pesoGramas();

        assertEquals(320, resultado);
    }

    @Test
    void deveVerificarItemFragil() {
        ItemPedido itemPedido3 = new ItemPedido("abc123", 20, 2, 7, 80, true);
        List<ItemPedido> lista = criarListaItens();
        lista.add(itemPedido3);
        Pedido pedido = new Pedido(lista, "UF", false, "frete grátis");

        boolean resultado = pedido.temFragil();

        assertEquals(true, resultado);
    }

    @Test
    void deveVerificarNaoTemItemFragil() {
        Pedido pedido = new Pedido(criarListaItens(), "UF", false, "frete grátis");

        boolean resultado = pedido.temFragil();

        assertEquals(false, resultado);
    }

    @Test
    void deveVerificarItensTemEstoque() {
        Pedido pedido = new Pedido(criarListaItens(), "UF", false, "frete grátis");

        boolean resultado = pedido.estoqueSuficiente();

        assertEquals(true, resultado);
    }

    @Test
    void deveVerificarItensNaoTemEstoqueSuficiente() {
        ItemPedido itemPedido3 = new ItemPedido("abc123", 20, 2, 1, 80, true);
        List<ItemPedido> lista = criarListaItens();
        lista.add(itemPedido3);
        Pedido pedido = new Pedido(lista, "UF", false, "frete grátis");

        boolean resultado = pedido.estoqueSuficiente();

        assertEquals(false, resultado);
    }

    public List<ItemPedido> criarListaCemItens() {
        ItemPedido itemPedido1 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido2 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido3 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido4 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido5 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido6 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido7 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido8 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido9 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido10 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido11 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido12 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido13 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido14 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido15 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido16 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido17 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido18 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido19 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido20 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido21 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido22 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido23 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido24 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido25 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido26 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido27 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido28 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido29 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido30 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido31 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido32 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido33 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido34 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido35 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido36 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido37 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido38 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido39 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido40 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido41 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido42 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido43 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido44 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido45 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido46 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido47 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido48 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido49 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido50 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido51 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido52 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido53 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido54 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido55 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido56 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido57 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido58 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido59 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido60 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido61 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido62 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido63 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido64 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido65 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido66 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido67 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido68 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido69 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido70 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido71 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido72 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido73 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido74 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido75 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido76 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido77 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido78 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido79 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido80 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido81 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido82 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido83 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido84 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido85 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido86 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido87 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido88 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido89 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido90 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido91 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido92 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido93 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido94 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido95 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido96 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido97 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido98 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido99 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido100 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido101 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido102 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido103 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido104 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido105 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido106 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido107 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido108 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido109 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido110 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido111 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido112 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido113 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido114 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido115 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido116 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido117 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido118 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido119 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido120 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido121 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido122 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido123 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido124 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido125 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido126 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido127 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido128 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido129 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido130 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido131 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido132 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido133 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido134 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido135 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido136 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido137 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido138 = new ItemPedido("abc123", 20, 2, 7, 80, false);
        ItemPedido itemPedido139 = new ItemPedido("abc", 20, 2, 7, 80, false);
        ItemPedido itemPedido140 = new ItemPedido("abc123", 20, 2, 7, 80, false);

        List<ItemPedido> lista = new ArrayList<>();
        lista.add(itemPedido1);
        lista.add(itemPedido2);
        lista.add(itemPedido3);
        lista.add(itemPedido4);
        lista.add(itemPedido5);
        lista.add(itemPedido6);
        lista.add(itemPedido7);
        lista.add(itemPedido8);
        lista.add(itemPedido9);
        lista.add(itemPedido10);
        lista.add(itemPedido11);
        lista.add(itemPedido12);
        lista.add(itemPedido13);
        lista.add(itemPedido14);
        lista.add(itemPedido15);
        lista.add(itemPedido16);
        lista.add(itemPedido17);
        lista.add(itemPedido18);
        lista.add(itemPedido19);
        lista.add(itemPedido20);
        lista.add(itemPedido21);
        lista.add(itemPedido22);
        lista.add(itemPedido23);
        lista.add(itemPedido24);
        lista.add(itemPedido25);
        lista.add(itemPedido26);
        lista.add(itemPedido27);
        lista.add(itemPedido28);
        lista.add(itemPedido29);
        lista.add(itemPedido30);
        lista.add(itemPedido31);
        lista.add(itemPedido32);
        lista.add(itemPedido33);
        lista.add(itemPedido34);
        lista.add(itemPedido35);
        lista.add(itemPedido36);
        lista.add(itemPedido37);
        lista.add(itemPedido38);
        lista.add(itemPedido39);
        lista.add(itemPedido40);
        lista.add(itemPedido41);
        lista.add(itemPedido42);
        lista.add(itemPedido43);
        lista.add(itemPedido44);
        lista.add(itemPedido45);
        lista.add(itemPedido46);
        lista.add(itemPedido47);
        lista.add(itemPedido48);
        lista.add(itemPedido49);
        lista.add(itemPedido50);
        lista.add(itemPedido51);
        lista.add(itemPedido52);
        lista.add(itemPedido53);
        lista.add(itemPedido54);
        lista.add(itemPedido55);
        lista.add(itemPedido56);
        lista.add(itemPedido57);
        lista.add(itemPedido58);
        lista.add(itemPedido59);
        lista.add(itemPedido60);
        lista.add(itemPedido61);
        lista.add(itemPedido62);
        lista.add(itemPedido63);
        lista.add(itemPedido64);
        lista.add(itemPedido65);
        lista.add(itemPedido66);
        lista.add(itemPedido67);
        lista.add(itemPedido68);
        lista.add(itemPedido69);
        lista.add(itemPedido70);
        lista.add(itemPedido71);
        lista.add(itemPedido72);
        lista.add(itemPedido73);
        lista.add(itemPedido74);
        lista.add(itemPedido75);
        lista.add(itemPedido76);
        lista.add(itemPedido77);
        lista.add(itemPedido78);
        lista.add(itemPedido79);
        lista.add(itemPedido80);
        lista.add(itemPedido81);
        lista.add(itemPedido82);
        lista.add(itemPedido83);
        lista.add(itemPedido84);
        lista.add(itemPedido85);
        lista.add(itemPedido86);
        lista.add(itemPedido87);
        lista.add(itemPedido88);
        lista.add(itemPedido89);
        lista.add(itemPedido90);
        lista.add(itemPedido91);
        lista.add(itemPedido92);
        lista.add(itemPedido93);
        lista.add(itemPedido94);
        lista.add(itemPedido95);
        lista.add(itemPedido96);
        lista.add(itemPedido97);
        lista.add(itemPedido98);
        lista.add(itemPedido99);
        lista.add(itemPedido100);
        lista.add(itemPedido101);
        lista.add(itemPedido102);
        lista.add(itemPedido103);
        lista.add(itemPedido104);
        lista.add(itemPedido105);
        lista.add(itemPedido106);
        lista.add(itemPedido107);
        lista.add(itemPedido108);
        lista.add(itemPedido109);
        lista.add(itemPedido110);
        lista.add(itemPedido111);
        lista.add(itemPedido112);
        lista.add(itemPedido113);
        lista.add(itemPedido114);
        lista.add(itemPedido115);
        lista.add(itemPedido116);
        lista.add(itemPedido117);
        lista.add(itemPedido118);
        lista.add(itemPedido119);
        lista.add(itemPedido120);
        lista.add(itemPedido121);
        lista.add(itemPedido122);
        lista.add(itemPedido123);
        lista.add(itemPedido124);
        lista.add(itemPedido125);
        lista.add(itemPedido126);
        lista.add(itemPedido127);
        lista.add(itemPedido128);
        lista.add(itemPedido129);
        lista.add(itemPedido130);
        lista.add(itemPedido131);
        lista.add(itemPedido132);
        lista.add(itemPedido133);
        lista.add(itemPedido134);
        lista.add(itemPedido135);
        lista.add(itemPedido136);
        lista.add(itemPedido137);
        lista.add(itemPedido138);
        lista.add(itemPedido139);
        lista.add(itemPedido140);
        return lista;
    }

}
