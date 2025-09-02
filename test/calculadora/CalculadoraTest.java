package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

	private Calculadora calc;

	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}

	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);
		Assertions.assertEquals(9, soma);
	}

	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(8, 4);
		assertTrue(subtracao == 4);
	}

	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}

	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(8, 4);
		assertTrue(multiplicacao == 32);
	}

	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(5);
		assertEquals(15, somatoria);
	}

	@Test
	public void testEhPositivo() {
		assertTrue(calc.ehPositivo(5));
	}

	@Test
	public void testEhNegativo() {
		assertFalse(calc.ehPositivo(-5));
	}

	@Test
	public void testComparaMaior() {
		assertTrue(calc.compara(2, 1) == 1);
	}

	@Test
	public void testComparaMenor() {
		assertTrue(calc.compara(-2, 1) == -1);
	}

	@Test
	public void testComparaIgual() {
		assertTrue(calc.compara(0, 0) == 0);
	}

	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}
	}

	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
public void testSomaComZero() {
    assertEquals(5, calc.soma(5, 0));
}

@Test
public void testSubtracaoComNumeroNegativo() {
    assertEquals(10, calc.subtracao(5, -5));
}

@Test
public void testMultiplicacaoComZero() {
    assertEquals(0, calc.multiplicacao(7, 0));
}

@Test
public void testDivisaoNumeroNegativo() {
    assertEquals(-2, calc.divisao(-8, 4));
}

@Test
public void testSomatoriaZero() {
    assertEquals(0, calc.somatoria(0));
}

@Test
public void testSomatoriaGrande() {
    assertEquals(55, calc.somatoria(10));
}

@Test
public void testEhPositivoComZero() {
    assertTrue(calc.ehPositivo(0));
}

@Test
public void testSomaComOverflow() {
    int resultado = calc.soma(Integer.MAX_VALUE, 1);
    assertEquals(Integer.MIN_VALUE, resultado); // overflow esperado
}

}
