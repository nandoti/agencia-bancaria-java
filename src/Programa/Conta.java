package Programa;

import utilitarios.Utils;

public class Conta {

    private static int contDeContas = 1;

    private int numeroConta;
    private Cliente pessoa;
    private  Double saldo = 0.0;

    public Conta(Cliente pessoa) {
        this.numeroConta = contDeContas;
        this.pessoa = pessoa;
        contDeContas += 1;
    }

    public static int getContDeContas() {
        return contDeContas;
    }

    public static void setContDeContas(int contDeContas) {
        Conta.contDeContas = contDeContas;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getPessoa() {
        return pessoa;
    }

    public void setPessoa(Cliente pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNúmero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.getPessoa() +
                "\nCPF: " + this.pessoa.getCPF() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    // Métodos

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o depósito.");
        }
    }
    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o saque.");
        }
    }
    public void transferencia(Conta contaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo()>= valor){
            setSaldo(getSaldo() - valor);

            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            System.out.println("Transfeência realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar a transferência.");
        }
    }
}
