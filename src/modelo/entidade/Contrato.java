package modelo.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numero;
	private Date data;
	private Double valorTotal;
	private List<Parcelas> list = new ArrayList<Parcelas>();
	
	public Contrato() {}

	public Contrato(Integer numero, Date data, Double valorTotal) {
		this.numero = numero;
		this.data = data;
		this.valorTotal = valorTotal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Parcelas> getList() {
		return list;
	}

	public void addParcelas(Parcelas parcelas) {
		list.add(parcelas);
	}
	
	public void removerParcelas(Parcelas parcelas) {
		list.remove(parcelas);
	}
	
	
	

}
