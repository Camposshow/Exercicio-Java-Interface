package model.services;

public interface OnlinePaymentService {
	//Interface usada para "fechar" contratos com plataformas de pagamento online
	
	//Metodos que precisam ser criados na classe que tiver o contrato com a interface
	public Double paymentFee(Double amount);
	
	public Double interest(Double amount, Integer months);
}
