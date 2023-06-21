package programa;

import utilitarios.Utils;

public class Conta {

	private static int contadorDeContas = 1;

	private int numeroConta;
	private Pessoa pessoa;
	private double saldo = 0.0;

	public Conta(Pessoa pessoa) {
		this.numeroConta = contadorDeContas;
		this.pessoa = pessoa;
		contadorDeContas += 1;

	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;

	}

	public String toString() {
		return "\nNúmero da conta: " + this.getNumeroConta() + "\nNome: " + this.pessoa.getNome() + "\nCPF: "
				+ this.pessoa.getCpf() + "\nEmail: " + this.pessoa.getEmail() + "\nSaldo: "
				+ Utils.doubleToString(this.getSaldo()) + "\n";
	}

	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realizado com sucesso!");
		} else {
			System.out.println("Não foi possivel realizar o depóosito!");
		}
	}

	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("Saque não realizado!");
		}	
	}
	
	public void transferir (Conta contaParaDeposito, Double valor) {
		if (valor >0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferencia realizada com sucesso");
		}else {
			System.out.println("Transferencia não realizada");
		}
	}
	
}
