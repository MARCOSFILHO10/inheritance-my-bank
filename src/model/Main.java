package model;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Client client = new Client();
		client.setId(1L);
		client.setName("JoŃo da Silva");
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

		
		ContaPoupanša contaPoupanša = new ContaPoupanša();
		contaPoupanša.setId(2L);
		contaPoupanša.setAgency(2424);
		contaPoupanša.setNumber(2222);
		contaPoupanša.setBalance(1200.0);
		contaPoupanša.setClient(client);
		
		System.out.println("Rendimento: " + contaPoupanša.calculaIncome(conta.getBalance()));
	}

}