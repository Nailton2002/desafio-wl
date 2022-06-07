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

	@NotBlank(message = "Iten obrigatório")
	private String iten1CafeManha;

	private String iten2CafeManha;

	public String compararItens() {
		if (iten1CafeManha == iten2CafeManha) {
			return "Itens iguais não pode!";
		}
		return "Itens diferentes pode!";
	}

	public Funcionario() {
	}

	public Funcionario(String nome, String cpf, String itens1String, String iten1CafeManha, String iten2CafeManha) {
		this.nome = nome;
		this.cpf = cpf;
		this.iten1CafeManha = iten1CafeManha;
		this.iten2CafeManha = iten2CafeManha;
	}

	public String getIten2CafeManha() {
		return iten2CafeManha;
	}

	public void setIten2CafeManha(String iten2CafeManha) {
		this.iten2CafeManha = iten2CafeManha;
	}

	public String getIten1CafeManha() {
		return iten1CafeManha;
	}

	public void setIten1CafeManha(String iten1CafeManha) {
		this.iten1CafeManha = iten1CafeManha;
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
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", iten2CafeManha=" + iten2CafeManha
				+ ", iten1CafeManha=" + iten1CafeManha + "]";
	}

}
