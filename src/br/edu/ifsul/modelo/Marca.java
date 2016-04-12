/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vini
 */
//anotações e definições
@Entity
@Table(name="marca")

public class Marca implements Serializable{
    @Id
    //Inicio geração autoincrement
    @SequenceGenerator(name = "seq_marca", sequenceName="seq_marca_id", allocationSize = 1)
    @GeneratedValue(generator ="seq_marca",strategy = GenerationType.SEQUENCE)
    // fim autoincrement
    private Integer id;
    @Column(name="nome", length = 50, nullable = false)
    @NotBlank(message = "Informe um nome valido!")
    @Length(max=50, message = "o nome não deve ultrapassar {max} caracteres")
    private String nome;

    @Column(name="nacionalidade", length = 100, nullable = false)
    @NotBlank(message = "Informe uma nacionalidade!")
    @Length(max=100, message = "o nacionalidade não deve ultrapassar {max} caracteres")
    private String nacionalidade;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    public Marca() {
    
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Macra{" + "nome=" + nome + '}';
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    
}
