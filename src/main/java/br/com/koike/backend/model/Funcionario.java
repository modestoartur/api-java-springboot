package br.com.koike.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Funcionario
 */
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
    
    private long id;
    private String nome;
    private String sobrenome;
    private String email;
    

    /** CONSTRUTORES */
    public Funcionario() {
    }

	public Funcionario(long id, String nome, String sobrenome, String email) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
    }
    
	public void setId(long id) {
		this.id = id;
	}

    @Column( name = "NOME")
	public String getNome() {
		return nome;
    }
    
	public void setNome(String nome) {
		this.nome = nome;
	}

    @Column( name = "SOBRENOME")
	public String getSobrenome() {
		return sobrenome;
    }
    
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

    @Column( name = "EMAIL")
	public String getEmail() {
		return email;
    }
    
	public void setEmail(String email) {
		this.email = email;
	}
}