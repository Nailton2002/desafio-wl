package br.com.apirestwl.model;

public class Teste {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setItem1CafeManha("leite");
		funcionario.setItem2CafeManha("leite");
		System.out.println("Funcionario com, " + funcionario.compararItens());
		
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setItem1CafeManha("Pão");
		funcionario1.setItem2CafeManha("Café");
		System.out.println("Funcionario com, " + funcionario1.compararItens());
	}

}
