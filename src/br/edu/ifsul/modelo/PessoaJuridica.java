/*
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
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
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable {

    @NotBlank(message = "IE deve ser informado")
    @Length(max = 11, message = "IE invalido, ultrapassou {max} caracteres")
    @Column(name = "ie", nullable = false, length = 11)
    private String ie;

    @NotBlank(message = "CNPJ deve ser informado")
    @Length(max = 17, message = "CNPJ invalido, ultrapassou {max} caracteres")
    @Column(name = "cnpj", nullable = false, length = 14, unique = true)
    private String cnpj;

    @NotBlank(message = "Razao social deve ser informado")
    @Length(max = 70, message = "razao Social invalido, ultrapassou {max} caracteres")
    @Column(name = "razaosocial", nullable = false, length = 70, unique = true)
    private String razaosocial;

    @Column(name = "fundacao", nullable = false)
    @NotNull(message = "fundacao deve ser informado!")
    @Temporal(TemporalType.DATE)
    private Calendar fundacao;

    
    @OneToMany(mappedBy = "representanteID.juridica", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Representante> representantes = new ArrayList<>();
//    
//    public void gravarRepresentate(){
//        
//        RepresentanteID rep = new Representante();
//        
//    }
    public PessoaJuridica() {
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public Calendar getFundacao() {
        return fundacao;
    }

    public void setFundacao(Calendar fundacao) {
        this.fundacao = fundacao;
    }

    public List<Representante> getRepresentante() {
        return representantes;
    }

    public void setRepresentante(List<Representante> representante) {
        this.representantes = representante;
    }

}
