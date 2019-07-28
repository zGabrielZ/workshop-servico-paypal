package modelo.service;

import java.util.Calendar;
import java.util.Date;

import modelo.entidade.Contrato;
import modelo.entidade.Parcelas;

public class ContratoService {

	private ServicoOnline online;
	
	public ContratoService(ServicoOnline online) {
		this.online = online;
	}
	
	public ServicoOnline getOnline() {
		return online;
	}

	public void setOnline(ServicoOnline online) {
		this.online = online;
	}
	
	public void calcularContrato(Contrato contrato,int parcelas) {
		double conta = contrato.getValorTotal()/parcelas;
		Date data = contrato.getData();
	
		for(int i=1;i<=parcelas;i++) {
			Calendar c = Calendar.getInstance();
			c.setTime(data);
			c.add(Calendar.MONTH,1);
			data = c.getTime();
		
			double juroMensal = online.juroMensal(conta,i) + conta;
			double taxaPagamento = online.taxaPagamento(juroMensal) + juroMensal;
			contrato.addParcelas(new Parcelas(data,taxaPagamento));
		
		}
	}
}
