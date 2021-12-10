package com.cadastro.service.venda;

import java.util.ArrayList;
import java.util.List;

import com.cadastro.vo.venda.Venda;

public class VendaDAO {
	
	private List<Venda> vendas = new ArrayList<Venda>();
	
	public boolean criar(Venda venda) {
		if (venda == null) return false;
		vendas.add(venda);
		return true;
	}
	
	public boolean editar(int id, Venda venda) {
		if (id < 0 || venda == null) return false;
		vendas.set(--id, venda);
		return true;
	}
	
	public boolean deletar(int id) {
		if (id < 0) return false;
		vendas.remove(--id);
		return true;
	}
	
	public List<Venda> listar(){
		return vendas;
	}
	
	public Venda pegar(int id) {
		return vendas.get(--id);
	}
}
