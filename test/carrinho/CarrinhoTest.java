package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;


@DisplayName("Classe para teste do Carrinho")
public class CarrinhoTest {

	private Carrinho carrinho;

	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}

	@DisplayName("Carrinho inicia vazio e com total 0.0")
	@Test
	public void testCarrinhoInicial() {
		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
	}

	@DisplayName("Adicionar item aumenta quantidade e valor total")
	@Test
	public void testAddItem() {
		Produto p1 = new Produto("Mouse", 50.0);
		Produto p2 = new Produto("Teclado", 150.0);

		carrinho.addItem(p1);
		carrinho.addItem(p2);

		assertEquals(2, carrinho.getQtdeItems());
		assertEquals(200.0, carrinho.getValorTotal(), 0.0001);
	}
	
}
