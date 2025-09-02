package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTestGPT {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    // ----------------- Testes soma -----------------
    @Test
    @DisplayName("Deve somar dois números positivos")
    void testSomaPositivos() {
        assertEquals(7, calculadora.soma(3, 4));
    }

    @Test
    @DisplayName("Deve somar número positivo e negativo")
    void testSomaComNegativo() {
        assertEquals(1, calculadora.soma(5, -4));
    }

    @Test
    @DisplayName("Deve somar dois números negativos")
    void testSomaNegativos() {
        assertEquals(-9, calculadora.soma(-5, -4));
    }

    // ----------------- Testes subtração -----------------
    @Test
    @DisplayName("Deve subtrair dois números positivos")
    void testSubtracaoPositivos() {
        assertEquals(2, calculadora.subtracao(5, 3));
    }

    @Test
    @DisplayName("Deve subtrair resultando em negativo")
    void testSubtracaoNegativo() {
        assertEquals(-2, calculadora.subtracao(3, 5));
    }

    // ----------------- Testes multiplicação -----------------
    @Test
    @DisplayName("Deve multiplicar dois números positivos")
    void testMultiplicacaoPositivos() {
        assertEquals(20, calculadora.multiplicacao(4, 5));
    }

    @Test
    @DisplayName("Deve multiplicar número por zero")
    void testMultiplicacaoPorZero() {
        assertEquals(0, calculadora.multiplicacao(7, 0));
    }

    @Test
    @DisplayName("Deve multiplicar dois números negativos")
    void testMultiplicacaoNegativos() {
        assertEquals(15, calculadora.multiplicacao(-3, -5));
    }

    // ----------------- Testes divisão -----------------
    @Test
    @DisplayName("Deve dividir dois números positivos")
    void testDivisaoPositivos() {
        assertEquals(2, calculadora.divisao(10, 5));
    }

    @Test
    @DisplayName("Deve dividir números negativos")
    void testDivisaoNegativos() {
        assertEquals(3, calculadora.divisao(-9, -3));
    }

    @Test
    @DisplayName("Deve lançar exceção ao dividir por zero")
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.divisao(10, 0));
    }

    // ----------------- Testes somatória -----------------
    @Test
    @DisplayName("Deve calcular somatória de número positivo")
    void testSomatoriaPositivo() {
        assertEquals(15, calculadora.somatoria(5)); // 0+1+2+3+4+5 = 15
    }

    @Test
    @DisplayName("Somatória de zero deve ser zero")
    void testSomatoriaZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    @DisplayName("Somatória de número negativo deve ser zero")
    void testSomatoriaNegativo() {
        assertEquals(0, calculadora.somatoria(-3));
    }

    // ----------------- Testes ehPositivo -----------------
    @Test
    @DisplayName("Deve retornar verdadeiro para número positivo")
    void testEhPositivoPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    @DisplayName("Deve retornar verdadeiro para zero")
    void testEhPositivoZero() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    @DisplayName("Deve retornar falso para número negativo")
    void testEhPositivoNegativo() {
        assertFalse(calculadora.ehPositivo(-5));
    }

    // ----------------- Testes compara -----------------
    @Test
    @DisplayName("Deve retornar 0 quando os números forem iguais")
    void testComparaIguais() {
        assertEquals(0, calculadora.compara(5, 5));
    }

    @Test
    @DisplayName("Deve retornar 1 quando o primeiro número for maior")
    void testComparaMaior() {
        assertEquals(1, calculadora.compara(7, 3));
    }

    @Test
    @DisplayName("Deve retornar -1 quando o primeiro número for menor")
    void testComparaMenor() {
        assertEquals(-1, calculadora.compara(2, 10));
    }
}
