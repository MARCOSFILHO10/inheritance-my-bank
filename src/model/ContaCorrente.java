package model;

import lombok.Data;

@Data
public class ContaCorrente extends Account {
	private Double taxa;
	
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
	
	public Double calculaTaxa(Double balance) {
		if (balance > 1000) {
			this.taxa = 5.0;
		} else {
			this.taxa = 10.0;
		}
		return this.taxa;
	}

	@Override
	public String toString() {
		return "ContaCorrente [\nId: " + getId() + "\nAgency: " + getAgency() +"\n number: "+ getNumber()+ "\n client:" +getClient()
		+  "]";
	}
	
	
}