package modelo.service;

public class PayPal implements ServicoOnline {

	private static double juroSimples = 0.01;
	private static double taxaPagamento = 0.02;
	
	@Override
	public double juroMensal(double quantidade, Integer mes) {
		return quantidade * mes * juroSimples;
	}
	@Override
	public double taxaPagamento(double quantidade) {
		return quantidade * taxaPagamento;
	}
	
	
}
