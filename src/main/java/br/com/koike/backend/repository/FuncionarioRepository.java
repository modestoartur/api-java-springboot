package br.com.koike.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.koike.backend.model.Funcionario;

/**
 * FuncionarioRepository
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    
}