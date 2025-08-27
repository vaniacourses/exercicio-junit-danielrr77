package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

	Carrinho carrinho;

	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}

	@Test
	public void testAdicionaProduto() {
		Produto livro = new Produto("Introdu��o ao Teste de Software", 100.00);
		carrinho.addItem(livro);
		assertEquals(1, carrinho.getQtdeItems());
	}

    @Test
    public void testValorTotal() {
        Produto livro1 = new Produto("Livro A", 50.00);
        Produto livro2 = new Produto("Livro B", 75.00);
        carrinho.addItem(livro1);
        carrinho.addItem(livro2);
        assertTrue(carrinho.getValorTotal() == 125.00);
    }

    @Test
    public void testRemoveProdutoNaoEncontrado() {
        Produto livro = new Produto("Introdu��o ao Teste de Software", 100.00);
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(livro);
        });
    }

    @Test
    public void testEsvaziaCarrinho() {
        Produto livro1 = new Produto("Livro A", 50.00);
        Produto livro2 = new Produto("Livro B", 75.00);
        carrinho.addItem(livro1);
        carrinho.addItem(livro2);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
    }

}
