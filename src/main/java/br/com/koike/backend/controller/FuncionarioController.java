package br.com.koike.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.koike.backend.exception.ResourceNotFoundException;
import br.com.koike.backend.model.Funcionario;
import br.com.koike.backend.repository.FuncionarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



/**
 * FuncionarioController
 */
@RestController
@CrossOrigin( origins = "localhost:8080" )
@RequestMapping("api/v1")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping(value="/funcionarios")
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @GetMapping(value="/funcionarios/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable(value = "id") Long funcionarioId) throws ResourceNotFoundException {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow( () -> new ResourceNotFoundException("Funcionario nao encontrado:" + funcionarioId));
        return ResponseEntity.ok().body(funcionario);
    }

    @PostMapping(value="/funcionarios")
    public Funcionario createFuncionario(@Valid @RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
    
    @PutMapping(value="funcionario/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable(value = "id") Long funcionarioId, @Valid @RequestBody Funcionario funcionarioDetails) throws ResourceNotFoundException {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow( () -> new ResourceNotFoundException("Funcionario nao encontrado:" + funcionarioId));

        funcionario.setNome(funcionarioDetails.getNome());
        funcionario.setSobrenome(funcionarioDetails.getSobrenome());
        funcionario.setEmail(funcionarioDetails.getEmail());
        final Funcionario updatedFuncionario = funcionarioRepository.save(funcionario);

        return ResponseEntity.ok(updatedFuncionario);
    }
    
    @DeleteMapping("/funcionarios/{id}")
    public Map<String, Boolean> deleteFuncionario(@PathVariable(value = "id") Long funcionarioId)
         throws ResourceNotFoundException {
        Funcionario employee = funcionarioRepository.findById(funcionarioId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + funcionarioId));

        funcionarioRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}