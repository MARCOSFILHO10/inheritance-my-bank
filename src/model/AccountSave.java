package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class AccountSave extends Account{

	private Long id;
	private String number;
	private String agency;
	private Double balance;
	private Client client;
	private Double tax;
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public Double sacar(Double value) {
		if (this.balance >= value) {
			this.balance -= value;
		}
		this.transactions.add(createTransaction(this, value, "Saque", LocalDateTime.now()));
		return this.balance;
	}

	public Double depositar(Double value) {
		this.transactions.add(createTransaction(this, value, "Deposito", LocalDateTime.now()));
		return this.balance += value;
	}

	public Double transferir(Account account, Double value) {
		if (this.balance >= value) {
			this.sacar(value);
			account.depositar(value);
		}
		this.transactions.add(createTransaction(this, value, "Transferência", LocalDateTime.now()));
		return this.balance;
	}
	
	public List<Transaction> transacoes(){
		return this.transactions;
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