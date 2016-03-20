/*
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vini
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa_fisica")
public class PessoaFisica  extends Pessoa implements Serializable {
    @NotBlank(message = "Rg deve ser informado")
    @Length(max = 11, message = "Rg invalido, ultrapassou {max} caracteres")
    @Column(name = "rg" ,nullable = false, length=11 )
    private String rg;
    
    @NotBlank(message = "CPF deve ser informado")
    @Length(max = 14, message = "CPF invalido, ultrapassou {max} caracteres")
    @Column(name = "cpf" ,nullable = false, length=14,unique = true)
    private String cpf;
    
    @Column(name = "nascimento", nullable = false)
    @NotNull(message = "Nascimento deve ser informado!")
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    
    @ManyToMany
    @JoinTable(name = "desejos", 
            joinColumns = @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "produto",referencedColumnName = "id", nullable = false)) 
    private List<Produto> desejos = new ArrayList();
    

    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public List<Produto> getDesejos() {
        return desejos;
    }

    public void setDesejos(List<Produto> desejos) {
        this.desejos = desejos;
    }
    
}
