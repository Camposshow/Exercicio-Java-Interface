package model.services;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService { // Classe responsavel por criar os installments
	
	private OnlinePaymentService service; // Esta classe precisa de um Pagamento Online

	public ContractService() {
		
	}
	
	public ContractService(OnlinePaymentService service) {
		this.service = service;
	}

	public void processContract(Contract contract , Integer months) {
		
		Double totalDivMonths = contract.getTotalValue() / months; // Pegando o valor total do contrato e dividindo pelo tanto de parcelas, para saber o valor de uma parcela sem as taxas
		
		for(int i = 1; i <= months; i++) {
			double a = service.interest(totalDivMonths, i); // Chamando o metodo que calcula o juros
			double b = service.paymentFee(a + totalDivMonths); // Chamando o metodo que calcula a taxa, enviando o juros(a) e o valor da parcela sem juros ou taxas
			
			contract.setDate(contract.getDate().plusMonths(1 * i)); //Adicionando 1 mes na data para o vencimento da fatura ser 1 mês apos a data do contrato.
			
			Installment installments = new Installment(contract.getDate(), (b)); //Instanciando a fatura enviando o valor já com os juros e a data já modificada
			
			contract.addInstallment(installments); // Chamando o metodo para adicionar parcelas ao contrato
			
			contract.setDate(contract.getDate().minusMonths(i)); // Voltando com o data correta do contrato, apos a geração da fatura
		}	
		

	}
	
	
	
	
	
}
