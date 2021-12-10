package com.cadastro.controller.venda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.cadastro.service.produto.ProdutoDAO;
import com.cadastro.service.venda.VendaDAO;
import com.cadastro.vo.produto.Produto;
import com.cadastro.vo.venda.Venda;

@Named("vendaBean")
@ApplicationScoped
public class VendaBean implements Serializable {

	private static final long serialVersionUID = -9159534948609846358L;
	
	private int id;
	private Venda venda;
	private int id_item;
	private VendaDAO vendaDAO;
	private ProdutoDAO produtoDAO;
	
	private List<Venda> vendas;
	private List<Produto> produtos;
	private List<Produto> itens;
	
	public VendaBean() {
		this.id = 1;
		this.venda = new Venda();
		this.vendaDAO = new VendaDAO();
		this.produtoDAO = new ProdutoDAO();
		this.produtos = produtoDAO.listar();
		this.vendas = vendaDAO.listar();
		this.itens = new ArrayList<Produto>();
	}
	
	public int getId_item() {
		return id_item;
	}
	
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}

	public int getId() {
		return id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public List<Venda> getVendas() {
		return vendas;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void adicionarItem(int id) {
		this.itens.add(produtos.get(++id));
		this.venda.setItens(itens);
	}
	
	public void criar() {
		this.venda.setId(id);
		this.vendaDAO.criar(this.venda);
		this.venda = new Venda();
		this.id++;
	}
	
	public void novaVenda() {
		this.id++;
		this.venda = new Venda();
	}
}
