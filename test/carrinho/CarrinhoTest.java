package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

	@Test
	public void testCarrinhoInicial() {
		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
	}

	@Test
	public void testAddItem() {
		Produto p1 = new Produto("Mouse", 50.0);
		Produto p2 = new Produto("Teclado", 150.0);

		carrinho.addItem(p1);
		carrinho.addItem(p2);

		assertEquals(2, carrinho.getQtdeItems());
		assertEquals(200.0, carrinho.getValorTotal(), 0.0001);
	}
	
	@Test
	public void testRemoveItem() throws Exception {
		Produto p = new Produto("Headset", 300.0);
		carrinho.addItem(p);

		assertEquals(1, carrinho.getQtdeItems());
		assertEquals(300.0, carrinho.getValorTotal(), 0.0001);

		carrinho.removeItem(p);

		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
	}

	@Test
	public void testEsvaziaCarrinho() {
		Produto p1 = new Produto("SSD", 400.0);
		Produto p2 = new Produto("HD", 250.0);

		carrinho.addItem(p1);
		carrinho.addItem(p2);
		assertTrue(carrinho.getQtdeItems() == 2);

		carrinho.esvazia();

		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
	}
	
}
