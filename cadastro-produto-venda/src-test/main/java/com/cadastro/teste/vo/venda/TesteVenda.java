package com.cadastro.teste.vo.venda;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cadastro.vo.produto.Produto;
import com.cadastro.vo.venda.Venda;

class TesteVenda {

	@Test
	void test() {
		
		Produto sapato = new Produto(1, "Sapato", 25, 30);
		Produto camisa = new Produto(2, "Camisa", 30, 2);
		Produto casaco = new Produto(3, "Casaco", 60, 4);
		
		List<Produto> itens = new ArrayList<Produto>();
		itens.add(sapato);
		itens.add(camisa);
		itens.add(casaco);
		itens.add(casaco);
		
		double totalPagar = 0;
		
		for (Produto produto : itens) {
			totalPagar += produto.getPreco();
		}
		
		Venda venda = new Venda();
		venda.setId(1);
		venda.setDataVenda(new Date());
		venda.setTotal(totalPagar);
		venda.setItens(itens);
		
		assertTrue(venda != null);
		assertTrue(venda.getId() > 0);
		assertTrue(venda.getDataVenda() != null);
		assertTrue(venda.getTotal() > 0);
		assertTrue(venda.getItens() != null
				&& venda.getItens().size() > 0);
	}

}
