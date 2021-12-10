package com.cadastro.teste.vo.produto;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.cadastro.vo.produto.Produto;

class TesteProduto {

	@Test
	void test() {
		Produto produto = new Produto();
		produto.setId(1);
		produto.setNome("Notebook");
		produto.setPreco(2500.00D);
		produto.setEstoque(10D);
		
		assertTrue(produto != null);
		assertTrue(produto.getId() > 0);
		assertTrue(produto.getNome() != null 
				&& produto.getNome().length() > 0);
		assertTrue(produto.getPreco() > 0);
		assertTrue(produto.getEstoque() > 0);
	}

}
