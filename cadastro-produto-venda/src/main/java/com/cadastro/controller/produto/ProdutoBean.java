package com.cadastro.controller.produto;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.cadastro.service.produto.ProdutoDAO;
import com.cadastro.vo.produto.Produto;

@Named("produtoBean")
@ApplicationScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 5984188652117443204L;
	
	private int id;
	private Produto produto;
	private ProdutoDAO produtoDAO;
	
	private List<Produto> produtos;
	
	public ProdutoBean() {
		this.produto = new Produto();
		this.produtoDAO = new ProdutoDAO();
		this.produtos = produtoDAO.listar();
		this.id = produtos.size() + 1;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void criar() {
		this.produto.setId(id);
		boolean flag = this.produtoDAO.criar(this.produto);
		if(flag == false) {
			System.out.println("Não foi possível criar!");
		} else {
			System.out.println("Produto cadastrado!");
		}
	}
	
	public void editar(int id, Produto produto) {
		this.produto = new Produto();
		this.produtoDAO.editar(id, produto);
	}
	
	public void novoProduto() {
		this.id++;
		this.produto = new Produto();
	}
	
	public void deletar(int id) {
		this.produtoDAO.deletar(id);
		this.id = this.produtoDAO.listar().size() + 1;
		this.produtos = this.produtoDAO.listar();
	}
}
