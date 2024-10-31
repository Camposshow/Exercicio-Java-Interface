package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato de data para o padrão brasileiro
	
	private Integer number;
	private LocalDate date;
	private Double totalValue;
	
	private List<Installment> installments = new ArrayList<>(); // Composição
	

	public Contract() {
		
	}

	public Contract(Integer number, LocalDate date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public void addInstallment(Installment installments) {
		this.installments.add(installments); //Adiciando as parcelas no contrato
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); // Função para criar grandes toStrings e manter organização
		sb.append("Numero: " + number + "\nData: " + date.format(fmt1) + "\nValor total: " + totalValue);
		sb.append("\n\nParcelas:");
		for(Installment i : installments) {
			sb.append("\n");
			sb.append(i.toString());
			
		}
		return sb.toString();
	}

	
	
	
}
