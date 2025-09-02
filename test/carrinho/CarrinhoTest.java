package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
    }

    @Test
    @DisplayName("Carrinho inicia vazio")
    public void testCarrinhoIniciaVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Adicionar produto incrementa quantidade")
    public void testAdicionaProduto() {
        Produto livro = new Produto("Introdução ao Teste de Software", 100.00);
        carrinho.addItem(livro);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Calcular valor total corretamente")
    public void testValorTotal() {
        Produto livro1 = new Produto("Livro A", 50.00);
        Produto livro2 = new Produto("Livro B", 75.00);
        carrinho.addItem(livro1);
        carrinho.addItem(livro2);
        assertEquals(125.00, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Remover produto existente com sucesso")
    public void testRemoveProdutoExistente() throws ProdutoNaoEncontradoException {
        Produto livro = new Produto("Livro X", 60.00);
        carrinho.addItem(livro);
        carrinho.removeItem(livro);
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Lançar exceção ao remover produto inexistente")
    public void testRemoveProdutoNaoEncontrado() {
        Produto livro = new Produto("Livro Y", 100.00);
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(livro);
        });
    }

    @Test
    @DisplayName("Esvaziar carrinho remove todos os itens")
    public void testEsvaziaCarrinho() {
        Produto livro1 = new Produto("Livro A", 50.00);
        Produto livro2 = new Produto("Livro B", 75.00);
        carrinho.addItem(livro1);
        carrinho.addItem(livro2);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Permitir itens duplicados no carrinho")
    public void testAdicionaItensDuplicados() {
        Produto livro = new Produto("Livro Duplicado", 40.00);
        carrinho.addItem(livro);
        carrinho.addItem(livro);
        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(80.00, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Valor total ajustado após remover um item entre vários")
    public void testValorTotalAposRemocao() throws ProdutoNaoEncontradoException {
        Produto livro1 = new Produto("Livro A", 50.00);
        Produto livro2 = new Produto("Livro B", 75.00);
        Produto livro3 = new Produto("Livro C", 30.00);
        carrinho.addItem(livro1);
        carrinho.addItem(livro2);
        carrinho.addItem(livro3);

        carrinho.removeItem(livro2); // remove o livro de 75.00

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(80.00, carrinho.getValorTotal(), 0.001);
    }
}
