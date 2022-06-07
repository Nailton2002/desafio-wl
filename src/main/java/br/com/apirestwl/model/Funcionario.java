package br.com.apirestwl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@NotBlank(message = "Cpf é obrigatório")
	@CPF(message = "CPF invalido")
	private String cpf;

	@NotBlank(message = "Item obrigatório")
	private String item1CafeManha;

	private String item2CafeManha;

	public String compararItens() {
		if (item1CafeManha == item2CafeManha) {
			return "Itens iguais não pode!";
		}
		return "Itens diferentes pode!";
	}

	public Funcionario() {
	}

	public Funcionario(String nome, String cpf, String itens1String, String item1CafeManha, String item2CafeManha) {
		this.nome = nome;
		this.cpf = cpf;
		this.item1CafeManha = item1CafeManha;
		this.item2CafeManha = item2CafeManha;
	}

	public String getItem2CafeManha() {
		return item2CafeManha;
	}

	public void setItem2CafeManha(String item2CafeManha) {
		this.item2CafeManha = item2CafeManha;
	}

	public String getItem1CafeManha() {
		return item1CafeManha;
	}

	public void setItem1CafeManha(String item1CafeManha) {
		this.item1CafeManha = item1CafeManha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", item2CafeManha=" + item2CafeManha
				+ ", item1CafeManha=" + item1CafeManha + "]";
	}

}
