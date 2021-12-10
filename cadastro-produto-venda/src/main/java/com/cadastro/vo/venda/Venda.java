package com.cadastro.vo.venda;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.cadastro.vo.produto.Produto;

public class Venda implements Serializable {

	private static final long serialVersionUID = -6861189507597302275L;
	
	private int id;
	private Date dataVenda;
	private double total;
	private List<Produto> itens;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public List<Produto> getItens() {
		return itens;
	}
	
	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", dataVenda=" + dataVenda + ", total=" + total + ", itens=" + itens + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataVenda, id, itens, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Venda)) {
			return false;
		}
		Venda other = (Venda) obj;
		return Objects.equals(dataVenda, other.dataVenda) && id == other.id && Objects.equals(itens, other.itens)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}
}
