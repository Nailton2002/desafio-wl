package br.com.apirestwl.model;

public class Teste {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setIten1CafeManha("leite");
		funcionario.setIten2CafeManha("leite");
		System.out.println("Funcionario com, " + funcionario.compararItens());
		
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setIten1CafeManha("Pão");
		funcionario1.setIten2CafeManha("Café");
		System.out.println("Funcionario com, " + funcionario1.compararItens());
	}

}
