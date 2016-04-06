/*
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author Vini
 */
@Embeddable

public class RepresentanteID implements Serializable {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.juridica);
        hash = 59 * hash + Objects.hashCode(this.fisica);
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
        final RepresentanteID other = (RepresentanteID) obj;
        if (!Objects.equals(this.juridica, other.juridica)) {
            return false;
        }
        if (!Objects.equals(this.fisica, other.fisica)) {
            return false;
        }
        return true;
    }


    @NotNull(message = "Pessoa Juridica deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_juridica", referencedColumnName = "id", nullable = false)
    private PessoaJuridica juridica;

    @NotNull(message = "Pessoa fisica deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false)
    private PessoaFisica fisica;
    
    
    public RepresentanteID() {
    }

    public PessoaJuridica getJuridica() {
        return juridica;
    }

    public void setJuridica(PessoaJuridica juridica) {
        this.juridica = juridica;
    }

    public PessoaFisica getFisica() {
        return fisica;
    }

    public void setFisica(PessoaFisica fisica) {
        this.fisica = fisica;
    }

    
}
