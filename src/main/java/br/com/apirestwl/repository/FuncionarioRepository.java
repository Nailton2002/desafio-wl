package br.com.apirestwl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.apirestwl.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	@Query(value = "select f from Funcionario f where upper(trim(f.nome)) like %?1%")
	List<Funcionario> buscarPorNome(String name);

	@Query(value = "select f from Funcionario f where upper(trim(f.cpf)) like %?1%")
	Funcionario buscarPorCpf(String cpf);

}
