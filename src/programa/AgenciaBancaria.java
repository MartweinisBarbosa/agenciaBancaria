package programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {
		System.out.println("____________________________________");
		System.out.println("_____BEM VINDOS A NOSSA AGÊNCIA_____");
		System.out.println("____________________________________");
		System.out.println("_____SELECIONE UMA OPERAÇÃO PARA ___");
		System.out.println("|   OPÇÃO 01 - CRIAR CONTA         |");
		System.out.println("|   OPÇÃO 02 - DEPOSITAR           |");
		System.out.println("|   OPÇÃO 03 - SACAR               |");
		System.out.println("|   OPÇÃO 04 - TRANSFERIR          |");
		System.out.println("|   OPÇÃO 05 - LISTAR              |");
		System.out.println("|   OPÇÃO 06 - SAIR                |");

		int operacao = input.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listar();
			break;
		case 6:
			System.out.println("AGRADECEMOS A PREFERENCIA");
			System.exit(0);

		default:
			System.out.println("OPÇÃO INVALIDA!");
			operacoes();
			break;
		}
	}

	public static void criarConta() {

		System.out.println("\nNome: ");
		String nome = input.next();

		System.out.println("\nCPF:  ");
		String cpf = input.next();

		System.out.println("\nEMAIL ");
		String email = input.next();

		Pessoa pessoa = new Pessoa(nome, cpf, email);

		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);
		System.out.println("CONTA CRIADA COM SUCESSO!");

		operacoes();
	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta)
					;
				conta = c;
			}
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual valor do deposito?:");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Deposito realizado com sucesso!");
		} else {
			System.out.println("Conta não localizada");
		}
		operacoes();

	}

	public static void sacar() {
		System.out.println("Número da conta");
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual o valor do saque?: ");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
			System.out.println("Saque realizado com sucesso! ");
		} else {
			System.out.println("Saque não efetuado");
		}
		operacoes();

	}

	public static void transferir() {
		System.out.println("Conta de origem");
		int numeroContaOrigem = input.nextInt();

		Conta contaOrigem = encontrarConta(numeroContaOrigem);

		if (contaOrigem != null) {
			System.out.println("Número da conta destinataria");
			int numeroContaDestinatario = input.nextInt();

			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

			if (contaDestinatario != null) {
				System.out.println("Valor da transferencia");
				double valor = input.nextDouble();

				contaOrigem.transferir(contaDestinatario, valor);
			}
		}
		operacoes();
	}
	public static void listar() {
		if (contasBancarias.size() > 0) {
			for(Conta conta: contasBancarias) {
				System.out.println(conta);
			}
		}else{ 
			System.out.println("Conta não cadastradas");
			}
		operacoes();
		}
	}

