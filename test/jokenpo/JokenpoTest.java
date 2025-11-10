package jokenpo;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JokenpoTest {

    jokenpo jogo;

    @BeforeEach
    public void inicializa() {
        jogo = new jokenpo();
    }

    @Test
    public void testEmpate() {
        assertAll("empate",
                () -> assertEquals(0, jogo.jogar(1, 1), "Papel vs Papel deve empatar"),
                () -> assertEquals(0, jogo.jogar(2, 2), "Pedra vs Pedra deve empatar"),
                () -> assertEquals(0, jogo.jogar(3, 3), "Tesoura vs Tesoura deve empatar")
        );
    }

    @Test
    public void testJogador1Vence() {
        assertAll("vitórias jogador 1",
                () -> assertEquals(1, jogo.jogar(1, 2), "Papel vence Pedra"),
                () -> assertEquals(1, jogo.jogar(2, 3), "Pedra vence Tesoura"),
                () -> assertEquals(1, jogo.jogar(3, 1), "Tesoura vence Papel")
        );
    }

    @Test
    public void testJogador2Vence() {
        assertAll("vitórias jogador 2",
                () -> assertEquals(2, jogo.jogar(2, 1), "Papel vence Pedra (jogador 2)"),
                () -> assertEquals(2, jogo.jogar(3, 2), "Tesoura vence Pedra (jogador 2)"),
                () -> assertEquals(2, jogo.jogar(1, 3), "Papel vence Tesoura (jogador 2)")
        );
    }

    @Test
    public void testEntradaInvalida() {
        assertAll("entradas inválidas",
                () -> assertEquals(-1, jogo.jogar(0, 1), "Jogador 1 inválido"),
                () -> assertEquals(-1, jogo.jogar(1, 4), "Jogador 2 inválido"),
                () -> assertEquals(-1, jogo.jogar(7, 7), "Ambos inválidos")
        );
    }

    @Test
    public void testComHamcrest() {
        int resultado = jogo.jogar(1, 2); // Papel vs Pedra → Jogador 1 vence
        assertThat(resultado, equalTo(1));
        assertThat(resultado, not(equalTo(0)));
        assertThat(jogo, instanceOf(jokenpo.class));
        assertThat(jogo.jogar(2, 2), is(0));
    }
}
