package modelo.entidade;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcelas implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date data;
	private Double parcelasQuantidade;
	
	public Parcelas() {}

	public Parcelas(Date data, Double parcelasQuantidade) {
		super();
		this.data = data;
		this.parcelasQuantidade = parcelasQuantidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getParcelasQuantidade() {
		return parcelasQuantidade;
	}

	public void setParcelasQuantidade(Double parcelasQuantidade) {
		this.parcelasQuantidade = parcelasQuantidade;
	}

	@Override
	public String toString() {
		return sdf.format(data) + " - " + String.format("%.2f",parcelasQuantidade);
	}
	
	

}
