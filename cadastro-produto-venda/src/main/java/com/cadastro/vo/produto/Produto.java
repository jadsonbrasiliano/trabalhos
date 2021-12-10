package com.cadastro.vo.produto;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {

	private static final long serialVersionUID = 973474545059111145L;
	
	private int id;
	private String nome;
	private double preco;
	private double estoque;
	
	public Produto() {
		
	}
	
	public Produto(int id, String nome, double preco, double estoque) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getEstoque() {
		return estoque;
	}
	
	public void setEstoque(double estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", estoque=" + estoque + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(estoque, id, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) obj;
		return Double.doubleToLongBits(estoque) == Double.doubleToLongBits(other.estoque) && id == other.id
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}
}
