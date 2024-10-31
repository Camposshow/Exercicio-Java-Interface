package model.services;

public class PaypalService implements OnlinePaymentService {
	//Classe responsavel por conter as regras de negocios da platarforma ficticia "Paypal" que tem um contrato com a Interface OnlinePaymentService
	
	@Override
	public Double paymentFee(Double amount) {
		return amount + amount * 0.02; // Logica para calcular a taxa Ex: 202 + 2% = 206.04

	}

	@Override
	public Double interest(Double amount, Integer months) {
		return amount * 0.01 * months; // Logica para calcular o juros Ex: 200 + 1% * 1 = 202 

		
		
	}

}
