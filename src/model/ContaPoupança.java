package model;

import lombok.Data;

@Data
public class ContaPoupança extends Account {
	private Double income;
	
	public Double sacar(Double value) {
		if(this.balance >= value) {
			this.balance -= value;
		}
		return this.balance;
	}
	
	public Double depositar (Double value) {
		return this.balance += value;
	}
	
	public Double transferir(Account account, Double value) {
		if(this.balance >= value) {
			this.sacar(value);
			account.depositar(value);
		}
		
		return this.balance;
	}
		
	public Double calculaIncome(Double balance) {
		if(balance == 0.0) {
			this.income = 0.0;
			}
		else {
			this.income = balance*0.01;
			}
		return this.income;
		}

}