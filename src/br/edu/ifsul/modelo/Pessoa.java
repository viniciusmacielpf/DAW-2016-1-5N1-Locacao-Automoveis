/*
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vini
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")

public abstract class Pessoa implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome",nullable = false,length = 50)
    @NotBlank(message = "Informe um nome valido!")
    @Length(max=50, message = "o nome não deve ultrapassar {max} caracteres")
    private String nome;
    
    @Column(name = "endereco",nullable = true,length = 100)
    @NotBlank(message = "Informe um endereco valido!")
    @Length(max=50, message = "o endereço não deve ultrapassar {max} caracteres")
    private String endereco;
    
    @Column(name = "email",nullable = false,length = 50)
    @Email(message = "Informe um email valido!")
    @NotBlank(message = "Informe um email!")
    @Length(max=50, message = "o nome não deve ultrapassar {max} caracteres")
    private String email;
    
    @Column(name = "bairro",nullable = false,length = 50)
    @NotBlank(message = "Informe um bairro00ooo!")
    @Length(max=50, message = "o bairro não deve ultrapassar {max} caracteres")
    private String bairro;
   
    @Column(name = "cep",nullable = false,length = 8)
    @NotBlank(message = "Informe um cep valido!")
    @Length(max=9, message = "o cep não deve ultrapassar {max} caracteres")
    
    private String cep;
    
    @Column(name = "complemento",nullable = false,length = 8)
    private String complemento;
    
    @ManyToOne
    @JoinColumn(name="cidade" ,referencedColumnName = "id", nullable = false)
    @NotNull(message = "Informe a cidade")
    private Cidade cidade;
    
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();
    
    public Pessoa() {
    }
    
    public void addTelefone(Telefone obj){
        obj.setPessoa(this);
        this.telefones.add(obj);
    }
    
    public void removeTelefone(int index){
        this.telefones.remove(index);
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", email=" + email + ", bairo=" + bairro + ", cep=" + cep + ", complemento=" + complemento + '}';
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

}
