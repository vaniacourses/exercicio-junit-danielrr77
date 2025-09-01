package jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MainTest {

    private Main main;

    @BeforeEach
    public void setup() {
        main = new Main();
    }

    @Test
    public void testJogador1Vence() {
        assertEquals(1, main.jogar(1, 2));  // papel vence pedra
    }

    @Test
    public void testEmpate() {
        assertEquals(0, main.jogar(3, 3));  // tesoura vs tesoura
    }

    @Test
    public void testOpcaoInvalida() {
        assertEquals(-1, main.jogar(0, 2));  // opção inválida
    }
}
