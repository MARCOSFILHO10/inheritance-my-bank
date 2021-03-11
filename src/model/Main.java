package model;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Client client = new Client();
		client.setId(1L);
		client.setName("João da Silva");
		client.setEmail("joaosilva@gmail.com");
		client.setPhone("83991267778");
		
		ContaCorrente conta = new ContaCorrente();
		conta.setId(1L);
		conta.setAgency(2424);
		conta.setNumber(1111);
		conta.setBalance(1200.0);
		conta.setClient(client);
		
		Transaction transaction1 = new Transaction();
		transaction1.setAccount(conta);
		transaction1.setDataTimeTransaction("09/03/2021");
		transaction1.setTypeTransaction("Deposito");
		transaction1.setValue(500.0);
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction1);
		conta.setTransactions(transactions);
		
		
		System.out.println(conta);
		System.out.println("Taxa: " + conta.calculaTaxa(conta.getBalance()));

		
		ContaPoupança contaPoupança = new ContaPoupança();
		contaPoupança.setId(2L);
		contaPoupança.setAgency(2424);
		contaPoupança.setNumber(2222);
		contaPoupança.setBalance(1200.0);
		contaPoupança.setClient(client);
		
		System.out.println("Rendimento: " + contaPoupança.calculaIncome(conta.getBalance()));
	}

}