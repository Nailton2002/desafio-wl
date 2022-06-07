package br.com.apirestwl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirestwl.model.Funcionario;
import br.com.apirestwl.repository.FuncionarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping
	public ResponseEntity<List<Funcionario>> ListaFuncionario() {

		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<Funcionario> buscarPorId(@RequestParam(name = "id") Long id) {

		Funcionario funcionario = funcionarioRepository.findById(id).get();
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping("/nome")
	public ResponseEntity<List<Funcionario>> buscarPorNome(@RequestParam(name = "name") String name) {

		List<Funcionario> funcionario = funcionarioRepository.buscarPorNome(name.trim().toUpperCase());
		return new ResponseEntity<List<Funcionario>>(funcionario, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<String> salvar(@RequestBody @Validated Funcionario funcionario) {

		Funcionario funcionarioCpfExistente = this.getFuncionario(funcionario.getCpf());
		
		if (funcionarioCpfExistente == null) {
			funcionarioRepository.save(funcionario);
			return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.CREATED);
			
		} else {
			return new ResponseEntity<String>("Já existe este cpf", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody Funcionario funcionario) {

		if (funcionario.getId() == null) {
			return new ResponseEntity<String>("Id não foi informado para atualização.", HttpStatus.OK);
		}
		Funcionario funcionarios = funcionarioRepository.saveAndFlush(funcionario);
		return new ResponseEntity<Funcionario>(funcionarios, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletar( @RequestParam Long id) {

		funcionarioRepository.deleteById(id);
		return new ResponseEntity<String>("Deletado com sucesso!", HttpStatus.OK);
	}

	public Funcionario getFuncionario(String cpf) {
		return this.funcionarioRepository.buscarPorCpf(cpf);
	}

}
