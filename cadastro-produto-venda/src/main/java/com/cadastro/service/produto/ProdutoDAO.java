package com.cadastro.service.produto;

import java.util.ArrayList;
import java.util.List;

import com.cadastro.vo.produto.Produto;

public class ProdutoDAO {
	
	Produto produto1 = new Produto(1, "Camisa", 24, 54);
	Produto produto2 = new Produto(2, "Casaco", 100, 30);
	Produto produto3 = new Produto(3, "Sapato", 65, 10);
	Produto produto4 = new Produto(4, "Short", 43, 13);
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public ProdutoDAO() {
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
	}
	
	public boolean criar(Produto produto) {
		if (produto == null) return false;
		produtos.add(produto);
		return true;
	}
	
	public boolean editar(int id, Produto produto) {
		if (id < 0 || produto == null) return false;
		produtos.set(--id, produto);
		return true;
	}
	
	public boolean deletar(int id) {
		if (id < 0) return false;
		if (produtos.size() == 1) {
			produtos.clear();
		} else {
			produtos.remove(--id);
		}
		System.out.println("Produto deletado! ID:" + id);
		return true;
	}
	
	public List<Produto> listar(){
		return produtos;
	}
	
	public Produto pegar(int id) {
		return produtos.get(--id);
	}
}
