package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class CarrinhoTestGPT {

    private Carrinho carrinho;


    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
    }

    @Test
    @DisplayName("Carrinho novo deve iniciar vazio")
    void testCarrinhoIniciaVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Adicionar item deve aumentar quantidade e valor total")
    void testAdicionarItem() {
        Produto p1 = new Produto("Livro", 50.0);
        carrinho.addItem(p1);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(50.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Adicionar múltiplos itens deve somar corretamente o valor")
    void testAdicionarMultiplosItens() {
        carrinho.addItem(new Produto("Caneta", 5.0));
        carrinho.addItem(new Produto("Caderno", 15.0));
        carrinho.addItem(new Produto("Mochila", 120.0));

        assertEquals(3, carrinho.getQtdeItems());
        assertEquals(140.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Remover item existente deve diminuir quantidade")
    void testRemoverItemExistente() throws ProdutoNaoEncontradoException {
        Produto p1 = new Produto("Mouse", 80.0);
        carrinho.addItem(p1);

        carrinho.removeItem(p1);

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Remover item inexistente deve lançar exceção")
    void testRemoverItemInexistente() {
        Produto p1 = new Produto("Teclado", 100.0);

        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(p1);
        });
    }

    @Test
    @DisplayName("Esvaziar carrinho deve zerar quantidade e valor")
    void testEsvaziarCarrinho() {
        carrinho.addItem(new Produto("Celular", 2000.0));
        carrinho.addItem(new Produto("Fone", 300.0));

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }
}
