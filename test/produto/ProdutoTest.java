package produto;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    Produto livro;

    @BeforeEach
    public void inicializa() {
        livro = new Produto("Introdução ao Teste de Software", 100.00);
    }

    @Test
    public void testCriaProduto() {
        assertAll("livro",
            () -> assertEquals("Introdução ao Teste de Software", livro.getNome()),
            () -> assertEquals(100.00, livro.getPreco())
        );
    }


    @Test
    public void testAtualizaNomeEPreco() {
        livro.setNome("Engenharia de Software");
        livro.setPreco(120.50);

        assertAll(
            () -> assertEquals("Engenharia de Software", livro.getNome()),
            () -> assertEquals(120.50, livro.getPreco())
        );
    }


    @Test
    public void testProdutosIguaisPorNome() {
        Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
        assertNotSame(livro, livro2);
        assertTrue(livro.equals(livro2)); // igualdade lógica pelo nome
    }

 
    @Test
    public void testProdutosDiferentesPorNome() {
        Produto outro = new Produto("Outro Livro", 100.00);
        assertFalse(livro.equals(outro));
    }


    @Test
    public void testEqualsComOutroTipoLancaExcecao() {
        assertThrows(ClassCastException.class, () -> livro.equals("nao eh produto"));
    }

    @Test
    public void assertionComHamcrestMatcher() {
        assertThat(livro.getPreco(), equalTo(100.00));
        assertThat(livro.getNome(), notNullValue());
        assertThat(livro.getNome(), containsString("Teste"));
        assertThat(livro, instanceOf(Produto.class));
    }
}
