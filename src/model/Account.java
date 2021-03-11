package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data	
public class Account {
	private Long id;
	private Integer number;
	private Integer Agency;
	private Client client;
	public Double balance;
	private List <Transaction> transactions = new ArrayList<Transaction>();

	public Double sacar(Double value) {
		if(this.balance >= value) {
			this.balance -= value;
		}
		return this.balance;
	}
	public Double depositar (Double value){
		return this.balance += value;
	}
	public Double transferir(Account account, Double value) {
		if(this.balance >= value) {
			this.sacar(value);
			account.depositar(value);
		}
		return this.balance;
	}
	
	@SuppressWarnings("unused")
	private Transaction createTransaction(Account account, Double value, String typeTransaction,
			LocalDateTime localDateTime) {
		
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setValue(value);
		transaction.setTypeTransaction(typeTransaction);
		transaction.setDataTimeTransaction(formatDate(localDateTime.now()));
		
		return transaction;
	}
	private String formatDate(LocalDateTime date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dateNow = date.format(formatter);

		return dateNow;
	}

}
